package org.verigo.server.data.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.Course;
import org.verigo.server.data.entities.Group;
import org.verigo.server.data.entities.User;
import org.verigo.server.data.repositories.UserRepository;

@Component
@RepositoryEventHandler
public class SpringDataRestEventHandler {

    private final UserRepository userRepository;

    @Autowired
    public SpringDataRestEventHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    public void applyUserInformationUsingSecurityContext(Group group) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User owner = this.userRepository.findByLogin(login);
        group.setTeacher(owner);
    }
}
