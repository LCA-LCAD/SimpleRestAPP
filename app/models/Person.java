package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sigetrans on 29/01/15.
 */
@Entity
public class Person extends Model {
    @Id
    Long id;
    String name;
    Integer age;
    public static Finder<Long, Person> finder = new Finder<Long, Person>(Long.class, Person.class);

    public Person(String name, Integer age){
        this.name=name;
        this.age=age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
