package com.objectway.stage.examples.springdata.repository;

import com.objectway.stage.examples.springdata.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /**
     * Spring query with naming convention
     */
    List<Employee> findByAgeGreaterThan(int age);

    /**
     * Custom query in HQL.
     */
    @Query("select e from Employee as e where length(e.firstName) > length(e.lastName)")
    List<Employee> findNameLongerThanSurname();
}
