package com.enterprise.ems.services;

import com.enterprise.ems.entities.CustomerAddress;
import com.enterprise.ems.entities.CustomerContact;
import com.enterprise.ems.entities.CustomerDetails;
import com.enterprise.ems.repositories.CustomerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressService {
    @Autowired
    private CustomerAddressRepository customerAddressRepository;


    public CustomerAddress addCustomerAddress(CustomerAddress body){
        return  customerAddressRepository.save(body);
    }

  /*  ************


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
    **************
*/
   public  CustomerAddress updateAddress(Long id , CustomerAddress body){
       return customerAddressRepository.findById(id)
               .map(data ->{
                   data.setCurAddress(body.getCurAddress());
                   data.setPermanentAddress(body.getPermanentAddress());
                   data.setBusinessJson(body.getBusinessJson());
                   return  customerAddressRepository.save(data);
               })
               .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));


   }

}
