package model.service;

import model.entity.Person;

import java.util.List;

public interface PersonServiceIX {
    void save(Person person)throws Exception;
    void update(Person person)throws Exception;
    void delete(Person person)throws Exception;
    Person findOne(Person person)throws Exception;
    List<Person> findAll()throws Exception;
}
