package com.enterprise.ems.services;
import org.springframework.data.domain.Page;
import com.enterprise.ems.entities.Customer;
import com.enterprise.ems.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    // Example method
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }



    public Page<Customer> getAllCustomers(String searchTerm, Pageable pageable) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return customerRepository.findAll(pageable);
        } else {
            return customerRepository.searchCustomers(searchTerm, pageable);
        }
    }

    public Optional<Customer> getCustomerById(Integer  id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Integer id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setFirstName(updatedCustomer.getFirstName());
                    existingCustomer.setLastName(updatedCustomer.getLastName());
                    existingCustomer.setEmail(updatedCustomer.getEmail());
                    existingCustomer.setPhone(updatedCustomer.getPhone());
                    existingCustomer.setAddress(updatedCustomer.getAddress());
                    return customerRepository.save(existingCustomer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    public void deleteCustomer(Integer  id) {
        customerRepository.deleteById(id);
    }
}
