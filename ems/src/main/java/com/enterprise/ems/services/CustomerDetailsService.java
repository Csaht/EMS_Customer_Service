package com.enterprise.ems.services;

import com.enterprise.ems.entities.Customer;
import com.enterprise.ems.entities.CustomerContact;
import com.enterprise.ems.entities.CustomerDetails;
import com.enterprise.ems.repositories.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerDetailsService {
    @Autowired

    private CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetails addCustomerDetails(CustomerDetails body) {
        return customerDetailsRepository.save(body);
    }


    public CustomerDetails updateCustomerContact(UUID id, CustomerDetails body) {
        return customerDetailsRepository.findById(id)
                .map(existingCustomerContact -> {
                    existingCustomerContact.setName(body.getName());
                    existingCustomerContact.setDob(body.getDob());
                    existingCustomerContact.setGender(body.getGender());
                    existingCustomerContact.setCountryCode(body.getCountryCode());
                    existingCustomerContact.setContact(body.getContact());
                    existingCustomerContact.setEmail(body.getEmail());
                    existingCustomerContact.setCustType(body.getCustType());
                   return customerDetailsRepository.save(existingCustomerContact);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }
}