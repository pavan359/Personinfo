package com.pavan.persons.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pavan.persons.Adress;

@Repository
public interface AdressDao  extends CrudRepository<Adress, Integer> 
{

}



