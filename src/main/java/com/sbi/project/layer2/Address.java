package com.sbi.project.layer2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/* APPLICANT_TBL
 * applicant_id	app_name appFather  .... ....... ....
 * 1			Jack
 * 2			John	
 * 3			Jane
 * 
 * ADDRESS
 * addressId	addressType	area	street	city	state	country	pin	applicant_id
 * 12			home			..											1
 * 13			temp			..											1
 * 
 * ACCOUNT
 * acno		name
 * 1234		 
 */
@Entity
@Table(name="address_tbl")
public class Address
{
	@Id
	@GeneratedValue
	private int addressid;
	private String addresstype;
	
	private String area;
	private String street;
	private String city;
	private String state;
	private String country;
	private int pin;
	
	@ManyToOne
	@JoinColumn(name="app_id")
	Applicant applicant;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@JsonIgnore
	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
	
	
	
}