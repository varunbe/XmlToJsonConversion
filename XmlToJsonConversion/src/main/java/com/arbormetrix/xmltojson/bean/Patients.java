package com.arbormetrix.xmltojson.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Patients pojo to store incoming patients xml data
 * 
 * @author
 *
 */
@XmlRootElement(name = "patients")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patients {

	@XmlElement(name = "patient")
	@Expose
	private List<Patient> patients = null;

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Patients() {
		super();
	}

}
