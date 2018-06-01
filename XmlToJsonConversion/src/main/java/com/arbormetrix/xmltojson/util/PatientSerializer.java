package com.arbormetrix.xmltojson.util;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.arbormetrix.xmltojson.bean.Patient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Json Serializer for patient.this is called when ever patient serialization
 * happens and it calculate age from given dob
 * 
 * @author
 *
 */
public class PatientSerializer implements JsonSerializer<Patient> {

	public static final Gson gsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

	/**
	 * This method gets involved whenever the parser encounters the Patient
	 * object (for which this serializer is registered)
	 */
	public JsonElement serialize(Patient patient, Type typeOfSrc, JsonSerializationContext context) {
		Date dob = patient.getDob();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dob);
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH));
		Period p = Period.between(birthday, today);
		patient.setAge(p.getYears());
		patient.setGender((String) PropertiesUtil.getProperty(patient.getGender()));
		patient.setState((String) PropertiesUtil.getProperty(patient.getState()));
		return gsonBuilder.toJsonTree(patient);
	}

}
