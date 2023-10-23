package com.kodilla.kodillahibernate2.manytomany.repository;

import com.kodilla.kodillahibernate2.manytomany.Company;
import com.kodilla.kodillahibernate2.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CompanyRepositoryTestSuite {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void testSaveManyToMany() {
        // given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
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

}
