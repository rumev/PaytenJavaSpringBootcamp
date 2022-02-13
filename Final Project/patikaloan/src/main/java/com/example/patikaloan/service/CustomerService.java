package com.example.patikaloan.service;

import com.example.patikaloan.dto.CustomerDto;
import com.example.patikaloan.enums.CreditStatus;
import com.example.patikaloan.model.Credit;
import com.example.patikaloan.model.Customer;
import com.example.patikaloan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CreditService creditService;

    //Service method for add a new customer
    public CustomerDto addCustomer(Customer customer){
        Optional<Customer> exists =customerRepository.findById(customer.getTcId());
        if(exists.isEmpty()){
            return customerToCustomerDto(customerRepository.save(customer));
        }
        else{
            throw new EntityExistsException("Customer already exist");
        }
    }

    //Service method for update a customer
    @Transactional
    public CustomerDto updateCustomer(Long tcId,Customer customerUpdate){
        Customer existsCustomer =customerRepository.getById(customerUpdate.getTcId());
        if (Objects.nonNull(existsCustomer)){
            existsCustomer.setName(customerUpdate.getName());
            existsCustomer.setSurname(customerUpdate.getSurname());
            existsCustomer.setSalary(customerUpdate.getSalary());
            existsCustomer.setPhoneNumber(customerUpdate.getPhoneNumber());
            existsCustomer.setCreditNote(customerUpdate.getCreditNote());
        }
        else{
            throw new EntityNotFoundException("Customer Not Found");
        }
        customerRepository.saveAndFlush(existsCustomer);
        return customerToCustomerDto(existsCustomer);
    }

    //Service method for delete a customer
    public String deleteCustomer(Long tcId) {
        Customer existsCustomer = customerRepository.getById(tcId);
        if (Objects.nonNull(existsCustomer)) {
            customerRepository.deleteById(tcId);
        } else {
            throw new EntityNotFoundException("Customer not found");
        }
        return "Customer Deleted.";
    }

    public String creditCheck(Long tcId){
        Customer existCustomer =customerRepository.getById(tcId);
        Credit credit =new Credit();
        if(Objects.nonNull(existCustomer)){
            if(existCustomer.getCreditNote()>999){
                int loan =existCustomer.getSalary()*4;
                credit.setCustomer(existCustomer);
                credit.setAmount(loan);
                credit.setStatus(CreditStatus.APPROVAL);
                creditService.addCredit(credit);
                return CreditStatus.APPROVAL+" "+loan;
            }
            else if(existCustomer.getCreditNote()>499&&existCustomer.getCreditNote()<1000&&existCustomer.getSalary()>4999){
                credit.setCustomer(existCustomer);
                credit.setAmount(20000);
                credit.setStatus(CreditStatus.APPROVAL);
                creditService.addCredit(credit);
                return CreditStatus.APPROVAL +" 20.000";
            }
            else if(existCustomer.getCreditNote()>499&&existCustomer.getCreditNote()<1000&&existCustomer.getSalary()<5000){
                credit.setCustomer(existCustomer);
                credit.setAmount(10000);
                credit.setStatus(CreditStatus.APPROVAL);
                creditService.addCredit(credit);
                return CreditStatus.APPROVAL+" 10.000";
            }
            else{
                credit.setCustomer(existCustomer);
                credit.setAmount(0);
                credit.setStatus(CreditStatus.DENIED);
                creditService.addCredit(credit);
                return String.valueOf(CreditStatus.DENIED);
            }
        }
        else{
            throw new EntityNotFoundException("Customer Not Found");
        }
    }


    public CustomerDto customerToCustomerDto(Customer customer){
        CustomerDto customerDto =new CustomerDto();
        customerDto.setTcId(customer.getTcId());
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setSalary(customer.getSalary());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setCreditNote(customer.getCreditNote());
        return customerDto;
    }
}
