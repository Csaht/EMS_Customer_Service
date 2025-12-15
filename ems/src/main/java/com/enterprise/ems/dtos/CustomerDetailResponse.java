package com.enterprise.ems.dtos;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CustomerDetailResponse {
    private String name;
    private LocalDate dob;
    private String gender;
    private String countryCode;
    private String contact;
    private String email;
    private String custType;




    public CustomerDetailResponse(
            String name,
            LocalDate dob,
            String gender,
            String countryCode,
            String contact,
            String email,
            String custType


    ) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.countryCode = countryCode;
        this.contact = contact;
        this.email = email;
        this.custType = custType;
    }



    public String getName(){ return name;}
    public  void setName(String name){this.name =name;}


    public LocalDate getDob(){ return dob;}
    public  void setDob(LocalDate dob){this.dob = dob;}

    public String getGender(){ return gender;}
    public  void setGender(String gender){this.gender = gender;}

    public String getCountryCode(){ return countryCode;}
    public  void setCountryCode(String countryCode){this.countryCode = countryCode;}

    public String getContact(){ return contact;}
    public  void setContact(String contact){this.contact = contact;}

    public String getEmail(){ return email;}
    public  void setEmail(String email){this.email = email;}

    public String getCustType(){ return custType;}
    public  void setCustType(String custType){this.custType = custType ;}

}
