package com.enterprise.ems.dtos;


public class CustomerContactResponse {
    //  private Long id;
    private String name;
    private String email;
    private String phone;
    private String language;
    private String address;
    private String pincode;

    // ✅ No-args constructor (needed for Jackson / frameworks)
    public CustomerContactResponse() {}

    // ✅ All-args constructor
   /* Long id,*/
    public CustomerContactResponse( String name, String email,
                            String phone,String language, String address, String pincode ) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.language = language;
        this.pincode = pincode;
        this.address = address;
    }

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
