package org.verigo.server.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.verigo.server.data.entities.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    List<Category> findAll();
}
