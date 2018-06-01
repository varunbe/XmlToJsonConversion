package com.arbormetrix.xmltojson.util;

import java.text.DateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter to marshal and unmarshal patient date fields
 * 
 * @author
 *
 */
public class DateTimeAdapter extends XmlAdapter<String, Date> {

	public static DateFormat dateFormat;

	@Override
	public Date unmarshal(String xml) throws Exception {
		return dateFormat.parse(xml);
	}

	@Override
	public String marshal(Date object) throws Exception {
		return dateFormat.format(object);
	}

}
