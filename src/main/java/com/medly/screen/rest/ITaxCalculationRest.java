package com.medly.screen.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medly.screen.wrapper.TaxCalculationWrapper;

public interface ITaxCalculationRest {

	@GetMapping(path = "calculation")
	@ResponseBody
	public ResponseEntity<List<TaxCalculationWrapper>> taxCalculation(@RequestParam(required = false, name = "year") int year,
			@RequestParam(required = false, name = "age") int age,
			@RequestParam(required = false, name = "salary") float salary,
			@RequestParam(required = false, name = "investment") float investment);

}
