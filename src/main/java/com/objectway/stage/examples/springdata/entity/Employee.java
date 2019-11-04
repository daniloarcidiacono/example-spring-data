package com.objectway.stage.examples.springdata.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Entity class managed by Hibernate.
 */
@Entity
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = { "first", "last" }))
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "first", nullable = false)
    private String firstName;

    @Column(name = "last", nullable = false)
    private String lastName;

    public Employee() {
        // this form used by Hibernate
    }

    public Employee(int age, String firstName, String lastName) {
        // for application use, to create new employees
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(int id, int age, String firstName, String lastName) {
        // for application use, to create new employees
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                age == employee.age &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
