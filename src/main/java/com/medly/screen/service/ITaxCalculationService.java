package com.medly.screen.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.medly.screen.wrapper.TaxCalculationWrapper;

public interface ITaxCalculationService {

	ResponseEntity<List<TaxCalculationWrapper>> taxCalculation(int year, int age, float salary, float investment);

}
