package com.example.patikaloan.dto;

import com.example.patikaloan.enums.CreditStatus;
import lombok.Data;

@Data
public class CreditDto {

    private Integer creditId;
    private Integer amount;
    private CreditStatus status;
    private Long tcId;

}
