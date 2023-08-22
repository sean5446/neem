package com.example.demo.deductible;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeductibleRepository extends JpaRepository<Deductible, Integer> {

    // APP -> REST CONTROLLER -> SERVICE LAYER -> REPOSITORY LAYER -> DB

    public List<Deductible> findByInsuranceId(int id);

}
