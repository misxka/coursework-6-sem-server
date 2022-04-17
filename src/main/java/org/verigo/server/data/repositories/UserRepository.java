package org.verigo.server.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.verigo.server.data.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByLogin(String login);
    Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);
}
