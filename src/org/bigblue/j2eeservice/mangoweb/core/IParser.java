package org.bigblue.j2eeservice.mangoweb.core;

import java.io.IOException;

import org.bigblue.j2eeservice.mangoweb.exception.MangoFrameworkException;
import org.xml.sax.SAXException;

public interface IParser {
	// define input parameter as varags because in near future we are going to support multiple config file.
	public Object parse(String... conFigXmlLocation) throws MangoFrameworkException;

}
