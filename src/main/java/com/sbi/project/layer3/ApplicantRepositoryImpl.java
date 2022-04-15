package com.sbi.project.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbi.project.layer2.Applicant;

@Repository
public class ApplicantRepositoryImpl extends BaseRepositoryImpl implements ApplicantRepository {

	@Transactional
	public void createApplication(Applicant applicant) {
		super.persist(applicant);
	}

	@Transactional
	public void modifyApplication(Applicant applicant) {
		super.merge(applicant);

	}

	@Transactional
	public void removeApplication(int applicantId) {
		Applicant appObj = super.find(Applicant.class, applicantId);
		super.remove(appObj);
	}

	
	public Applicant findApplication(int applicantId) {
		
		return super.find(Applicant.class, applicantId);
	}

	public List<Applicant> findAllApplicants() {
		return super.findAll("Applicant");
	}

}
