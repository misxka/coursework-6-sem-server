package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.Task;
import org.verigo.server.data.repositories.CourseRepository;
import org.verigo.server.data.repositories.TaskRepository;

@Component
@Order(3)
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
            Task task = new Task("Task 1", "Task on Present Simple Tense", false, 10);
            task.setCourse(courseRepository.findById(1).get());
            this.repository.save(task);
            task = new Task("Task 2", "Task on Past Simple Tense", false, 10);
            task.setCourse(courseRepository.findById(1).get());
            this.repository.save(task);
            task = new Task("Task 3", "Task on Future Simple Tense", false, 10);
            task.setCourse(courseRepository.findById(2).get());
            this.repository.save(task);
            task = new Task("Task 4", "Task on Present Continuous Tense", false, 10);
            task.setCourse(courseRepository.findById(2).get());
            this.repository.save(task);
            task = new Task("Task 5", "Task on Past Continuous Tense", false, 10);
            task.setCourse(courseRepository.findById(4).get());
            this.repository.save(task);
            task = new Task("Task 6", "Task on Future Continuous Tense", false, 10);
            task.setCourse(courseRepository.findById(4).get());
            this.repository.save(task);
            task = new Task("Task 7", "Task on Present Perfect Tense", false, 10);
            task.setCourse(courseRepository.findById(4).get());
            this.repository.save(task);
            task = new Task("Task 8", "Task on Past Perfect Tense", false, 10);
            task.setCourse(courseRepository.findById(7).get());
            this.repository.save(task);
            task = new Task("Task 9", "Hometask on tenses", true, 10);
            task.setCourse(courseRepository.findById(7).get());
            this.repository.save(task);
            task = new Task("Task 10", "Review lesson", false, 10);
            task.setCourse(courseRepository.findById(7).get());
            this.repository.save(task);

            task = new Task("Task Lorem", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu ornare tellus. Vestibulum eget eros iaculis lectus congue tempor.", false, 10);
            task.setCourse(courseRepository.findById(1).get());
            this.repository.save(task);
            task = new Task("Task Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu ornare tellus. Vestibulum eget eros iaculis lectus congue tempor.", false, 10);
            task.setCourse(courseRepository.findById(2).get());
            this.repository.save(task);
            task = new Task("Task advantage", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu ornare tellus. Vestibulum eget eros iaculis lectus congue tempor.", false, 10);
            task.setCourse(courseRepository.findById(1).get());
            this.repository.save(task);
            task = new Task("Task Light", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu ornare tellus. Vestibulum eget eros iaculis lectus congue tempor.", false, 10);
            task.setCourse(courseRepository.findById(2).get());
            this.repository.save(task);
            task = new Task("Task Food", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu ornare tellus. Vestibulum eget eros iaculis lectus congue tempor.", false, 10);
            task.setCourse(courseRepository.findById(1).get());
            this.repository.save(task);
            task = new Task("Task Adverbs", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu ornare tellus. Vestibulum eget eros iaculis lectus congue tempor.", false, 10);
            task.setCourse(courseRepository.findById(4).get());
            this.repository.save(task);
            task = new Task("Task Adjectives", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu ornare tellus. Vestibulum eget eros iaculis lectus congue tempor.", false, 10);
            task.setCourse(courseRepository.findById(4).get());
            this.repository.save(task);
            task = new Task("Task Sports", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu ornare tellus. Vestibulum eget eros iaculis lectus congue tempor.", false, 10);
            task.setCourse(courseRepository.findById(1).get());
            this.repository.save(task);
            task = new Task("Task Health", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu ornare tellus. Vestibulum eget eros iaculis lectus congue tempor.", true, 10);
            task.setCourse(courseRepository.findById(7).get());
            this.repository.save(task);
            task = new Task("Task Clothes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu ornare tellus. Vestibulum eget eros iaculis lectus congue tempor.", false, 10);
            task.setCourse(courseRepository.findById(2).get());
            this.repository.save(task);
        }
    }
}
