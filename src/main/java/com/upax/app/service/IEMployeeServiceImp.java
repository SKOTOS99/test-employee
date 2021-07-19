package com.upax.app.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

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
	    Date date1=null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(employee.getBirthdate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		Date fecha = new Date();
		Gender gender = genDao.findById(employee.getGender_id()).orElse(null);
		Jobs job = jobDao.findById(employee.getJob_id()).orElse(null);
		if(gender!=null) {
			if(job!=null) {
				
				Employee employe =new Employee(gender, job, employee.getName(), employee.getLast_name(),date1 );
				empDao.save(employe);
				
			}else {
				listParams.put("message","no existe el trabajo");
			}
			
		}else {
			listParams.put("message", "no existe genero");
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

	@Override
	public Map<String, ?> get_Employee() {
		// TODO Auto-generated method stub
		Map<String,Object > listParams = new HashMap<String,Object >();
		
		List<Employee> employees = (List<Employee>) empDao.findAll();
		if(employees.size()!=0) {
			listParams.put("OK", employees);
		}else{
			listParams.put("error", "donst users");
		}
		return listParams;
	}

	@Override
	public Map<String, ?> get_hours(Long id) {
		// TODO Auto-generated method stub
		
		Map<String,Object > listParams = new HashMap<String,Object >();
		List<EmployeeWorkedHours> hours = employeWorkedDao.getWorkedHousrById(id);
		int hoursWorked = 0;
		if(hours.size()!=0) {
			int total = 0;
			for(EmployeeWorkedHours work: hours) {
				total = total+ work.getWorked_hours();
				
			}
			hoursWorked = total;
			listParams.put("worked hours ", total);
		}
		Employee employee = empDao.findById(id).orElse(null);
		int salary = employee.getJob_id().getSalary();
		listParams.put("salary by hours ", salary/hoursWorked);
		
		return listParams;
	}

	@Override
	public Map<String, ?> get_salary_by_hours(Long id) {
		// TODO Auto-generated method stub
		Map<String,Object > listParams = new HashMap<String,Object >();
		
		
		return listParams;
	}

}
