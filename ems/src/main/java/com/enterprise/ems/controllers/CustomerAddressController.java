package com.enterprise.ems.controllers;
import com.enterprise.ems.dtos.ApiResponse;
import com.enterprise.ems.dtos.CustomerAddressResponse;
import com.enterprise.ems.entities.CustomerAddress;
import com.enterprise.ems.services.CustomerAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")
public class CustomerAddressController {
    @Autowired
    private CustomerAddressService customerAddressService;

    @PostMapping("/addAddress")
    public ResponseEntity<ApiResponse<CustomerAddressResponse>> addAddress(@Valid @RequestBody CustomerAddress body){
        CustomerAddress updated = customerAddressService.addCustomerAddress(body);
        CustomerAddressResponse customerAddressResponse = new  CustomerAddressResponse(
                updated.getCurAddress(),
                updated.getPermanentAddress(),
                updated.getBusinessJson()
        );

        ApiResponse<CustomerAddressResponse> response = new ApiResponse<>(
                true,
                200,
                "Created successfully",
                customerAddressResponse,
                null

        );
        return ResponseEntity.status(201).body(response);
    }
   /* *******************

    @GetMapping("/getContact/{id}")
    public ResponseEntity<ApiResponse<CustomerContactResponse>> getContactById(@PathVariable Long id) {

        CustomerContact contact = customerContactService.getContactById(id)
                .orElseThrow(() -> new RuntimeException("Customer contact not found with id: " + id));

        CustomerContactResponse responseData = new CustomerContactResponse(
                contact.getName(),
                contact.getPincode(),
                contact.getEmail(),
                contact.getPhone(),
                contact.getAddress(),
                contact.getLanguage()
        );

        ApiResponse<CustomerContactResponse> response = new ApiResponse<>(
                true,
                200,
                "Customer contact fetched successfully",
                responseData,
                null
        );

        return ResponseEntity.ok(response);
    }


    // UPDATE CUSTOMER CONTACT
    @PutMapping("/updateContact/{id}")
    public ResponseEntity<ApiResponse<CustomerContactResponse>> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerContact updatedCustomer) {

        CustomerContact updated = customerContactService.updateCustomerContact(id, updatedCustomer);

        CustomerContactResponse customerResponse = new CustomerContactResponse(
                updated.getName(),
                updated.getPincode(),
                updated.getEmail(),
                updated.getPhone(),
                updated.getAddress(),
                updated.getLanguage()
        );

        ApiResponse<CustomerContactResponse> response = new ApiResponse<>(
                true,
                200,
                "Customer updated successfully",
                customerResponse,
                null
        );

        return ResponseEntity.ok(response);
    }

    *********************/
    @PutMapping()
    public  ResponseEntity<ApiResponse<CustomerAddressResponse>> updateCustomerAddress(@PathVariable Long id, @Valid @RequestBody CustomerAddress body){
      //  CustomerContact updated = customerContactService.updateCustomerContact(id, updatedCustomer);
     CustomerAddress update = customerAddressService.updateAddress(id,body);

     CustomerAddressResponse responseData = new CustomerAddressResponse(
             update.getCurAddress(),
             update.getPermanentAddress(),
             update.getBusinessJson()
     );

     ApiResponse<CustomerAddressResponse> apiResponse = new ApiResponse<>(
                true,
                200,
                "Created successfully",
                responseData,
                null

        );
        return ResponseEntity.status(201).body(apiResponse);
    }
}
