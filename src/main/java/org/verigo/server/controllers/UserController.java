package org.verigo.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.verigo.server.data.entities.User;
import org.verigo.server.data.repositories.UserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping(value = "", produces = "application/json")
    public Page<User> getUsers(@RequestParam(name = "page", required = false) String page, @RequestParam(name = "size", required = false) String size) {
        return repository.findAll(PageRequest.of(Integer.valueOf(page), Integer.valueOf(size)));
    }
}
