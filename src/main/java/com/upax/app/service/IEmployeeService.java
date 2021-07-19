package com.upax.app.service;

import java.text.ParseException;
import java.util.Map;

import com.upax.app.entity.EmployeeWorkedHours;
import com.upax.app.entity.Gender;
import com.upax.app.entity.Jobs;
import com.upax.app.request.EmployeWorkedHoursEntity;
import com.upax.app.request.EmployeeRequest;

public interface IEmployeeService {
	
	
	public Map<String,?> add_Employee(EmployeeRequest employee);
	public Map<String,?> get_Employee( );
	public Map<String,?> add_job(Jobs job);
	public Map<String,?> add_gender(Gender gender);
	public Map<String, ?> add_employeWorked(EmployeWorkedHoursEntity employeeHours);
	public Map<String,?> get_hours(Long id);
	public Map<String,?> get_salary_by_hours(Long id);

}
