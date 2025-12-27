package com.enterprise.ems.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer_segment")
public class CustomerSegmentMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String remarks;

    @Column(name = "business_mapping", columnDefinition = "TEXT")
    private String businessMapping;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public String getRemarks(){return  remarks;}
    public void  setRemarks(String remarks){this.remarks = remarks;}


    public  String getBusinessMapping(){  return  businessMapping ; }
    public  void setBusinessMapping(String businessMapping){ this.businessMapping = businessMapping;}







}
