package com.medly.scree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEDUCTION")
public class Deduction {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "LOWER_BOUND")
	private float lowerBound;

	@Column(name = "UPPER_BOUND")
	private float upperBound;

	@Column(name = "TAX_PERCENTAGE")
	private float taxPercent;

	@JoinColumn(name = "YEARID_FK")
	@ManyToOne(fetch = FetchType.LAZY)
	private Year yearId_Fk;


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public float getLowerBound() {
		return lowerBound;
	}



	public void setLowerBound(float lowerBound) {
		this.lowerBound = lowerBound;
	}



	public float getUpperBound() {
		return upperBound;
	}



	public void setUpperBound(float upperBound) {
		this.upperBound = upperBound;
	}



	public float getTaxPercent() {
		return taxPercent;
	}



	public void setTaxPercent(float taxPercent) {
		this.taxPercent = taxPercent;
	}



	public Year getYearId_Fk() {
		return yearId_Fk;
	}



	public void setYearId_Fk(Year yearId_Fk) {
		this.yearId_Fk = yearId_Fk;
	}



	@Override
	public String toString() {
		return "Deduction [id=" + id + ", lowerBound=" + lowerBound + ", upperBound=" + upperBound + ", taxPercent="
				+ taxPercent + ", yearId_Fk=" + yearId_Fk + "]";
	}

	
}
