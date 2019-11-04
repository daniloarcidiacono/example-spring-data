package com.objectway.stage.examples.springdata.entity;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @Column(name = "level")
    private Integer level;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    public Employee() {
        // this form used by Hibernate
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee1 = (Employee) o;
        return id == employee1.id &&
                age == employee1.age &&
                Objects.equals(level, employee1.level) &&
                Objects.equals(firstName, employee1.firstName) &&
                Objects.equals(lastName, employee1.lastName) &&
                Objects.equals(salary, employee1.salary) &&
                Objects.equals(employer, employee1.employer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, firstName, lastName, level, salary, employer);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level=" + level +
                ", salary=" + salary +
                ", employer=" + employer +
                '}';
    }
}
