package org.bigblue.j2eeservice.mangoweb.core;

import org.bigblue.j2eeservice.mangoweb.core.impl.DigesterWebParser;

public class MangoWebParserFactory implements IParserFactory{
	
	private static MangoWebParserFactory factory = new MangoWebParserFactory();
	
	private MangoWebParserFactory()
	{
		
	}
	
	public static MangoWebParserFactory getInstance()
	{
		return factory;
	}
	
	
	@Override
	public IParser get() {
		// TODO Auto-generated method stub
		return DigesterWebParser.getInstance();
	}

}
