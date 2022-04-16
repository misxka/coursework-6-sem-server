package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.Course;
import org.verigo.server.data.entities.Task;
import org.verigo.server.data.repositories.CourseRepository;
import org.verigo.server.data.repositories.TaskRepository;

@Component
public class TaskLoader implements CommandLineRunner {
    private final TaskRepository repository;
    private final CourseRepository courseRepository;

    @Autowired
    public TaskLoader(TaskRepository repository, CourseRepository courseRepository) {
        this.repository = repository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            Task task = new Task("Lesson 1", "1st lesson of the course", false, 10);
            task.setCourse(courseRepository.findById(1).get());
            this.repository.save(task);
            task = new Task("Lesson 2", "2nd lesson of the course", false, 10);
            task.setCourse(courseRepository.findById(1).get());
            this.repository.save(task);
        }
    }
}
