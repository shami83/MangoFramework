package org.bigblue.j2eeservice.mangoweb.core.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAdvice {
	
	public void preProcess(HttpServletRequest request,HttpServletResponse res);
	public void postProcess(HttpServletRequest request,HttpServletResponse response);
	

}
