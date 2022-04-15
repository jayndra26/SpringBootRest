package com.sbi.project.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbi.project.layer2.Applicant;


@Service
public interface ApplicantService {
	void createApplicationService(Applicant app);
	List<Applicant> getAllApplicantsService();
	void updateApplicantService(Applicant applicant);
	void deleteApplicantService(int applicantId);
	
	
}

//void createApplication(Applicant applicant);
//void modifyApplication(Applicant account);
//void removeApplication(int applicantId);
//Applicant findApplication(int applicantId);
//List<Applicant> findAllApplicants();