package com.example.demo.deductible;


import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "deductible")
public class Deductible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "insurance_id")
    private Integer insuranceId;

    @Column(name = "category")
    private String category;

    @Column(name = "is_standard")
    private boolean isStandard;

    @Column(name = "individual")
    private Double individual;

    @Column(name = "family")
    private Double family;


    public Deductible() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Deductible(int id, Integer insuranceId, String category, boolean isStandard, Double individual, Double family) {
        this.id = id;
        this.insuranceId = insuranceId;
        this.category = category;
        this.isStandard = isStandard;
        this.individual = individual;
        this.family = family;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isStandard() {
        return isStandard;
    }

    public void setStandard(boolean standard) {
        isStandard = standard;
    }

    public Double getIndividual() {
        return individual;
    }

    public void setIndividual(Double individual) {
        this.individual = individual;
    }

    public Double getFamily() {
        return family;
    }

    public void setFamily(Double family) {
        this.family = family;
    }
}
