package com.kodilla.kodillahibernate2.manytomany.facade;

import com.kodilla.kodillahibernate2.manytomany.Company;
import com.kodilla.kodillahibernate2.manytomany.repository.CompanyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CompanyFinderFacadeTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyFinderFacade companyFinderFacade;

    @AfterEach
    public void cleanUp() {
        companyRepository.deleteAll();
    }

    @Test
    void testCompanyFinderFacade() throws CompanyQueryProcessingException {
        // given
        Company microsoft = new Company("Microsoft");
        Company newMicrosoft = new Company("NewMicrosoft");
        Company sony = new Company("Sony");
        companyRepository.save(microsoft);
        companyRepository.save(newMicrosoft);
        companyRepository.save(sony);

        // when
        List<Company> companiesWithMicNameSnippet;
        try {
            companiesWithMicNameSnippet = companyFinderFacade.findCompanyWithGivenNameSnippet("mic");
        } catch (CompanyQueryProcessingException e) {
            throw new CompanyQueryProcessingException(CompanyQueryProcessingException.ERR_COMPANY_NOT_FOUND);
        }

        // then
        assertEquals(2, companiesWithMicNameSnippet.size());
    }

    @Test
    void shouldThrowExceptionWhenDatabaseIsEmpty() {
        // given, when
        CompanyQueryProcessingException exception = assertThrows(
                CompanyQueryProcessingException.class,
                () -> companyFinderFacade.findCompanyWithGivenNameSnippet("xxx"));

        // then
        assertEquals(CompanyQueryProcessingException.ERR_EMPTY_DATABASE, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNoRecordsFound() throws CompanyQueryProcessingException {
        // given
        Company microsoft = new Company("Microsoft");
        companyRepository.save(microsoft);

        // when
        CompanyQueryProcessingException exception = assertThrows(
                CompanyQueryProcessingException.class,
                () -> companyFinderFacade.findCompanyWithGivenNameSnippet("xxx"));

        // then
        assertEquals(CompanyQueryProcessingException.ERR_COMPANY_NOT_FOUND, exception.getMessage());
    }

}


