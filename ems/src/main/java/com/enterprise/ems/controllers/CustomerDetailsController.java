package com.enterprise.ems.controllers;

import com.enterprise.ems.dtos.ApiResponse;
import com.enterprise.ems.dtos.CustomerDetailResponse;

import com.enterprise.ems.entities.CustomerDetails;
import com.enterprise.ems.services.CustomerDetailsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customerDetail")
public class CustomerDetailsController {
    @Autowired
    private CustomerDetailsService customerDetailsService;

    @PostMapping("/addCustomer")
    public ResponseEntity<ApiResponse<CustomerDetailResponse>> addCustomer(@RequestBody CustomerDetails body) {

        CustomerDetails customer = customerDetailsService.addCustomerDetails(body);

        CustomerDetailResponse  customerResponse = new CustomerDetailResponse(
                customer.getName(),
                customer.getDob(),
                customer.getGender(),
                customer.getCountryCode(),
                customer.getContact(),
                customer.getEmail(),
                customer.getCustType()
        );

        ApiResponse<CustomerDetailResponse> response = new ApiResponse<>(

                true,
                200,
                "Customer added successfully",
                customerResponse,
                null

        );
        return ResponseEntity.status(201).body(response);
    }




    // UPDATE CUSTOMER
    @PutMapping("/updateCustomerDetails/{id}")
    public ResponseEntity<ApiResponse<CustomerDetailResponse>> updateCustomer(
            @PathVariable UUID id,
            @Valid @RequestBody CustomerDetails body) {

        CustomerDetails customer = customerDetailsService.updateCustomerContact(id,body);

        CustomerDetailResponse customerResponse = new CustomerDetailResponse(
                customer.getName(),
                customer.getDob(),
                customer.getGender(),
                customer.getCountryCode(),
                customer.getContact(),
                customer.getEmail(),
                customer.getCustType()
        );

        ApiResponse<CustomerDetailResponse> response = new ApiResponse<>(
                true,
                200,
                "Customer updated successfully",
                customerResponse,
                null
        );

        return ResponseEntity.ok(response);
    }
}
