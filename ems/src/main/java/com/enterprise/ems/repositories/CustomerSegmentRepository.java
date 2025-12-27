package com.enterprise.ems.repositories;
import com.enterprise.ems.entities.CustomerSegmentMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSegmentRepository extends JpaRepository<CustomerSegmentMapping, Long> {

}
