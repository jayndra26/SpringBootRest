package com.sbi.project.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbi.project.layer2.Account;
@Repository
public interface AccountRepository {
	void createAccount(Account account);
	void modifyAccount(Account account);
	void removeAccount(int acno);
	Account findAccount(int acno);
	List<Account> findAllAccounts();
}
