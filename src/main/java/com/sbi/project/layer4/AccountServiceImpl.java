package com.sbi.project.layer4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.project.layer2.Account;
import com.sbi.project.layer2.Applicant;
import com.sbi.project.layer2.ApplicationStatus;
import com.sbi.project.layer3.AccountRepository;
import com.sbi.project.layer3.ApplicantRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	ApplicantRepository appRepo;
	
	@Autowired
	AccountRepository accRepo;
	

	public void openBankAccountService(int applicantId) {
		
		Applicant applicant = appRepo.findApplication(applicantId);
		
		if(applicant!=null) {
			Account account = new Account(); // a blank account
			//account.setAccountNumber(number); - AUTO GENERATED - 1
			account.setAccountHolderName(applicant.getApplicantName()); //2
			account.setAccountBalnce(5000); //3
			account.setApplicant(applicant); //4
		
			applicant.setApplicationStatus(ApplicationStatus.APPROVED);
		
			appRepo.modifyApplication(applicant);
			accRepo.createAccount(account);
		}
		else {
			throw new RuntimeException("Application id not found ..."+applicantId);
		}
		
	}

}
