package com.crud.mvc.repository;

import com.crud.mvc.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {
}
