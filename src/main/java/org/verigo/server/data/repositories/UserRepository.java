package org.verigo.server.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.verigo.server.data.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLogin(String login);
    Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);
    List<User> findAllByRole(String role);
    List<User> findAllByFullname(String fullname);
    Page<User> findAllByLoginContainsIgnoreCaseAndEmailContainsIgnoreCaseAndFullnameContainsIgnoreCaseAndRoleContainsIgnoreCase(String login, String Email, String Fullname, String role, Pageable page);
}
