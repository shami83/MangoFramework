package org.bigblue.j2eeservice.mangoweb.core.property;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.bigblue.j2eeservice.mangoweb.exception.MangoFrameworkException;

public class StringProperty implements IProperty {

	@Override
	public void setValue(Object bindObject, Field field, Object value)
			throws MangoFrameworkException {
		if(Modifier.isFinal(field.getModifiers()))
		{
			throw new MangoFrameworkException("can not set modifier is final");
		}
		
		try
		{
			field.set(bindObject, value.toString());
			
		}
		catch(Exception ex)
		{
			throw new MangoFrameworkException(ex,"check property type");
		}
		
	}

}
