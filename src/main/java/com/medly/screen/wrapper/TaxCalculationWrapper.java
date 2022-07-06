package com.medly.screen.wrapper;

public class TaxCalculationWrapper {

	float tax;

	float cess;

	float totalTax;

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getCess() {
		return cess;
	}

	public void setCess(float cess) {
		this.cess = cess;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	@Override
	public String toString() {
		return "TaxCalculationWrapper [tax=" + tax + ", cess=" + cess + ", totalTax=" + totalTax + "]";
	}

}
