package org.bigblue.j2eeservice.mangoweb.core.aop.impl;

import java.lang.reflect.Proxy;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bigblue.j2eeservice.mangoweb.core.aop.IAdvice;
import org.bigblue.j2eeservice.mangoweb.servlet.action.IAction;

public class GenericProxyFactory<T> {
	
	public T createProxy(List<IAdvice> adviceList,T target,HttpServletRequest req,HttpServletResponse res) throws Throwable
	{
		if(adviceList == null || adviceList.size() ==0)
		{
			return target;
		}
		
		for(IAdvice advice : adviceList)
		{
			target = getProxyObject(target,advice,req,res);
		}
		return target;
		
	}
	
	private  T getProxyObject(T target,IAdvice advice,HttpServletRequest req,HttpServletResponse res) throws Throwable {


		GenericInvocationHandler invocationHandler = new GenericInvocationHandler(advice,target,req,res);
		System.out.println(target.getClass().getClassLoader() + ":" + target.getClass().getInterfaces()+ ":" + invocationHandler);
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),invocationHandler) ;
		   }

}
