package com.enterprise.ems.repositories;

import com.enterprise.ems.entities.Customer;
import com.enterprise.ems.entities.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface  CustomerDetailsRepository  extends JpaRepository<CustomerDetails, UUID>{
}
