package com.example.patikaloan.controller;

import com.example.patikaloan.dto.CreditDto;
import com.example.patikaloan.model.Credit;
import com.example.patikaloan.service.CreditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit")
@Api(value = "Credit Api Documentation")
@CrossOrigin(origins = "*")
public class CreditController {

    @Autowired
    CreditService creditService;

    @ApiOperation(value = "Method to retrieve all credits for a customer")
    @GetMapping("/{tcId}")
    public List<CreditDto> getCreditsByTcId(@PathVariable Long tcId){
        return creditService.getCreditsByTcId(tcId);
    }

    @ApiOperation(value = "Method to add a credit")
    @PostMapping
    public ResponseEntity<CreditDto> addCredit(@RequestBody Credit credit){
        return ResponseEntity.ok(creditService.addCredit(credit));
    }
}
