package com.sbi.project.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.project.layer2.Applicant;
import com.sbi.project.layer3.ApplicantRepository;


@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	ApplicantRepository appRepo;
	
	@Override
	public void createApplicationService(Applicant app) {
		
		appRepo.createApplication(app);
		System.out.println("ApplicantServiceImpl() : created the applicants data.....");

	}
	
	public List<Applicant> getAllApplicantsService() {
		return appRepo.findAllApplicants();
	}

	@Override
	public void updateApplicantService(Applicant applicant) {
		// TODO Auto-generated method stub
		appRepo.modifyApplication(applicant);
		
	}

	@Override
	public void deleteApplicantService(int applicantId) {
		// TODO Auto-generated method stub
		appRepo.removeApplication(applicantId);
		
	}

}
