package com.upax.app.entity;

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
@Table(name = "EMPLOYEE_WORKED_HOURS")
public class EmployeeWorkedHours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee id_employee;
	
	@Column(name="worked_hours")
	private Integer worked_hours;
	
	@Column(name="worked_date")
	private Date worked_date;

	public EmployeeWorkedHours(Employee id_employee, Integer worked_hours, Date worked_date) {
		super();
		this.id_employee = id_employee;
		this.worked_hours = worked_hours;
		this.worked_date = worked_date;
	}
	
	
	

}
