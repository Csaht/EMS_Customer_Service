package com.enterprise.ems.services;
import com.enterprise.ems.entities.CustomerContact;
import com.enterprise.ems.repositories.CustomerContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerContactService {
    @Autowired
    private CustomerContactRepository customerContactRepository;

     public  CustomerContact addContact(CustomerContact body){
        return  customerContactRepository.save(body);
    }

    public Page<CustomerContact> getAllContact(String searchTerm, Pageable pageable) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return customerContactRepository.findAll(pageable);
        } else {
            return customerContactRepository.searchContact(searchTerm, pageable);
        }
    }


    public CustomerContact updateCustomerContact(Long id, CustomerContact updatedCustomerContact) {
        return customerContactRepository.findById(id)
                .map(existingCustomerContact -> {
                    existingCustomerContact.setName(updatedCustomerContact.getName());
                    existingCustomerContact.setPincode(updatedCustomerContact.getPincode());
                    existingCustomerContact.setEmail(updatedCustomerContact.getEmail());
                    existingCustomerContact.setPhone(updatedCustomerContact.getPhone());
                    existingCustomerContact.setAddress(updatedCustomerContact.getAddress());
                    existingCustomerContact.setLanguage(updatedCustomerContact.getLanguage());
                    return customerContactRepository.save(existingCustomerContact);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    public Optional<CustomerContact> getContactById(Long id) {
        return customerContactRepository.findById(id);
    }


    public void deleteContact(Long  id) {
        customerContactRepository.deleteById(id);
    }
}
