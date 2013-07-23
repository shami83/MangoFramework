package org.bigblue.j2eeservice.mangoweb.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerDefImpl {
	
	private String name;
	private String url;
	private String bindObject;
	private Map<String,Forward> forwarMap = new HashMap<String,Forward>();

	public Map<String, Forward> getForwarMap() {
		return forwarMap;
	}
	public void setForwarMap(Map<String, Forward> forwarMap) {
		this.forwarMap = forwarMap;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void addForward(Forward forward){
		
		this.forwarMap.put(forward.getKey(), forward);
		
	}
			
	public String getBindObject() {
		return bindObject;
	}
	public void setBindObject(String bindObject) {
		this.bindObject = bindObject;
	}
	@Override
	public String toString() {
		return "ControllerDefImpl [name=" + name + ", url=" + url
				+ ", bindObject=" + bindObject + ", forwarMap=" + forwarMap
				+ "]";
	}
	
	

}
