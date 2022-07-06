package com.medly.screen.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medly.scree.model.Deduction;

@Repository
public interface ITaxCalculationDao extends CrudRepository<Deduction, Integer> {

	@Transactional
	@Modifying
	@Query("select d.lowerBound,d.upperBound,d.taxPercent,y.year,y.cees from Deduction d left Join Year y ON d.yearId_Fk=y.id where y.year=:year ")
	List<Object[]> calculateTaxSlab(int year);

	@Transactional
	@Modifying
	@Query("select y.year,y.cees,a.age,a.relaxation from Year y join Age a on y.ageId_Fk=a.id where y.year=:year ")
	List<Object[]> getAgeInfoByYear(int year);

}
