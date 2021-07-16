package com.upax.app.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upax.app.dao.EmployeeWorkedHoursDao;
import com.upax.app.dao.IEmployeeDao;
import com.upax.app.dao.IGenderDao;
import com.upax.app.dao.IJobDao;
import com.upax.app.entity.Employee;
import com.upax.app.entity.EmployeeWorkedHours;
import com.upax.app.entity.Gender;
import com.upax.app.entity.Jobs;
import com.upax.app.request.EmployeWorkedHoursEntity;
import com.upax.app.request.EmployeeRequest;

@Service
public class IEMployeeServiceImp implements IEmployeeService{

	@Autowired
	private IJobDao jobDao;
	
	@Autowired
	private IGenderDao genDao;
	
	@Autowired
	private IEmployeeDao empDao;
	
	@Autowired
	private EmployeeWorkedHoursDao employeWorkedDao;
	
	@Override
	public Map<String, ?> add_Employee(EmployeeRequest employee) {
		Map<String,Object > listParams = new HashMap<String,Object >();
		Date fecha = new Date();
		Gender gender = genDao.findById(employee.getGender_id()).orElse(null);
		Jobs job = jobDao.findById(employee.getJob_id()).orElse(null);
		if(gender!=null) {
			if(job!=null) {
				
				Employee employe =new Employee(gender, job, employee.getName(), employee.getLast_name(), employee.getBirthdate());
				empDao.save(employe);
				
			}else {
				listParams.put("message","no existe el trabajo");
			}
			
		}else {
			listParams.put("message", "no existe genero");
		}
		
		
		int edad = (employee.getBirthdate().getYear() - fecha.getYear());
		if(edad>=18) {
			System.out.println("es mayor de edad");
			
		}
		return listParams;
	}

	@Override
	public Map<String, ?> add_job(Jobs job) {
		// TODO Auto-generated method stub
		Map<String,Object > listParams = new HashMap<String,Object >();
		jobDao.save(job);
		listParams.put("message", "OK");
		
		return listParams;
	}

	@Override
	public Map<String, ?> add_gender(Gender gender) {
		// TODO Auto-generated method stub
		Map<String,Object > listParams = new HashMap<String,Object >();
		genDao.save(gender);
		listParams.put("message", "OK");
		
		return listParams;
	}

	@Override
	public Map<String, ?> add_employeWorked(EmployeWorkedHoursEntity employeeHours) {
		Map<String,Object > listParams = new HashMap<String,Object >();
		Employee employee = empDao.findById(employeeHours.getEmploye_id()).orElse(null);
		if(employee !=null) {
			EmployeeWorkedHours employeeWorked = new EmployeeWorkedHours(employee, employeeHours.getWorked_hours(),employeeHours.getWorked_date() );
			employeWorkedDao.save(employeeWorked);
			listParams.put("message", "OK");
		}else {
			listParams.put("message", "No existe el usuario");
		}
		return listParams;
	}

}
