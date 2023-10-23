package com.kodilla.kodillahibernate2.invoice.repositories;

import com.kodilla.kodillahibernate2.invoice.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
