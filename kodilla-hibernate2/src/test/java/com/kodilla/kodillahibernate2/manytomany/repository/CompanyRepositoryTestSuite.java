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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testNamedQueries() {
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
        Company microchip = new Company("Microchip");
        companyRepository.save(sunMicrosystems);
        int sunMicrosystemsId = sunMicrosystems.getId();
        companyRepository.save(microsoft);
        int microsoftId = microsoft.getId();
        companyRepository.save(microchip);
        int microchipId = microchip.getId();

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
            assertEquals(2, companiesNamesStartingFromMic.size());
        } catch (Exception e) {

        } finally {
            // cleanUp
            employeeRepository.deleteById(jamesId);
            employeeRepository.deleteById(saraId);
            employeeRepository.deleteById(billId);
            companyRepository.deleteById(sunMicrosystemsId);
            companyRepository.deleteById(microsoftId);
            companyRepository.deleteById(microchipId);
        }
    }

    @Test
    void testFindCompanyNameWithGivenSnippet() {
        // given
        Company company1 = new Company("Microsoft");
        Company company2 = new Company("New-microworld");
        Company company3 = new Company("Micro-Mechanics");
        companyRepository.save(company1);
        companyRepository.save(company2);
        companyRepository.save(company3);

        // when
        List<Company> companiesWithNameContainingMicSnippet = companyRepository.retrieveCompaniesLike("%Mic%");
        List<Company> companiesWithNameContainingXyzSnippet = companyRepository.retrieveCompaniesLike("%Xyz%");

        // then
        try {
            assertEquals(3, companiesWithNameContainingMicSnippet.size());
            assertEquals(0, companiesWithNameContainingXyzSnippet.size());
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        } finally {
            companyRepository.deleteAll();
        }
    }

}
