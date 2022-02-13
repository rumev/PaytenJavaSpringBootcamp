package com.example.patikaloan.service;

import com.example.patikaloan.dto.CreditDto;
import com.example.patikaloan.model.Credit;
import com.example.patikaloan.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditService {

    @Autowired
    CreditRepository creditRepository;

    public CreditDto addCredit(Credit credit){
        creditRepository.save(credit);
        return creditToCreditDto(credit);

    }

    public List<CreditDto> getCreditsByTcId(Long tcId){
        return creditRepository.findAllByTcId(tcId).stream().map(credit -> creditToCreditDto(credit)).collect(Collectors.toList());
    }

    public CreditDto creditToCreditDto(Credit credit){
        CreditDto dto =new CreditDto();
        dto.setCreditId(credit.getCreditId());
        dto.setAmount(credit.getAmount());
        dto.setStatus(credit.getStatus());
        dto.setTcId(credit.getCustomer().getTcId());
        return dto;
    }
}
