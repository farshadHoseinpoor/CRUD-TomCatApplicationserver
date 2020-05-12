package model.entity;

import java.io.Serializable;

public class Person implements Serializable {

    public Person(){}

    public Person(long id,String name){
        this.id=id;
        this.name=name;
    }
    public Person(String name){
        this.name=name;

    }


    private long id;

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    private String name;
}
