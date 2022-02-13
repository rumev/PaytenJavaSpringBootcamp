package com.example.patikaloan;

import com.example.patikaloan.dto.CustomerDto;
import com.example.patikaloan.model.Customer;
import com.example.patikaloan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerControllerTest extends PatikaloanApplicationTests  {

    @Autowired
    CustomerRepository customerRepository;

    void should_create_customer(){
        //given
        Customer customer = new Customer(123456L,"Ali","Veli",4950,"5325323232",1000);

        //when
        ResponseEntity<Customer> response =testRestTemplate.postForEntity("/customer",customer,Customer.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTcId()).isNotNull();

        //validate customer
        Optional<Customer> found =customerRepository.findById(response.getBody().getTcId());
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Ali");
        assertThat(found.get().getSalary()).isEqualTo(4950);


    }
}
