package com.sbi.project.layer4;

import org.springframework.stereotype.Service;

import com.sbi.project.layer2.Account;
import com.sbi.project.layer2.Applicant;

@Service
public interface AccountService {
	void openBankAccountService(int applicantId);
}
