package com.example.patikaloan.dto;

import lombok.Data;
@Data
public class CustomerDto {

    private Long tcId;
    private String name;
    private String surname;
    private Integer salary;
    private String phoneNumber;
    private Integer creditNote;
}
