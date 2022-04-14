package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.Task;
import org.verigo.server.data.repositories.TaskRepository;

@Component
public class TaskLoader implements CommandLineRunner {
    private final TaskRepository repository;

    @Autowired
    public TaskLoader(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            this.repository.save(new Task("Lesson 1", "1st lesson of the course", false, 10));
            this.repository.save(new Task("Lesson 2", "2nd lesson of the course", false, 10));
        }
    }
}
