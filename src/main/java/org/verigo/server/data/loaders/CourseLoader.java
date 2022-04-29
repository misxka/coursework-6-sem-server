package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.Course;
import org.verigo.server.data.repositories.CourseRepository;
import org.verigo.server.data.repositories.UserRepository;

import java.math.BigDecimal;

@Component
@Order(1)
public class CourseLoader implements CommandLineRunner {
    private final CourseRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public CourseLoader(CourseRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            Course course = new Course("English Course A1", new BigDecimal(123), "Английский", "A1", false);
            this.repository.save(course);
            course = new Course("English Course A2", new BigDecimal(153), "Английский", "A2", true);
            this.repository.save(course);
            course = new Course("Deutsch B2", new BigDecimal(236), "Немецкий", "B2", false);
            this.repository.save(course);
            course = new Course("English Course C2", new BigDecimal(227), "Английский", "C2", false);
            this.repository.save(course);
            course = new Course("Deutsch A1", new BigDecimal(192), "Немецкий", "A1", false);
            this.repository.save(course);
            course = new Course("Deutsch A2", new BigDecimal(184), "Немецкий", "A2", false);
            this.repository.save(course);
            course = new Course("English Course B1", new BigDecimal(233), "Английский", "B1", true);
            this.repository.save(course);
            course = new Course("Francais B1", new BigDecimal(173), "Французский", "B1", false);
            this.repository.save(course);
            course = new Course("Espanol B2", new BigDecimal(193), "Испанский", "B2", false);
            this.repository.save(course);
            course = new Course("Italiano B2", new BigDecimal(190), "Итальянский", "B2", false);
            this.repository.save(course);
            course = new Course("English Course C1", new BigDecimal(188), "Английский", "C1", false);
            this.repository.save(course);
            course = new Course("Francais A1", new BigDecimal(203), "Французский", "A1", true);
            this.repository.save(course);
            course = new Course("Italiano A2", new BigDecimal(213), "Итальянский", "A2", false);
            this.repository.save(course);
            course = new Course("Polska A2", new BigDecimal(173), "Польский", "A2", false);
            this.repository.save(course);
            course = new Course("Polska A1", new BigDecimal(193), "Польский", "A1", false);
            this.repository.save(course);
        }
    }
}
