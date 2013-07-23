package org.bigblue.j2eeservice.mangoweb.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bigblue.j2eeservice.mangoweb.core.aop.IAdvice;
import org.bigblue.j2eeservice.mangoweb.core.aop.impl.GenericProxyFactory;
import org.bigblue.j2eeservice.mangoweb.servlet.action.IAction;

public class TestAction implements IAction {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, Object form) throws ServletException {
		System.out.println("In execute");
		return null;
	}

}
