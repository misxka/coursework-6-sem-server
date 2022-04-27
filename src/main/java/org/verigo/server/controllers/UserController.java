package org.verigo.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.verigo.server.data.entities.Card;
import org.verigo.server.data.entities.User;
import org.verigo.server.data.repositories.UserRepository;
import org.verigo.server.mailer.EmailService;
import org.verigo.server.payloads.requests.user.CreateRequest;
import org.verigo.server.payloads.requests.user.UpdateRequest;
import org.verigo.server.payloads.responses.DeleteResponse;
import org.verigo.server.payloads.responses.MessageResponse;
import org.verigo.server.payloads.responses.user.UpdateResponse;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "", produces = "application/json")
    public Page<User> getUsers(@RequestParam(name = "page", required = false) String page, @RequestParam(name = "size", required = false) String size) {
        return repository.findAll(PageRequest.of(Integer.valueOf(page), Integer.valueOf(size)));
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<MessageResponse> addUser(@RequestBody CreateRequest payload) {
        User user = new User(payload.getLogin(), payload.getPassword(), payload.getEmail(), payload.getFullname(), payload.getRole());
        User createdUser = repository.save(user);

        try {
            emailService.sendMail(user);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(new MessageResponse("Пользователь успешно зарегистрирован!"));
    }

    @PutMapping()
    public UpdateResponse updateUser(@PathVariable int id, @RequestBody UpdateRequest updateRequest) {
        if (!repository.existsById(id)) return new UpdateResponse(id, null, 404, "Пользователь не найден.");

        //TODO: add real logic
        User user = repository.findById(id).get();
        repository.save(user);

        return new UpdateResponse(id, user, 200, "Пользователь успешно изменен.");
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public DeleteResponse deleteUser(@PathVariable int id) {
        boolean isPresent = repository.existsById(id);
        if(!isPresent) return new DeleteResponse(404, "Пользователь не найден.");

        repository.deleteById(id);
        return new DeleteResponse(200, "Пользователь удален.");
    }
}
