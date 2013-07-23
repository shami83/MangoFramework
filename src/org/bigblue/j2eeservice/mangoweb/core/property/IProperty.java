package org.bigblue.j2eeservice.mangoweb.core.property;

import java.lang.reflect.Field;

import org.bigblue.j2eeservice.mangoweb.exception.MangoFrameworkException;

public interface IProperty {
	
	public void setValue(Object bindObject,Field field,Object value)throws MangoFrameworkException;

}
