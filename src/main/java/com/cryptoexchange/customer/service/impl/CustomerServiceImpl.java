package com.cryptoexchange.customer.service.impl;

import com.cryptoexchange.customer.model.Customer;
import com.cryptoexchange.customer.repository.CustomerRepository;
import com.cryptoexchange.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь не найден!"));
    }

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer updateCustomerById(Long id, Customer customer) {
        Customer tmp = repository.findById(id).orElseThrow();
        tmp.setVerified(customer.isVerified());
        tmp.setEmail(customer.getEmail());
        tmp.setRolesList(customer.getRolesList());
        tmp.setAvatar(customer.getAvatar());
        tmp.setPhoneNumber(customer.getPhoneNumber());
        return repository.save(tmp);
    }

    @Override
    public void deleteCustomerById(Long id) {
        Customer customer = findCustomerById(id);
        repository.delete(customer);
    }
}
