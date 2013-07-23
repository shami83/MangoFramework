package org.bigblue.j2eeservice.mangoweb.core.aop.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bigblue.j2eeservice.mangoweb.core.aop.IAdvice;
import org.bigblue.j2eeservice.mangoweb.servlet.action.IAction;

public class GenericInvocationHandler<T> implements InvocationHandler{

	private IAdvice advice;
	private T target;
	private HttpServletRequest req;
	private HttpServletResponse res;
	public GenericInvocationHandler(IAdvice advice,T target,HttpServletRequest req,HttpServletResponse response)
	{
		this.advice = advice;
		this.target = target;
		this.req = req;
		this.res = res;
	}
	
	@Override
	public Object invoke(Object arg0, Method method, Object[] params)
			throws Throwable {
		Object object = null;
		String methodName = method.getName();
		if(methodName.equalsIgnoreCase("execute"))
		{
			advice.preProcess(req, res);
			object =  method.invoke(target, params);
			advice.postProcess(req, res);
		}
		return object;
	}

}
