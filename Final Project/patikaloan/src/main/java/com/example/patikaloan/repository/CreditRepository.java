package com.example.patikaloan.repository;

import com.example.patikaloan.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit,Integer> {

    @Query(value = "select * from credit where customer_id = :tcId ",nativeQuery = true)
    List<Credit> findAllByTcId(Long tcId);
}
