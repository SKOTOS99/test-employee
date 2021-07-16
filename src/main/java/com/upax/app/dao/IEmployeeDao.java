package com.upax.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.upax.app.entity.Employee;
import com.upax.app.entity.Gender;

public interface IEmployeeDao extends CrudRepository<Employee,Long>{

}
