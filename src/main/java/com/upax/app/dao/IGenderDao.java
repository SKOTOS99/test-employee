package com.upax.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.upax.app.entity.Gender;

public interface IGenderDao extends CrudRepository<Gender,Long>{

}
