package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.Group;
import org.verigo.server.data.repositories.CourseRepository;
import org.verigo.server.data.repositories.GroupRepository;
import org.verigo.server.data.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(4)
public class GroupLoader implements CommandLineRunner {
    private final GroupRepository repository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public GroupLoader(GroupRepository repository, UserRepository userRepository, CourseRepository courseRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            Group group = new Group("English A1 - 2022Q1");
            group.setCourse(courseRepository.findById(1).get());
            group.setTeacher(userRepository.findById(1).get());

            List participants = new ArrayList<>();
            participants.add(userRepository.findById(2).get());
            participants.add(userRepository.findById(3).get());
            group.setParticipants(participants);

            this.repository.save(group);

            group = new Group("English A2 - 2022Q1");
            group.setCourse(courseRepository.findById(2).get());
            group.setTeacher(userRepository.findById(1).get());
            group.setParticipants(participants);
            this.repository.save(group);
        }
    }
}
