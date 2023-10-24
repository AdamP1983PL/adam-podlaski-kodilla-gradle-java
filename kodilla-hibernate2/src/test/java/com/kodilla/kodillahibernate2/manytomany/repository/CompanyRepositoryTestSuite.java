package com.kodilla.kodillahibernate2.manytomany.repository;

import com.kodilla.kodillahibernate2.manytomany.Company;
import com.kodilla.kodillahibernate2.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CompanyRepositoryTestSuite {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testSaveManyToMany() {
        // given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Smith");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        // when
        companyRepository.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyRepository.save(dataMaesters);
        int dataMasterId = dataMaesters.getId();
        companyRepository.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        // then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMasterId);
        assertNotEquals(0, greyMatterId);

        // cleanUp
        try {
            companyRepository.deleteById(softwareMachineId);
            companyRepository.deleteById(dataMasterId);
            companyRepository.deleteById(greyMatterId);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testNamedQueries(){
        // given
        Employee james = new Employee("James", "Gosling");
        Employee sara = new Employee("Sara", "Gosling");
        Employee bill = new Employee("Bill", "Gates");
        employeeRepository.save(james);
        int jamesId = james.getId();
        employeeRepository.save(sara);
        int saraId = sara.getId();
        employeeRepository.save(bill);
        int billId = bill.getId();

        Company sunMicrosystems = new Company("Sun...");
        Company microsoft = new Company("Microsoft");
        companyRepository.save(sunMicrosystems);
        int sunMicrosystemsId = sunMicrosystems.getId();
        companyRepository.save(microsoft);
        int microsoftId = microsoft.getId();

        sunMicrosystems.getEmployees().add(james);
        sunMicrosystems.getEmployees().add(sara);
        microsoft.getEmployees().add(bill);

        james.getCompanies().add(sunMicrosystems);
        sara.getCompanies().add(sunMicrosystems);
        bill.getCompanies().add(microsoft);

        // when
        List<Employee> goslingsFamily = employeeRepository.retrieveEmployeesWithGivenLastName("Gosling");
        List<Employee> gatesFamily = employeeRepository.retrieveEmployeesWithGivenLastName("Gates");
        List<Company> companiesNamesStartingFromSun = companyRepository.retrieveCompaniesStartingFrom("Sun%");
        List<Company> companiesNamesStartingFromMic = companyRepository.retrieveCompaniesStartingFrom("Mic%");

        // then
        try {
            assertEquals(2, goslingsFamily.size());
            assertEquals(1, gatesFamily.size());
            assertEquals(1, companiesNamesStartingFromSun.size());
            assertEquals(1, companiesNamesStartingFromMic.size());
        } catch (Exception e){

        } finally {
            // cleanUp
            employeeRepository.deleteById(jamesId);
            employeeRepository.deleteById(saraId);
            employeeRepository.deleteById(billId);
            companyRepository.deleteById(sunMicrosystemsId);
            companyRepository.deleteById(microsoftId);
        }
    }
}
