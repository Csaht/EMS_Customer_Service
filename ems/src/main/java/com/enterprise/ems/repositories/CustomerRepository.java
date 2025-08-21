package com.enterprise.ems.repositories;

import com.enterprise.ems.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository

public interface CustomerRepository extends JpaRepository<Customer,Integer> {



        // Custom search query across multiple fields
        @Query("SELECT c FROM Customer c WHERE " +
                "LOWER(c.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(c.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(c.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(c.phone) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(c.address) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
        Page<Customer> searchCustomers(@Param("searchTerm") String searchTerm, Pageable pageable);


}
