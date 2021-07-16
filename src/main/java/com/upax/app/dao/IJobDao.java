package com.upax.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.upax.app.entity.Jobs;


public interface IJobDao extends CrudRepository<Jobs,Long>{
	
	

}
