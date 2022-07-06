package com.medly.screen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medly.screen.constant.TaxCalculationConstants;
import com.medly.screen.dao.ITaxCalculationDao;
import com.medly.screen.exception.UserDefinedException;
import com.medly.screen.service.ITaxCalculationService;
import com.medly.screen.wrapper.TaxCalculationWrapper;

@Service
public class TaxCalculationServiceImpl implements ITaxCalculationService {

	@Autowired
	ITaxCalculationDao TCD;

	@Override
	public ResponseEntity<List<TaxCalculationWrapper>> taxCalculation(int year, int age, float salary, float investment) {

		float netTaxableIncome = 0;
		float tax = 0;
		float cess = 0;
		float totalTax = 0;

		try {
			validation(year, age, salary);

			netTaxableIncome = investmentDeduction(salary, investment, netTaxableIncome);

			netTaxableIncome = ageBenifites(age, year, netTaxableIncome);

			tax = calculateTaxSlab(netTaxableIncome, year, age, tax);

			cess = cessCalculation(tax, year, cess);

			totalTax = tax + cess;

			System.out.println(tax);
			System.out.println(cess);
			System.out.println(totalTax);
			
		} catch (UserDefinedException e) {
			 e.printStackTrace();
		}

		return null;
	}

	private float cessCalculation(float tax, int year, float cess) {

		if (tax > TaxCalculationConstants.FIVE_LAKH) {

			List<Object[]> calculateCess = TCD.getAgeInfoByYear(year);

			cess = tax * (((float) calculateCess.get(0)[1]) / 100);
		}
		return cess;

	}

	private float investmentDeduction(float salary, float investment, float netTaxableIncome) {

		if (salary > 0) {
			netTaxableIncome = salary - investment;
		}
		return netTaxableIncome;
	}

	private float calculateTaxSlab(float netTaxableIncome, int year, int age, float tax) {

		if (netTaxableIncome > TaxCalculationConstants.LAKH) {

			List<Object[]> calculateTaxSlab = TCD.calculateTaxSlab(year);

			for (Object[] slab : calculateTaxSlab) {
				float lowerBound = (float) slab[0];
				float upperBound = (float) slab[1];

				if (netTaxableIncome > upperBound && upperBound > 0) {

					float bound = upperBound - lowerBound;
					tax = tax + (bound * (((float) slab[2]) / 100));
//					float remainingValue = tax > 0.0 ? tax : TaxCalculationConstants.LAKH;
					netTaxableIncome = netTaxableIncome - bound;
				} else if (upperBound == 0 && netTaxableIncome > lowerBound) {

					tax = tax + (netTaxableIncome * (((float) slab[2]) / 100));
					float remainingValue = tax > 0.0 ? tax : TaxCalculationConstants.LAKH;
					netTaxableIncome = netTaxableIncome - remainingValue;
				} else if (upperBound != 0) {

					tax = tax + (netTaxableIncome * (((float) slab[2]) / 100));
				}

			}

			return tax;
		}
		return tax;

	}

	public float ageBenifites(int age, int year, float investmentDeduction) {

		if (age > 60) {

			try {
				List<Object[]> specialRelaxation = TCD.getAgeInfoByYear(year);
				System.out.println(specialRelaxation.size());
				return investmentDeduction - (float) specialRelaxation.get(0)[3];
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return investmentDeduction;
	}

	private void validation(int year, int age, float salary) throws UserDefinedException {

		if (age <= 0) {
			throw new UserDefinedException("Age should be greater than 0");
		}
		if (salary <= 500000) {
			throw new UserDefinedException("Salary should be greater than 5Lakh to come under tax slab : Tax is Zero");
		}

	}

}
