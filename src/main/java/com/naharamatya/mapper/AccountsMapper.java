package com.naharamatya.mapper;

import com.naharamatya.dto.AccountsDTO;
import com.naharamatya.entity.Accounts;

public class AccountsMapper {
	
	public static AccountsDTO mapToAccountsDto (Accounts accounts, AccountsDTO accountsDto) {
		accountsDto.setAccountNo(accounts.getAccountNo());
		accountsDto.setAccount_type(accounts.getAccount_type());
		accountsDto.setBranch_address(accounts.getBranch_address());
		return accountsDto;
	}
	
	public static Accounts mapToAccounts (AccountsDTO accountsDto, Accounts accounts) {
		accounts.setAccount_type(accountsDto.getAccount_type());
		accounts.setAccountNo(accountsDto.getAccountNo());
		accounts.setBranch_address(accountsDto.getBranch_address());
		return accounts;
	}
	
}
