package com.kodilla.kodillahibernate2.manytomany.repository;

import com.kodilla.kodillahibernate2.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> retrieveEmployeesWithGivenLastName(@Param("LASTNAME") String lastName);

    List<Employee> retrieveEmployeesLike(@Param("NAME_SNIPPET") String nameSnippet);

}
