package com.sbi.project.layer2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component @Entity @Table(name="applicant_tbl")
public class Applicant {

	@Id
	@GeneratedValue
	@Column(name="applicant_id")
	private int applicantId;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="applicant_name")
	private String applicantName;
	
	@Column(name="applicant_father")
	private String applicantFatherName;
	
	@Column(name="applicant_dob")
	private LocalDate applicantBirthdate;
		
	@Column(name="applicant_mobile")
	private String mobileNumber;
	
	@Column(name="applicant_married")
	private String married; 
	
	@Column(name="applicant_occupation")
	private String occupation;
	
	@OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
	List<Address> addressList = new ArrayList<Address>();
	
	@Column(name="applicant_adhaar")
	private String adhaarNumber; //address proof
	
	@Column(name="applicant_pan")
	private String panCard; // pan number
	
	@Column(name="applicant_photo")
	private String photo; // photo - actual photo
	
	@Column(name="applicant_annual_income")
	private double annualIncome;
	
	private String applicationStatus; // PENDING IN_PROGRESS APPROVED REJECTED
		
	public String getApplicationStatus()  {
		return applicationStatus;
	}
	
	public void setApplicationStatus(String status)  {
		applicationStatus=status;
	}
	
	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantFatherName() {
		return applicantFatherName;
	}

	public void setApplicantFatherName(String applicantFatherName) {
		this.applicantFatherName = applicantFatherName;
	}

	public LocalDate getApplicantBirthdate() {
		return applicantBirthdate;
	}

	public void setApplicantBirthdate(LocalDate applicantBirthdate) {
		this.applicantBirthdate = applicantBirthdate;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public String getAdhaarNumber() {
		return adhaarNumber;
	}

	public void setAdhaarNumber(String adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	
	
	
}
