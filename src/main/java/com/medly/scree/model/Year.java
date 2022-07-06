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
@Table(name = "YEAR")
public class Year {
	
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="YEAR")
	private Integer year;
	
	@Column(name="CEES")
	private float cees;
	
	@JoinColumn(name="AGEID_FK")
	@ManyToOne(fetch = FetchType.LAZY)
	private Age ageId_Fk;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public float getCees() {
		return cees;
	}

	public void setCees(float cees) {
		this.cees = cees;
	}

	public Age getAgeId_Fk() {
		return ageId_Fk;
	}

	public void setAgeId_Fk(Age ageId_Fk) {
		this.ageId_Fk = ageId_Fk;
	}

	@Override
	public String toString() {
		return "Year [id=" + id + ", year=" + year + ", cees=" + cees + ", ageId_Fk=" + ageId_Fk + "]";
	}
	

}
