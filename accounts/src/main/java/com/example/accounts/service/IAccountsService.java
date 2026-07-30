package com.example.accounts.service;

import com.example.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     * This method is used to create an account for a customer.
     * @param customerDto The customer details for which the account needs to be created.
     */
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchCustomer(String mobileNumber);
}
