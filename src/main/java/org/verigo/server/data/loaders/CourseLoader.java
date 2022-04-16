package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.Course;
import org.verigo.server.data.repositories.CourseRepository;

import java.math.BigDecimal;

@Component
public class CourseLoader implements CommandLineRunner {
    private final CourseRepository repository;

    @Autowired
    public CourseLoader(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            this.repository.save(new Course("English Course A1", new BigDecimal(123), "Английский", "A1", false));
            this.repository.save(new Course("English Course A2", new BigDecimal(153), "Английский", "A2", false));
        }
    }
}
