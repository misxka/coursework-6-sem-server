package org.verigo.server.data.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.verigo.server.data.entities.User;
import org.verigo.server.data.repositories.UserRepository;

@Component
@Order(1)
public class UserLoader implements CommandLineRunner {
    private final UserRepository repository;

    @Autowired
    public UserLoader(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            this.repository.save(new User("teacher", "password", "fakemail@mailmailmailmail.com", "Иванов Иван", "TEACHER"));
            this.repository.save(new User("student1", "password", "fakemail@mailmailmailmail1.com", "Петров Иван", "STUDENT"));
            this.repository.save(new User("student2", "password", "fakemail@mailmailmailmail2.com", "Сергеев Иван", "STUDENT"));
        }
    }
}