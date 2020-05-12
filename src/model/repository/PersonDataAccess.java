package model.repository;

import common.JDBC;
import exception.RecordNotFindException;
import model.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDataAccess implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDataAccess() throws Exception {
        connection = JDBC.getConnection(JDBC.FARSHAD);
        connection.setAutoCommit(false);
    }

    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("select person_seq.nextval nid from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getLong("nid"));

        preparedStatement = connection.prepareStatement("insert into person (id,name) values (?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.executeUpdate();
    }

    public void update(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("update person set name=? where id=?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setLong(2, person.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("delete person where id=?");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.executeUpdate();
    }

    public Person selectOne(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("select * from person where id=?");
        preparedStatement.setLong(1, person.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Person().setId(resultSet.getLong("id")).setName(resultSet.getString("name"));
        } else throw new RecordNotFindException();
    }

    public List<Person> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while (resultSet.next()) {
            personList.add(new Person().setId(resultSet.getLong("id")).setName(resultSet.getString("name")));
        }
        return personList;
    }

    @Override
    public void close() throws Exception {
        connection.commit();
        preparedStatement.close();
        connection.close();
    }
}
