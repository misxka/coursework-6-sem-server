package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.Category;
import org.verigo.server.data.entities.Course;
import org.verigo.server.data.repositories.CategoryRepository;

import java.math.BigDecimal;

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
            Category category = new Category("Animal (set A)", "/animal-set-a");
            this.repository.save(category);
            category = new Category("Animal (set B)", "/animal-set-b");
            this.repository.save(category);
            category = new Category("Animal (set C)", "/animal-set-c");
            this.repository.save(category);
            category = new Category("Action (set A)", "/action-set-a");
            this.repository.save(category);
            category = new Category("Action (set B)", "/action-set-b");
            this.repository.save(category);
            category = new Category("Emotions", "/emotions");
            this.repository.save(category);
            category = new Category("Fruits", "/fruits");
            this.repository.save(category);
            category = new Category("Clothes", "/clothes");
            this.repository.save(category);
        }
    }
}
