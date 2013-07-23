package org.bigblue.j2eeservice.mangoweb.core;

public class Interceptor {
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Interceptor [name=" + name + "]";
	}
	
	

}
