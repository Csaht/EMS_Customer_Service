package com.enterprise.ems.dtos;

public class CustomerContactFilter {

    private String name;
    private String email;
    private String phone;
    private String language;
    private String pincode;

    // Add getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }
}
