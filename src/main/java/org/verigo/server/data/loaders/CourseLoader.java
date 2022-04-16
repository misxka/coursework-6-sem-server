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
@Order(2)
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
            course.setTeacher(userRepository.findById(1).get());
            this.repository.save(course);
            course = new Course("English Course A2", new BigDecimal(153), "Английский", "A2", false);
            course.setTeacher(userRepository.findById(1).get());
            this.repository.save(course);
        }
    }
}
