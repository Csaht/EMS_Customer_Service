package com.enterprise.ems.controllers;

import com.enterprise.ems.dtos.ApiResponse;
import com.enterprise.ems.dtos.CustomerContactResponse;
import com.enterprise.ems.dtos.CustomerDetailResponse;
import com.enterprise.ems.dtos.CustomerResponse;
import com.enterprise.ems.entities.Customer;
import com.enterprise.ems.entities.CustomerDetails;
import com.enterprise.ems.services.CustomerDetailsService;
import com.enterprise.ems.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customerDetail")
public class CustomerDetailsController {
    @Autowired
    private CustomerDetailsService customerDetailsService;

    @PostMapping("/addCustomer")
    public ResponseEntity<ApiResponse<CustomerDetailResponse>> addCustomer(@RequestBody CustomerDetails body) {
      /*  CustomerDetails savedCustomer = customerDetailsService.addCustomerDetails(body);*/
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
}
