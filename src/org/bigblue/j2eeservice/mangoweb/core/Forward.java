package org.bigblue.j2eeservice.mangoweb.core;

public class Forward {
	
	String key;
	String view;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	@Override
	public String toString() {
		return "Forward [key=" + key + ", view=" + view + "]";
	}
	
	

}
