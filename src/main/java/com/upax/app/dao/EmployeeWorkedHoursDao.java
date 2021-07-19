package com.upax.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.upax.app.entity.Employee;
import com.upax.app.entity.EmployeeWorkedHours;

public interface EmployeeWorkedHoursDao extends CrudRepository<EmployeeWorkedHours,Long>{
	
	@Query(value= "select * from employe_worked_hours where employee_id=?1",nativeQuery=true)
	public List<EmployeeWorkedHours> getWorkedHousrById(Long id);

}
