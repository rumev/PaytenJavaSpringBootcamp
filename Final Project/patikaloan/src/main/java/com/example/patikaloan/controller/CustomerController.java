package com.example.patikaloan.controller;

import com.example.patikaloan.dto.CustomerDto;
import com.example.patikaloan.model.Customer;
import com.example.patikaloan.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
@Api(value = "Customer Api Documentation")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "Method to add a new customer")
    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @ApiOperation(value = "Method to update an exist customer")
    @PatchMapping("/{tcId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long tcId,@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(tcId,customer));
    }

    @ApiOperation(value = "Method to delete an exist customer")
    @DeleteMapping("/{tcId}")
    public ResponseEntity deleteCustomer(@PathVariable Long tcId){
        customerService.deleteCustomer(tcId);
        return ResponseEntity.ok(tcId +" Deleted");
    }

    @ApiOperation(value="Method to check credit result for a customer with tc id")
    @GetMapping("/credit/{tcId}")
    public String creditCheck(@PathVariable Long tcId){
        return customerService.creditCheck(tcId);
    }
}
