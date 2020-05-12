package model.service;

import model.entity.Person;
import model.repository.PersonDataAccess;
import java.util.List;

/**
 * singleton pattern , try with resource
 */

public class PersonService implements PersonServiceIX {
    private PersonService(){}
    private static PersonService personService=new PersonService();
    public static PersonService getInstance(){
        return personService;
    }
    @Override
    public void save(Person person) throws Exception {
        try (PersonDataAccess personDataAccess=new PersonDataAccess()){
            personDataAccess.insert(person);
        }
    }

    @Override
    public void update(Person person) throws Exception {
        try(PersonDataAccess personDataAccess=new PersonDataAccess()){
            personDataAccess.update(person);
        }
    }

    @Override
    public void delete(Person person) throws Exception {
        try (PersonDataAccess personDataAccess=new PersonDataAccess()){
            personDataAccess.delete(person);
        }
    }

    @Override
    public Person findOne(Person person) throws Exception {
        try (PersonDataAccess personDataAccess=new PersonDataAccess()){
          return personDataAccess.selectOne(person);
        }
    }

    @Override
    public List<Person> findAll() throws Exception {
        try (PersonDataAccess personDataAccess=new PersonDataAccess()){
            return personDataAccess.selectAll();
        }
    }
}
