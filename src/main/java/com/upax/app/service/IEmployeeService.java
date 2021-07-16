package com.upax.app.service;

import java.util.Map;

import com.upax.app.entity.EmployeeWorkedHours;
import com.upax.app.entity.Gender;
import com.upax.app.entity.Jobs;
import com.upax.app.request.EmployeWorkedHoursEntity;
import com.upax.app.request.EmployeeRequest;

public interface IEmployeeService {
	
	
	public Map<String,?> add_Employee(EmployeeRequest employee);
	public Map<String,?> add_job(Jobs job);
	public Map<String,?> add_gender(Gender gender);
	public Map<String, ?> add_employeWorked(EmployeWorkedHoursEntity employeeHours);

}
