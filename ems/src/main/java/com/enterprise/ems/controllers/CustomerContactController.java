package com.enterprise.ems.controllers;
import com.enterprise.ems.dtos.ApiResponse;
import com.enterprise.ems.dtos.CustomerContactResponse;
import com.enterprise.ems.dtos.PaginationResponse;
import com.enterprise.ems.entities.CustomerContact;
import com.enterprise.ems.services.CustomerContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customersContact")

public class CustomerContactController {


    @Autowired
    private CustomerContactService customerContactService;


    @PostMapping("/addContact")
    public ResponseEntity<ApiResponse<CustomerContactResponse>> addCustomer(@Valid  @RequestBody CustomerContact body) {
      /*  return customerContactService.addContact(body);*/
        CustomerContact savedCustomer = customerContactService.addContact(body);
        CustomerContactResponse customerResponse = new CustomerContactResponse(

                savedCustomer.getName(),
                savedCustomer.getPincode(),
                savedCustomer.getEmail(),
                savedCustomer.getPhone(),
                savedCustomer.getAddress(),
                savedCustomer.getLanguage()
        );

        ApiResponse<CustomerContactResponse> response = new ApiResponse<>(
                true,
                200,
                " Created successfully",
                customerResponse,
                null

        );
        return ResponseEntity.status(201).body(response);

    }

    @GetMapping("/getContactList")
    public ResponseEntity<ApiResponse<?>> getAllCustomers(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<CustomerContact> customerPage = customerContactService.getAllContact(searchTerm, pageable);

        // Build pagination object
        PaginationResponse pagination = new PaginationResponse(
                customerPage.getNumber(),          // current page
                customerPage.getSize(),            // page size
                customerPage.getTotalElements(),   // total records
                customerPage.getTotalPages()       // total pages
        );

        // Build response wrapper
        ApiResponse<List<CustomerContact>> response = new ApiResponse<>(
                true,
                HttpStatus.OK.value(),
                customerPage.isEmpty() ? "No customers found" : "Customers fetched successfully",
                customerPage.getContent(),
                pagination
        );

        return ResponseEntity.ok(response);
    }

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


    @DeleteMapping("/deleteContact/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteContact(@PathVariable Long id) {
        customerContactService.deleteContact(id);

        ApiResponse<Void> response = new ApiResponse<>(
                true,
                200,
                "Contact deleted successfully with id: " + id,
                null,
                null
        );

        return ResponseEntity.ok(response);
    }

}
