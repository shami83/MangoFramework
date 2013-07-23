package org.bigblue.j2eeservice.mangoweb.test;

public class BindObject {
	
	private String name;
	private long value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "BindObject [name=" + name + ", value=" + value + "]";
	}
	
	

}
