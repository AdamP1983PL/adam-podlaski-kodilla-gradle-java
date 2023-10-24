package com.kodilla.kodillahibernate2.manytomany.repository;

import com.kodilla.kodillahibernate2.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> retrieveEmployeesWithGivenLastName(@Param("LASTNAME") String lastName);

}
