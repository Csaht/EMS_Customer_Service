package com.enterprise.ems.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name = "customer_details")
public class CustomerDetails {

    // PRIMARY KEY (AUTO-GENERATED UUID)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cust_id", nullable = false, updatable = false)
    private UUID custId;


    // NAME: required, unique, 2–50 chars
    @Column(unique = false, nullable = false)
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2–50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name can only contain letters, spaces, apostrophes, and hyphens")
    private  String name;

    @Column(unique = false, nullable = false)
    @NotNull(message = "DOB is required")
    private LocalDate dob;

    @Column(unique = false, nullable = false)
    @NotBlank(message = "Gender is required")
    private  String gender;

    private  String countryCode;

    @Column(unique = false, nullable = false)
    @NotBlank(message = "Contact is required")
    private  String contact;

    // EMAIL: optional but must be valid if provided
    @Email(message = "Invalid email address")
    private  String email;

    private  String custType;


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
    public  void setCustType(String custType){this.custType = custType;}



}
