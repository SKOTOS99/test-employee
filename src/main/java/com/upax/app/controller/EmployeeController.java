package com.upax.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upax.app.entity.EmployeeWorkedHours;
import com.upax.app.entity.Gender;
import com.upax.app.entity.Jobs;
import com.upax.app.request.EmployeWorkedHoursEntity;
import com.upax.app.request.EmployeeRequest;
import com.upax.app.service.IEmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
	private IEmployeeService empService;
	

	@PostMapping("/employee")
	@ApiOperation(value = "add employee to db")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, ?> add_empleados(@RequestBody EmployeeRequest emp){
		
		return empService.add_Employee(emp);
	}
	
	@PostMapping("/job")
	@ApiOperation(value = "add job to db")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, ?> add_job(@RequestBody Jobs job){
		
		return empService.add_job(job);
	}
	
	
	@PostMapping("/gender")
	@ApiOperation(value = "add gender to db")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, ?> add_gender(@RequestBody Gender gender){
		
		return empService.add_gender(gender);
	}
	
	@PostMapping("/employeeWorkedHours")
	@ApiOperation(value = "add gender to db")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, ?> add_gender(@RequestBody EmployeWorkedHoursEntity employeHours){
		
		return empService.add_employeWorked(employeHours);
	}


}
