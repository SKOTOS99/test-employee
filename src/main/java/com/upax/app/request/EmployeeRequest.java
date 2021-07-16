package com.upax.app.request;

import java.sql.Date;

import lombok.Data;

@Data
public class EmployeeRequest {
	
	private String name;
	private Long job_id;
	private Long gender_id;
	private String last_name;
	private Date birthdate;

}
