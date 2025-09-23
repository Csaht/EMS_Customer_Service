package com.enterprise.ems.controllers;

import com.enterprise.ems.dtos.ApiResponse;
import com.enterprise.ems.dtos.CustomerResponse;
import com.enterprise.ems.dtos.PaginationResponse;
import com.enterprise.ems.entities.Customer;
import com.enterprise.ems.services.CustomerService;

import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // ✅ POST Mapping
   /* @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
*/
    @PostMapping("/addCustomer")
    public ResponseEntity<ApiResponse<CustomerResponse>> addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.addCustomer(customer);

        CustomerResponse customerResponse = new CustomerResponse(
                savedCustomer.getCustomerId(),
                savedCustomer.getFirstName(),
                savedCustomer.getLastName(),
                savedCustomer.getEmail(),
                savedCustomer.getPhone(),
                savedCustomer.getAddress()
        );

        ApiResponse<CustomerResponse> response = new ApiResponse<>(
                true,
                200,
                "Customer added successfully",
                customerResponse,
                null

        );
        return ResponseEntity.status(201).body(response);
    }

    // ✅ GET Mapping - Get Customer by ID
    @GetMapping("/getCustomerById/{id}")
    public  Optional<Customer>  getCustomer(@PathVariable Integer  id) {
        return customerService.getCustomerById(id);
    }

    // ✅ GET Mapping - Get All Customers
    /*@GetMapping("/getCustomerList")
    public List<Customer> getCustomerList() {   // 🔹 return type Customer nhi, List<Customer> hoga
        return customerService.getAllCustomers();
    }
*/

    // ✅ GET Mapping - Get All Customers with search + pagination
   /* @GetMapping("/getCustomerList")
    public Page<Customer> getAllCustomers(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        if (searchTerm == null || searchTerm.isEmpty()) {
            // ✅ Agar search term empty h to sab customer fetch karo
            return customerRepository.findAll(pageable);
        } else {
            // ✅ Agar search term h to searchCustomers call karo
            return customerRepository.searchCustomers(searchTerm, pageable);
        }
    }*/


    // ✅ GET Mapping - Get All Customers with search + pagination
  /*  @GetMapping("/getCustomerList")
    public Page<Customer> getAllCustomers(
            //@RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) String searchTerm, // Search term for customer name, email, etc.
            @RequestParam(required = false) String status,    // Filter by status (Active/Inactive)
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return customerService.getAllCustomers(searchTerm, pageable); // ✅ Service ko call karna h
    }*/

    @GetMapping("/getCustomerList")
    public ResponseEntity<ApiResponse<?>> getAllCustomers(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customerPage = customerService.getAllCustomers(searchTerm, pageable);

        // Build pagination object
        PaginationResponse pagination = new PaginationResponse(
                customerPage.getNumber(),          // current page
                customerPage.getSize(),            // page size
                customerPage.getTotalElements(),   // total records
                customerPage.getTotalPages()       // total pages
        );

        // Build response wrapper
        ApiResponse<List<Customer>> response = new ApiResponse<>(
                true,
                HttpStatus.OK.value(),
                customerPage.isEmpty() ? "No customers found" : "Customers fetched successfully",
                customerPage.getContent(),
                pagination
        );

        return ResponseEntity.ok(response);
    }

    // ✅ PUT Mapping (update)
    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    // ✅ DELETE Mapping
   /* @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Integer  id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully with id: " + id;
    }*/

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);

        ApiResponse<Void> response = new ApiResponse<>(
                true,
                200,
                "Customer deleted successfully with id: " + id,
                null,
                null
        );

        return ResponseEntity.ok(response);
    }

}
