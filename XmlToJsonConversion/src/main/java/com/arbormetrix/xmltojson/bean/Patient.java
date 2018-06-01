package com.arbormetrix.xmltojson.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.arbormetrix.xmltojson.util.DateTimeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Patient pojo to store incoming xml data
 * 
 * @author
 *
 */

@XmlRootElement(name = "patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {

	@Expose
	@SerializedName("patientid")
	private int id;

	@Expose
	@SerializedName("sex")
	private String gender;

	@Expose
	@SerializedName("state")
	private String state;

	@Expose
	@SerializedName("name")
	private String name;

	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	@Expose(serialize = false, deserialize = true)
	private Date dob;

	@Expose
	@SerializedName("age")
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Patient() {
		super();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
