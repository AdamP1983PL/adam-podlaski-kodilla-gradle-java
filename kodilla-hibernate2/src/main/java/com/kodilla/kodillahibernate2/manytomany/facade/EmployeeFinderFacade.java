package com.kodilla.kodillahibernate2.manytomany.facade;

import com.kodilla.kodillahibernate2.manytomany.Employee;
import com.kodilla.kodillahibernate2.manytomany.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeFinderFacade {
    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeFinderFacade.class);

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeFinderFacade(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findEmployeeWithGivenLastNameSnippet(String nameSnippet) throws EmployeeQueryProcessingException {
        List<Employee> employeesWithGivenLastNameSnippet;
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        boolean wasError = false;
        if (employees.size() < 1) {
            LOGGER.error(EmployeeQueryProcessingException.ERR_EMPTY_DATABASE);
            wasError = true;
            throw new EmployeeQueryProcessingException(EmployeeQueryProcessingException.ERR_EMPTY_DATABASE);
        }
        try {
            employeesWithGivenLastNameSnippet = employeeRepository
                    .retrieveEmployeesLike("%" + nameSnippet + "%");

            if (employeesWithGivenLastNameSnippet.size() == 0) {
                LOGGER.error(EmployeeQueryProcessingException.ERR_EMPLOYEE_NOT_FOUND);
                throw new EmployeeQueryProcessingException(EmployeeQueryProcessingException.ERR_EMPLOYEE_NOT_FOUND);
            } else {
                employeesWithGivenLastNameSnippet.forEach(System.out::println);
            }
        } catch (EmployeeQueryProcessingException e) {
            LOGGER.error(EmployeeQueryProcessingException.ERR_EMPLOYEE_NOT_FOUND);
            throw new EmployeeQueryProcessingException(EmployeeQueryProcessingException.ERR_EMPLOYEE_NOT_FOUND);
        }
        return employeesWithGivenLastNameSnippet;
    }

}
