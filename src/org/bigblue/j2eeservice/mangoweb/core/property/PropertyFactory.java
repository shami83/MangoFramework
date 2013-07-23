package org.bigblue.j2eeservice.mangoweb.core.property;

public class PropertyFactory {
	
	/* Although violation of open close principle.
	 *  But we use kind of a factory method to get rid of multiple if else in invoker code
	 *  */
	
	public static IProperty get(String name)
	{
		IProperty prop=null;
		if(name.equals("java.lang.Long") || name.equals("long"))
		{
			System.out.println("LONG");
			prop = new LongProperty();
		}
		else if(name.equals("java.lang.String") )
		{
			System.out.println("String");
			prop = new StringProperty();
		}
		else
		{
			System.out.println("Default");
			prop = new StringProperty();
		}
		
		return prop;
	}

}
