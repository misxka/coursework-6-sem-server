package org.verigo.server.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.verigo.server.data.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
}
