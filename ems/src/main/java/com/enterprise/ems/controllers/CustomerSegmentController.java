package com.enterprise.ems.controllers;

import com.enterprise.ems.dtos.ApiResponse;
import com.enterprise.ems.dtos.CustomerSegmentResponse;
import com.enterprise.ems.entities.CustomerSegmentMapping;
import com.enterprise.ems.services.CustomerSegmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/customer-segments")
public class CustomerSegmentController {
    @Autowired
    private CustomerSegmentService customerSegmentService;


    @PostMapping("/create-customer-segment")
    public ResponseEntity<ApiResponse<CustomerSegmentResponse>> addSegment(@Valid @RequestBody CustomerSegmentMapping body){
        CustomerSegmentMapping savedSegment = customerSegmentService.addSegment(body);

       CustomerSegmentResponse responseData = new CustomerSegmentResponse(
               savedSegment.getRemarks(),
               savedSegment.getBusinessMapping()
       );

        ApiResponse<CustomerSegmentResponse> apiResponse = new ApiResponse<>(

                true,
                200,
                "Added successfully",
                responseData,
                null

        );
        return ResponseEntity.status(201).body(apiResponse);

    }


    // UPDATE CUSTOMER
    @PutMapping("/update-customer-segment/{id}")
    public ResponseEntity<ApiResponse<CustomerSegmentResponse>> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerSegmentMapping body) {

        CustomerSegmentMapping updateSegment = customerSegmentService.updateSegment(id,body);

        CustomerSegmentResponse responseData  = new CustomerSegmentResponse(
                updateSegment.getRemarks(),
                updateSegment.getBusinessMapping()

        );

        ApiResponse<CustomerSegmentResponse> apiResponse = new ApiResponse<>(
                true,
                200,
                "Customer updated successfully",
                responseData ,
                null
        );

        return ResponseEntity.ok(apiResponse);
}}
