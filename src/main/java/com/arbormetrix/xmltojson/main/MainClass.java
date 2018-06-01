package com.arbormetrix.xmltojson.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.arbormetrix.xmltojson.bean.Patients;

public class MainClass {

	public final static String XML_FILE = "patients.xml";

	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		Patients patients = convertXmlToObject(new FileInputStream(new File(XML_FILE)));
		System.out.println(convertObjectToJson(patients));
	}
	
	public static Patients convertXmlToObject(InputStream input) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Patients.class);
		
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		return (Patients)unmarshaller.unmarshal(input);
	}
	
	public static String convertObjectToJson(Patients patient) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		gsonBuilder.disableHtmlEscaping();
		
		Gson gson = gsonBuilder.create();
		return gson.toJson(patient, Patients.class);
	}
	
} 
