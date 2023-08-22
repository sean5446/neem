package com.example.demo.deductible;

import java.util.List;

public interface DeductibleService {
    List<Deductible> findAll();

    Deductible findById(int id);

    void save(Deductible deductible);

    void deleteById(int id);

    List<Deductible> findByInsuranceId(int id);
}
