package com.arbormetrix.xmltojson.main;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.arbormetrix.xmltojson.bean.Patient;
import com.arbormetrix.xmltojson.bean.Patients;
import com.arbormetrix.xmltojson.util.DateTimeAdapter;
import com.arbormetrix.xmltojson.util.PatientSerializer;
import com.arbormetrix.xmltojson.util.PropertiesUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Main class which prints the xml converted to json
 * 
 * @author
 *
 */
public class MainClass {

	/**
	 * Main method which is used to convert classpath xml to json and 
	 * print in the console.
	 * Please Use Java8 version in the classpath
	 * @param args
	 * @throws JAXBException
	 * @throws IOException
	 */
	public static void main(String[] args) throws JAXBException, IOException {
		//Can get file names as command line arguments also
		DateTimeAdapter.dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Properties properties = new Properties();
		properties.load(MainClass.class.getClassLoader().getResourceAsStream("application.properties"));
		PropertiesUtil.properties = properties;
		InputStream inputStream = MainClass.class.getClassLoader().getResourceAsStream("patients.xml");
		Patients patients = convertXmlToObject(inputStream);
		System.out.println(convertObjectToJson(patients));
	}

	/**
	 * Method to convert given xml to object
	 * 
	 * @param input
	 * @return
	 * @throws JAXBException
	 */
	public static Patients convertXmlToObject(InputStream input) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Patients.class);

		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		return (Patients) unmarshaller.unmarshal(input);
	}

	/**
	 * Method to convert given object to json using the serializer
	 * 
	 * @param input
	 * @return
	 * @throws JAXBException
	 */
	public static String convertObjectToJson(Patients patients) {
		GsonBuilder gsonBuilder = new GsonBuilder().registerTypeHierarchyAdapter(Patient.class,
				new PatientSerializer());
		gsonBuilder.setPrettyPrinting();
		gsonBuilder.disableHtmlEscaping();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = gsonBuilder.create();
		return gson.toJson(patients.getPatients(), List.class);
	}

}
