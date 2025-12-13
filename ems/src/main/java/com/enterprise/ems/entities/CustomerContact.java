package com.enterprise.ems.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name ="customer_contact")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerContact {
    /*@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    private String email;

    @Column(nullable = false)
    private String phone;

    private String language;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String pincode;
*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // NAME: required, unique, 2–50 chars
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Name is required")

    @Size(min = 2, max = 50, message = "Name must be between 2–50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name can only contain letters, spaces, apostrophes, and hyphens")
    private String name;


    // EMAIL: optional but must be valid if provided
    @Email(message = "Invalid email address")
    private String email;

    // PHONE: required, digits only, length 10–15
    @Column(nullable = false)
    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone must contain 10–15 digits")
    private String phone;

    // LANGUAGE: optional
    private String language;

    // ADDRESS: required
    @Column(nullable = false)
    @NotBlank(message = "Address is required")
    private String address;

    // PINCODE: required, digits only, length 5–10
    @Column(nullable = false)
    @NotBlank(message = "Pincode is required")

    @Pattern(regexp = "^[0-9]{5,10}$", message = "Pincode must be 5–10 digits")
    private String pincode;

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getLanguage(){return  language;}
    public  void  setLanguage(String language){this.language = language; }

    public  String getAddress(){return  address;}
    public  void  setAddress(String address){this.address = address;}

    public  String getPincode(){return pincode;}
    public  void setPincode(String pincode){this.pincode = pincode;}

}
