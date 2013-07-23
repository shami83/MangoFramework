package org.bigblue.j2eeservice.mangoweb.servlet.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
	
	public String execute(HttpServletRequest request,HttpServletResponse response,Object form)throws ServletException;

}
