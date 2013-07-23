package org.bigblue.j2eeservice.mangoweb.core;

public class View {
	
	private String resolver;
	private String prefix;
	private String suffix;
	public String getResolver() {
		return resolver;
	}
	public void setResolver(String resolver) {
		this.resolver = resolver;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	@Override
	public String toString() {
		return "View [resolver=" + resolver + ", prefix=" + prefix
				+ ", suffix=" + suffix + "]";
	}
	
	
	

}
