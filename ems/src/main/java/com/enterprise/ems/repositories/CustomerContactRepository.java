package com.enterprise.ems.repositories;

import com.enterprise.ems.entities.Customer;
import com.enterprise.ems.entities.CustomerContact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {

    // Custom search query across multiple fields
    @Query("SELECT c FROM CustomerContact c WHERE " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.pincode) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.phone) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(c.address) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR  " +
            "LOWER(c.language) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<CustomerContact> searchContact(@Param("searchTerm") String searchTerm, Pageable pageable);

}
