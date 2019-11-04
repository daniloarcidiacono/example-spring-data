package com.objectway.stage.examples.springdata;

import com.objectway.stage.examples.springdata.entity.Employee;
import com.objectway.stage.examples.springdata.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class ExampleSpringDataApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringDataApplication.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void run(String... args) {
        System.out.println("All employees");
        final List<Employee> all = employeeRepository.findAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }

        System.out.println("Employees with age > 18");
        final List<Employee> byAgeGreaterThan = employeeRepository.findByAgeGreaterThan(18);
        for (Employee employee : byAgeGreaterThan) {
            System.out.println(employee);
        }

        System.out.println("Employees with name longer than surname");
        final List<Employee> nameLongerThanSurname = employeeRepository.findNameLongerThanSurname();
        for (Employee employee : nameLongerThanSurname) {
            System.out.println(employee);
        }
    }
}
