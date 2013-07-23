package org.bigblue.j2eeservice.mangoweb.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bigblue.j2eeservice.mangoweb.core.aop.IAdvice;

public class TestInterceptor implements IAdvice {

	@Override
	public void preProcess(HttpServletRequest request, HttpServletResponse res) {
		System.out.println("Hi Shamik");

	}

	@Override
	public void postProcess(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("bye Shamik");

	}

}
