package com.cryptoexchange.customer.controller;

import com.cryptoexchange.customer.model.Customer;
import com.cryptoexchange.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    @PostMapping()
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.createCustomer(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findCustomerById(id));
    }

    @GetMapping()
    public ResponseEntity<?> findAllCustomers() {
        return ResponseEntity.ok(service.findAllCustomers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomerById(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(service.updateCustomerById(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        service.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }
}
