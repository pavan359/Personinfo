package com.pavan.persons.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pavan.persons.Person;
@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {

}
