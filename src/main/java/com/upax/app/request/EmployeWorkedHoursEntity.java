package com.upax.app.request;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeWorkedHoursEntity {
	
	private Long employe_id;
	private int worked_hours;
	private Date worked_date;

}
