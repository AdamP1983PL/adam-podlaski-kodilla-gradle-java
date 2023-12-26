package com.kodilla.kodillahibernate2.manytomany.facade;

import com.kodilla.kodillahibernate2.manytomany.Employee;
import com.kodilla.kodillahibernate2.manytomany.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeFinderFacadeTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeFinderFacade employeeFinderFacade;

    @AfterEach
    public void cleanUp() {
        employeeRepository.deleteAll();
    }

    @Test
    void testEmployeeFinderFacade() throws EmployeeQueryProcessingException {
        // given
        Employee robertMartin = new Employee("Robert", "Martin");
        Employee przemyslawBykowski = new Employee("Przemyslaw", "Bykowski");
        Employee herbertSchild = new Employee("Herbert", "Schildt");
        employeeRepository.save(robertMartin);
        employeeRepository.save(przemyslawBykowski);
        employeeRepository.save(herbertSchild);

        // when
        List<Employee> employeesWithGivenLastNameSnippet;
        try {
            employeesWithGivenLastNameSnippet = employeeFinderFacade.findEmployeeWithGivenLastNameSnippet("kow");
        } catch (EmployeeQueryProcessingException e) {
            throw new EmployeeQueryProcessingException(EmployeeQueryProcessingException.ERR_EMPLOYEE_NOT_FOUND);
        }

        // then
        assertEquals(1, employeesWithGivenLastNameSnippet.size());
        assertEquals("Bykowski", employeesWithGivenLastNameSnippet.get(0).getLastName());
        assertNotNull(employeesWithGivenLastNameSnippet);
    }

    @Test
    void shouldThrowExceptionWhenDatabaseIsEmpty() {
        // given, when
        EmployeeQueryProcessingException exception = assertThrows(
                EmployeeQueryProcessingException.class,
                () -> employeeFinderFacade.findEmployeeWithGivenLastNameSnippet("xxx"));

        // then
        assertEquals(EmployeeQueryProcessingException.ERR_EMPTY_DATABASE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNoRecordsFound() {
        // given
        Employee robertMartin = new Employee("Robert", "Martin");
        employeeRepository.save(robertMartin);

        // when
        EmployeeQueryProcessingException exception = assertThrows(
                EmployeeQueryProcessingException.class,
                () -> employeeFinderFacade.findEmployeeWithGivenLastNameSnippet("xxx"));

        // then
        assertEquals(EmployeeQueryProcessingException.ERR_EMPLOYEE_NOT_FOUND, exception.getMessage());
    }

}
