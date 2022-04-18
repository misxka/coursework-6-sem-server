package org.verigo.server.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.verigo.server.data.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
