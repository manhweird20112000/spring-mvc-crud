package com.crud.mvc.repository;

import com.crud.mvc.models.Category;
import com.crud.mvc.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
    Iterable<Product> findProductByCategoryID(String categoryID);
}
