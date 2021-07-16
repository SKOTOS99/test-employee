package com.upax.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.upax.app.entity.Employee;
import com.upax.app.entity.EmployeeWorkedHours;

public interface EmployeeWorkedHoursDao extends CrudRepository<EmployeeWorkedHours,Long>{

}
