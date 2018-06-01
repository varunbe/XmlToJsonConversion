package com.arbormetrix.xmltojson.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "patients")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patients {
	
	@XmlElement(name = "patient")
	private List<Patient> patients = null;

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
}
