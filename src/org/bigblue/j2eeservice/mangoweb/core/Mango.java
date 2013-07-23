package org.bigblue.j2eeservice.mangoweb.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bigblue.j2eeservice.mangoweb.exception.MangoFrameworkException;

public class Mango {
	
	private View view;
	private List<Interceptor> interceptors = new ArrayList<Interceptor>();
	private Map<String,ControllerDefImpl> contollerMap = new HashMap<String,ControllerDefImpl>();
	public View getView() {
		return view;
	}
	public void addView(View view) {
		this.view = view;
	}
	public Map<String, ControllerDefImpl> getContollerMap() {
		return contollerMap;
	}
	public void setContollerMap(Map<String, ControllerDefImpl> contollerMap) {
		this.contollerMap = contollerMap;
	}
	
	public void addController(ControllerDefImpl impl)
	{
		this.contollerMap.put(impl.getUrl(), impl);
	}
	
	public void addInterceptor(Interceptor interceptor)
	{
		this.interceptors.add(interceptor);
	}
	
	public List<Interceptor> getInterceptors()
	{
		return interceptors;
	}
	
	
	public ControllerDefImpl getController(String uri)throws MangoFrameworkException
	{
		ControllerDefImpl impl = contollerMap.get(uri);
		if(impl == null)
		{
			throw new MangoFrameworkException("Controller can not found. Please check your requested url.");
		}
		return impl;
	}
	@Override
	public String toString() {
		return "Mango [view=" + view + ", interceptors=" + interceptors
				+ ", contollerMap=" + contollerMap + "]";
	}
	

}
