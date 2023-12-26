package com.kodilla.kodillahibernate2.manytomany.facade;

import com.kodilla.kodillahibernate2.manytomany.Company;
import com.kodilla.kodillahibernate2.manytomany.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFinderFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFinderFacade.class);

    @Autowired
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyFinderFacade(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findCompanyWithGivenNameSnippet(String nameSnippet) throws CompanyQueryProcessingException {
        List<Company> companiesWithGivenNameSnippet;
        List<Company> companies = (List<Company>) companyRepository.findAll();
        boolean wasError = false;
        long companiesListSize = companies.size();
        if (companiesListSize < 1) {
            LOGGER.error(CompanyQueryProcessingException.ERR_EMPTY_DATABASE);
            wasError = true;
            throw new CompanyQueryProcessingException (CompanyQueryProcessingException.ERR_EMPTY_DATABASE);
        }
        try {
            companiesWithGivenNameSnippet = companyRepository
                    .retrieveCompaniesLike("%" + nameSnippet + "%");
            if (companiesWithGivenNameSnippet.size() == 0) {
                LOGGER.error(CompanyQueryProcessingException.ERR_COMPANY_NOT_FOUND);
                throw new CompanyQueryProcessingException(CompanyQueryProcessingException.ERR_COMPANY_NOT_FOUND);
            } else {
                companiesWithGivenNameSnippet.forEach(System.out::println);
            }
        } catch (CompanyQueryProcessingException e) {
            LOGGER.error(CompanyQueryProcessingException.ERR_COMPANY_NOT_FOUND);
            throw new CompanyQueryProcessingException(CompanyQueryProcessingException.ERR_COMPANY_NOT_FOUND);
        }
        return companiesWithGivenNameSnippet;
    }

}
