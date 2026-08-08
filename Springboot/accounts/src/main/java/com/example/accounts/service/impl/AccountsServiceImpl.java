package com.example.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.accounts.constants.AccountsConstants;
import com.example.accounts.dto.AccountsDto;
import com.example.accounts.dto.CustomerDto;
import com.example.accounts.entity.Accounts;
import com.example.accounts.entity.Customer;
import com.example.accounts.exception.CustomerAlreadyExistsMobileNumber;
import com.example.accounts.mapper.AccountsMapper;
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
        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyExistsMobileNumber("Customer with mobile number " + customerDto.getMobileNumber() + " already exists.");
        }
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
    @Override
    public CustomerDto fetchCustomer(String mobileNumber) {
        // Logic to fetch account details
        // This could involve retrieving account information from the database and mapping it to a DTO

        Optional<Customer> customerOpt = customerRepository.findByMobileNumber(mobileNumber);
        Customer customer = customerOpt.orElseThrow(() -> new RuntimeException("Customer not found"));
        CustomerDto customerDto = CustomerMapper.toMapCustomerDto(customer);
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId());
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        AccountsDto accountsDto = AccountsMapper.toMapAccountsDto(account);
        customerDto.setAccountsDto(accountsDto);
        return customerDto;
    }
}
