package org.bigblue.j2eeservice.mangoweb.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.*;

import org.bigblue.j2eeservice.mangoweb.core.aop.IAdvice;
import org.bigblue.j2eeservice.mangoweb.core.aop.impl.GenericProxyFactory;
import org.bigblue.j2eeservice.mangoweb.servlet.MangoActionServlet;
import org.bigblue.j2eeservice.mangoweb.servlet.action.IAction;
import org.junit.Test;

public class TestMangoActionServlet {

	@Test
	public void testServlet() throws Exception {

		try {

			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			System.out.println("test");
			when(request.getParameter("name")).thenReturn("Shamik Mitra");
			when(request.getParameter("value")).thenReturn("30");
			BindObject obj = (BindObject) new MangoActionServlet()
					.wrapRequest(
							"org.bigblue.j2eeservice.mangoweb.test.BindObject",
							request);

			System.out.println(obj);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
	
	@Test
	public void testAop()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		List<IAdvice> list = new ArrayList<IAdvice>();
		IAdvice advice = new TestInterceptor();
		IAdvice advice2 = new TesttwoInterceptor();
		list.add(advice);
		list.add(advice2);
		System.out.println("add advice");
		GenericProxyFactory<IAction> fact = new GenericProxyFactory<IAction>();
		try {
			IAction action = fact.createProxy(list, new TestAction(), request, response);
			action.execute(request, response, null);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
