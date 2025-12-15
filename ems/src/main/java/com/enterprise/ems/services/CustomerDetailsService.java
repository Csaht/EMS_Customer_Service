package com.enterprise.ems.services;

import com.enterprise.ems.entities.Customer;
import com.enterprise.ems.entities.CustomerDetails;
import com.enterprise.ems.repositories.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService {
    @Autowired

    private CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetails addCustomerDetails(CustomerDetails body) {
        return customerDetailsRepository.save(body);
    }
}