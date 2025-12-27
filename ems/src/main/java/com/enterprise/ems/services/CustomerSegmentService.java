package com.enterprise.ems.services;
import com.enterprise.ems.entities.CustomerSegmentMapping;
import com.enterprise.ems.repositories.CustomerSegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSegmentService {
   @Autowired
   private CustomerSegmentRepository  customerSegmentRepository;


   public CustomerSegmentMapping addSegment(CustomerSegmentMapping body){
        return  customerSegmentRepository.save(body);
   }


    public CustomerSegmentMapping updateSegment(Long Id, CustomerSegmentMapping body){
        return customerSegmentRepository.findById(Id)
                .map(data->{
                    data.setRemarks(body.getRemarks());
                    data.setBusinessMapping(body.getBusinessMapping());
                    return customerSegmentRepository.save(data);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + Id));

    }


}
