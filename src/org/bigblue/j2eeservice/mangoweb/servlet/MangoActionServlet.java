package org.bigblue.j2eeservice.mangoweb.servlet;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bigblue.j2eeservice.mangoweb.core.ControllerDefImpl;
import org.bigblue.j2eeservice.mangoweb.core.IParser;
import org.bigblue.j2eeservice.mangoweb.core.Mango;
import org.bigblue.j2eeservice.mangoweb.core.MangoWebParserFactory;
import org.bigblue.j2eeservice.mangoweb.core.property.IProperty;
import org.bigblue.j2eeservice.mangoweb.core.property.PropertyFactory;
import org.bigblue.j2eeservice.mangoweb.exception.MangoFrameworkException;
import org.xml.sax.SAXException;

public class MangoActionServlet extends HttpServlet{
	
	 Mango mango;
	
	 private final String CONFIG="config";
	 private final String DEFULT_CONFIG_LOC ="/WEB_INF/mango-config.xml";
	 
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		try 
		{
			String xmlLoc = config.getInitParameter(CONFIG);
			xmlLoc = xmlLoc == null ?DEFULT_CONFIG_LOC:xmlLoc;
			createMango(xmlLoc);
			super.init();
			
		}
		catch(MangoFrameworkException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException
	{
		try
		{
			
			String requestedResource = req.getRequestURI();
			System.out.println(this.getClass() + ":"+ requestedResource);
			ControllerDefImpl beanDef = mango.getController(requestedResource);
			// try to get binding object where request parameter will automatic type cast and wrap
			
			String bindingObjectClassName = beanDef.getBindObject();
			Object bindObject = wrapRequest(bindingObjectClassName,req);
			
		}
		catch(MangoFrameworkException ex)
		{
			throw new ServletException(ex);
		}
		catch(ClassNotFoundException ex)
		{
			throw new ServletException(new MangoFrameworkException(ex,"Binding class not found. Check your classpath"));
		} catch (IllegalArgumentException ex) {
			throw new ServletException(ex);
		
		}catch (IllegalAccessException ex) {
			throw new ServletException(ex);
		} catch (InstantiationException ex) {
			throw new ServletException(ex);
		} catch (InvocationTargetException ex) {
			throw new ServletException(ex);
		} catch (IntrospectionException ex) {
			throw new ServletException(ex);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
		
		doGet(req,res);
	}
	
	private void createMango(String xmlLoc) throws MangoFrameworkException 
	{
		IParser parser = MangoWebParserFactory.getInstance().get();
		Mango mango =(Mango)parser.parse(xmlLoc);
		this.mango = mango;
		
	}
	
	public Object wrapRequest(String clazz,HttpServletRequest req) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException, MangoFrameworkException, InvocationTargetException, IntrospectionException
	{
		Class bindObjectClass = Class.forName(clazz);
        Object bindObject = bindObjectClass.newInstance();
        BeanInfo info =  Introspector.getBeanInfo(bindObject.getClass( ));
        PropertyDescriptor[  ] props = info.getPropertyDescriptors( );
        for(PropertyDescriptor prop : props)
        {
       
            System.out.println(prop.getName() +":"+ prop.getPropertyType().getName());
            PropertyEditor editor = PropertyEditorManager.findEditor(prop.getPropertyType());
            System.out.println(editor);
            if(editor == null)
            {
                continue;
            }
            String value = req.getParameter(prop.getName());
            editor.setAsText(value);
            Method setter = prop.getWriteMethod( ); 
            setter.invoke(bindObject, new Object[  ] { editor.getValue()});
           
        }
      //  System.out.println(bindObject);   
		
		return bindObject;
	}

}
