package com.cryptoexchange.customer.controller;

import com.cryptoexchange.customer.dto.CustomerDTO;
import com.cryptoexchange.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
@SecurityRequirement(name = "Bearer Authentication")
public class CustomerController {

    private final CustomerService service;

    @PostMapping()
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(service.createCustomer(customerDTO));
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
    public ResponseEntity<?> updateCustomerById(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(service.updateCustomerById(id, customerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        service.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }
}
