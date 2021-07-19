package com.upax.app.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;




@Data
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id_employee;
	
	@ManyToOne
	@JoinColumn(name = "gender_id", referencedColumnName = "id")
	private Gender gender_id;
	
	@ManyToOne
	@JoinColumn(name = "job_id", referencedColumnName = "id")
	private Jobs job_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="birthdate")
	private Date birthdate;
	
	
	public Employee() {}

	public Employee(Gender gender_id, Jobs job_id, String name, String last_name, Date birthdate) {
		super();
		this.gender_id = gender_id;
		this.job_id = job_id;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
	}
	
	
	
	

}
