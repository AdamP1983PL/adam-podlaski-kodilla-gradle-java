package com.kodilla.kodillahibernate2.manytomany.repository;

import com.kodilla.kodillahibernate2.manytomany.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    List<Company> retrieveCompaniesStartingFrom(@Param("STRINGPARAM") String stringParam);
}
