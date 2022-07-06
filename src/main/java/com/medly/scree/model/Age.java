package com.medly.scree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AGE")
public class Age {

	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="RELAXATION")
	private float relaxation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public double getRelaxation() {
		return relaxation;
	}

	public void setRelaxation(float relaxation) {
		this.relaxation = relaxation;
	}

	@Override
	public String toString() {
		return "Age [id=" + id + ", age=" + age + ", relaxation=" + relaxation + "]";
	}
	
	
}
