package com.sbi.project.layer2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component @Entity @Table(name="account_tbl")
public class Account {
	@Id	@GeneratedValue	@Column(name="acc_no")
	private int accountNumber;
	
	@Column(name="acc_name")
	private String accountHolderName;
	
	@Column(name="acc_bal")
	private float accountBalnce;
	
	@OneToOne
	@JoinColumn(name="app_id")
	Applicant applicant;
	
	

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public float getAccountBalnce() {
		return accountBalnce;
	}

	public void setAccountBalnce(float accountBalnce) {
		this.accountBalnce = accountBalnce;
	}

	
}
