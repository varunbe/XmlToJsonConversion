package com.arbormetrix.xmltojson.util;

import java.util.Properties;

/**
 * Property util can be used to get loaded properties values for different
 * gender and state values
 * 
 * @author
 *
 */
public class PropertiesUtil {

	public static Properties properties = null;

	public static Object getProperty(String key) {
		return properties.getProperty(key);
	}

}
