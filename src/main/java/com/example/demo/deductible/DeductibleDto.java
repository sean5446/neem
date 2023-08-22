package com.example.demo.deductible;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class DeductibleDto {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    private Integer insuranceId;

    private String category;

    private boolean isStandard;

    private Double individual;

    private Double family;

    public static DeductibleDto fromDeductible(Deductible deductible) {
        DeductibleDto deductibleDto = new DeductibleDto();
        BeanUtils.copyProperties(deductible, deductibleDto);
        return deductibleDto;
    }

    public static Deductible toDeductible(DeductibleDto deductibleDto) {
        Deductible deductible = new Deductible();
        BeanUtils.copyProperties(deductibleDto, deductible);
        return deductible;
    }

}
