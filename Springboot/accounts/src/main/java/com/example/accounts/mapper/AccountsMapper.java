package com.example.accounts.mapper;
import com.example.accounts.entity.Accounts;
import com.example.accounts.dto.AccountsDto;
public class AccountsMapper {
    public static AccountsDto toMapAccountsDto(Accounts accounts){
        AccountsDto accountsDto = new AccountsDto();
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }
    public static Accounts toMapAccounts(AccountsDto accountsDto){
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
