package com.sbi.project.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbi.project.layer2.Account;
@Repository
public class AccountRepositoryImpl extends BaseRepositoryImpl implements AccountRepository {
	
	@Transactional
	public void createAccount(Account account) {
		super.persist(account);
	}
	
	public void modifyAccount(Account account) {
		super.merge(account);
	}
	public void removeAccount(int acno) {
		Account accObj = super.find(Account.class, acno);
		super.remove(accObj);
	}

	public Account findAccount(int acno) {
		return super.find(Account.class, acno);
	}

	public List<Account> findAllAccounts() {
		return super.findAll("Account");
	}
}
