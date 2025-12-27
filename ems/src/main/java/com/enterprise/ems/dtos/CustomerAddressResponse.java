package com.enterprise.ems.dtos;

import com.enterprise.ems.entities.Customer;
import jakarta.persistence.*;

public class CustomerAddressResponse {

   // private Long id;
    private String curAddress;
    private String permanentAddress;
    private String businessJson;

    // Optional: include customer info
    private Long customerId;

    public CustomerAddressResponse(
            //Long id,
                                    String curAddress,
                                    String permanentAddress,
                                    String businessJson ) {
       // this.id = id;
        this.curAddress = curAddress;
        this.permanentAddress = permanentAddress;
        this.businessJson = businessJson;

    }
    // Getters and setters
  /*  public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }*/

    public String getCurAddress() { return curAddress; }
    public void setCurAddress(String curAddress) { this.curAddress = curAddress; }

    public String getPermanentAddress() { return permanentAddress; }
    public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }

    public String getBusinessJson() { return businessJson; }
    public void setBusinessJson(String businessJson) { this.businessJson = businessJson; }

   /* public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
*/

   }





