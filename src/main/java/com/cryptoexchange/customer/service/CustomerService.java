package com.cryptoexchange.customer.service;

import com.cryptoexchange.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer findCustomerById(Long id);

    List<Customer> findAllCustomers();

    Customer updateCustomerById(Long id, Customer customer);

    void deleteCustomerById(Long id);
}
