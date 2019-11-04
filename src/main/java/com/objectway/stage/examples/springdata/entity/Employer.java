package com.objectway.stage.examples.springdata.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity class managed by Hibernate.
 */
@Entity
@Table(name = "employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(
        mappedBy = "employer",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<Employee> employees = new ArrayList<>();

    public Employer() {
        // this form used by Hibernate
    }

    public Employer(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return id == employer.id &&
                Objects.equals(name, employer.name) &&
                Objects.equals(employees, employer.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employees);
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees.length=" + employees.size() +
                '}';
    }
}
