package com.enterprise.ems.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
