package com.enterprise.ems.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PublicKey;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "current_address")
    private String curAddress;

    @Column(name = "permanent_address")
    private String permanentAddress;

    @Column(name = "business_json", columnDefinition = "TEXT")
    private String businessJson;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    public  String getCurAddress(){  return  curAddress ; }
    public  void setCurAddress(String curAddress){ this.curAddress = curAddress ; }


    public  String getPermanentAddress(){return  permanentAddress ;}
    public void  setPermanentAddress(String permanentAddress){this.permanentAddress = permanentAddress;}


    public  String getBusinessJson(){  return  businessJson ; }
    public  void setBusinessJson(String businessJson){ this.businessJson = businessJson ; }

}
