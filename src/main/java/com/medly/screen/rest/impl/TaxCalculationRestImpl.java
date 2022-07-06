package com.medly.screen.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.medly.screen.rest.ITaxCalculationRest;
import com.medly.screen.service.ITaxCalculationService;
import com.medly.screen.wrapper.TaxCalculationWrapper;

@Primary
@RestController
public class TaxCalculationRestImpl implements ITaxCalculationRest{
	
	@Autowired
	ITaxCalculationService TCS;

	@Override
	public ResponseEntity<List<TaxCalculationWrapper>> taxCalculation(int year, int age, float salary, float investment) {
		return TCS.taxCalculation(year,age,salary,investment);
	}

	
	
}
