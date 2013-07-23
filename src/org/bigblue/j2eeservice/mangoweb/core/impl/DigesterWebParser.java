package org.bigblue.j2eeservice.mangoweb.core.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.xmlrules.FromXmlRulesModule;
import org.apache.commons.io.FileUtils;
import org.bigblue.j2eeservice.mangoweb.core.ControllerDefImpl;
import org.bigblue.j2eeservice.mangoweb.core.Forward;
import org.bigblue.j2eeservice.mangoweb.core.IParser;
import org.bigblue.j2eeservice.mangoweb.core.Interceptor;
import org.bigblue.j2eeservice.mangoweb.core.Mango;
import org.bigblue.j2eeservice.mangoweb.core.View;
import org.bigblue.j2eeservice.mangoweb.exception.MangoFrameworkException;
import org.xml.sax.SAXException;

public class DigesterWebParser implements IParser{
	
	private static DigesterWebParser parser = new DigesterWebParser();
	
	private DigesterWebParser()
	{
		
	}
	public static DigesterWebParser getInstance()
	{
		return parser;
	}
	public Digester digester;
	
	private Digester getDigester()
	{
		if(digester == null)
		{
			digester = createRuleDigester();
		}
		return digester;
	}
	
	private Digester createRuleDigester()
	{
		Digester digester = new Digester();
		digester.addObjectCreate( "mango", Mango.class );
	    digester.addObjectCreate( "mango/view", View.class );
        digester.addSetProperties("mango/view");
        digester.addSetNext( "mango/view", "addView" );
        digester.addObjectCreate( "mango/interceptor", Interceptor.class );
        digester.addSetProperties("mango/interceptor");
        digester.addSetNext( "mango/interceptor", "addInterceptor" );
        digester.addObjectCreate( "mango/controller", ControllerDefImpl.class );
        digester.addSetProperties("mango/controller");
        digester.addObjectCreate( "mango/controller/forward", Forward.class );
        digester.addSetProperties("mango/controller/forward");
        digester.addSetNext( "mango/controller/forward", "addForward" );
        digester.addSetNext( "mango/controller", "addController" );
	    return digester;
     }
	
	public Object parse(String... conFigXmlLocation) throws MangoFrameworkException
	{
		Mango mango = null;
		try
		{
			String location = conFigXmlLocation[0];
			InputStream in = this.getClass().getClassLoader().getResourceAsStream(location);
			System.out.println();
			mango = getDigester().parse(in);
			
		}
		catch(IOException ex)
		{
			throw new MangoFrameworkException("Input File Notfound chack is it in WEB_INF or custom location mentioned in MangoActionServlet mapping");
		}
		catch(SAXException ex)
		{
			throw new MangoFrameworkException("Check your mango-config.xml it is not written properly");
		}
		catch(Exception ex)
		{
			throw new MangoFrameworkException("Input File Notfound check is it in WEB-INF or custom location mentioned in MangoActionServlet mapping");
		}
		
		 return mango;
	}
	
	public static void main(String[] args) {
		try
		{
			Mango root = (Mango)DigesterWebParser.getInstance().parse("resources/mango-config.xml");
			System.out.println(root);
			ControllerDefImpl impl = root.getController("/hello");
			System.out.println(impl);
		}
		catch(MangoFrameworkException ex)
		{
			ex.printStackTrace();
			ex.getMessage();
		}
		
	}
	

}
