package com.example.accounts.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.accounts.constants.AccountsConstants;
import com.example.accounts.dto.CustomerDto;
import com.example.accounts.entity.Accounts;
import com.example.accounts.entity.Customer;
import com.example.accounts.mapper.CustomerMapper;
import com.example.accounts.repository.AccountsRepository;
import com.example.accounts.repository.CustomerRepository;
import com.example.accounts.service.IAccountsService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {
    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toMapCustomer(customerDto);
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        Accounts newAccount = createNewAccount(savedCustomer);
        accountsRepository.save(newAccount);
    }

    private Accounts createNewAccount(Customer customer) {
        // Logic to create a new account for the customer
        // This could involve setting default values, generating an account number, etc.
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        newAccount.setAccountNumber(99999999999L);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS); 
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");

        return newAccount;
    }

}
