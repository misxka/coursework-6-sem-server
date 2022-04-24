package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.Category;
import org.verigo.server.data.repositories.CategoryRepository;


@Component
@Order(5)
public class CategoryLoader implements CommandLineRunner {
    private final CategoryRepository repository;

    @Autowired
    public CategoryLoader(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            Category category = new Category("Animal (set A)");
            this.repository.save(category);
            category = new Category("Animal (set B)");
            this.repository.save(category);
            category = new Category("Animal (set C)");
            this.repository.save(category);
            category = new Category("Action (set A)");
            this.repository.save(category);
            category = new Category("Action (set B)");
            this.repository.save(category);
            category = new Category("Emotions");
            this.repository.save(category);
            category = new Category("Fruits");
            this.repository.save(category);
            category = new Category("Clothes");
            this.repository.save(category);
        }
    }
}
