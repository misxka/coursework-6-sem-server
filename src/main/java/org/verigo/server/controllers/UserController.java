package org.verigo.server.controllers;

import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.verigo.server.data.entities.Course;
import org.verigo.server.data.entities.User;
import org.verigo.server.data.repositories.CourseRepository;
import org.verigo.server.data.repositories.UserRepository;
import org.verigo.server.mailer.EmailService;
import org.verigo.server.payloads.requests.user.CreateRequest;
import org.verigo.server.payloads.responses.DeleteResponse;
import org.verigo.server.payloads.responses.MessageResponse;
import org.verigo.server.payloads.responses.user.StatsResponse;
import org.verigo.server.payloads.responses.user.UpdateResponse;
import org.verigo.server.payloads.responses.user.UserDTO;
import org.verigo.server.payloads.responses.user.YearStatsResponse;
import org.verigo.server.services.UserService;

import javax.mail.MessagingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "", produces = "application/json")
    public Page<User> getUsers(@RequestParam(name = "page", required = false) String page,
           @RequestParam(name = "size", required = false) String size,
           @RequestParam(name = "field", required = false) String field,
           @RequestParam(name = "direction", required = false) boolean direction
    ) {
        return repository.findAll(PageRequest.of(
            Integer.valueOf(page),
            Integer.valueOf(size),
            direction ? Sort.by(field).ascending() : Sort.by(field).descending()
        ));
    }

    @GetMapping(value = "/filter", produces = "application/json")
    public Page<User> getFilteredUsers(@RequestParam(name = "page", required = false) String page,
           @RequestParam(name = "size", required = false) String size,
           @RequestParam(name = "field", required = false) String field,
           @RequestParam(name = "direction", required = false) boolean direction,
           @RequestParam(name = "login", required = false) String login,
           @RequestParam(name = "email", required = false) String email,
           @RequestParam(name = "fullname", required = false) String fullname,
           @RequestParam(name = "role", required = false) String role
    ) {
        return repository.findAllByLoginContainsIgnoreCaseAndEmailContainsIgnoreCaseAndFullnameContainsIgnoreCaseAndRoleContainsIgnoreCase(login, email, fullname, role, PageRequest.of(
            Integer.valueOf(page),
            Integer.valueOf(size),
            direction ? Sort.by(field).ascending() : Sort.by(field).descending()
        ));
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

        return ResponseEntity.ok(new MessageResponse("???????????????????????? ?????????????? ??????????????????????????????!"));
    }

    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    public UpdateResponse updateUser(@PathVariable int id, @RequestBody JsonPatch patch) {
        if (!repository.existsById(id)) return new UpdateResponse(id, null, 404, "???????????????????????? ???? ????????????.");

        try {
            User user = repository.findById(id).get();
            User userPatched = userService.applyPatchToUser(patch, user);
            repository.save(userPatched);

            return new UpdateResponse(id, new UserDTO(user), 200, "???????????????????????? ?????????????? ??????????????.");
        } catch (Exception e) {
            return new UpdateResponse(id, null, 500, "?????????????????? ????????????.");
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public DeleteResponse deleteUser(@PathVariable int id) {
        boolean isPresent = repository.existsById(id);
        if(!isPresent) return new DeleteResponse(404, "???????????????????????? ???? ????????????.");

        repository.deleteById(id);
        return new DeleteResponse(200, "???????????????????????? ????????????.");
    }

    @GetMapping(value = "/stats", produces = "application/json")
    public StatsResponse getStats(@RequestParam(name = "role", required = false) String role
    ) {
        return new StatsResponse(role, repository.countAllByRole(role));
    }

    @GetMapping(value = "/year-stats", produces = "application/json")
    public YearStatsResponse getYearStats() {
        try {
            Map<String, int[]> yearStatsMap = new HashMap<>();
            LocalDate currentDate = LocalDate.now();
            int currentYear = currentDate.getYear();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String[] roles = { "STUDENT", "TEACHER", "ADMIN" };

            for(String role: roles) {
                int year = currentYear;

                int[] amounts = new int[3];
                int i = 0;
                while(year > currentYear - 3) {
                    int amount = (repository.findAllByRoleBetweenDates(role, formatter.parse("01-01-" + year), formatter.parse("31-12-" + year))).size();
                    year--;
                    amounts[i++] = amount;
                }

                yearStatsMap.put(role.toLowerCase(), amounts);
            }

            return new YearStatsResponse(yearStatsMap);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(value = "/{userId}/courses/{courseId}")
    public DeleteResponse addCourse(@PathVariable(value = "userId") int userId, @PathVariable(value = "courseId") int courseId) {
        User user = repository.findById(userId).get();
        Course course = courseRepository.findById(courseId).get();

        user.addCourses(course);
        User updated = repository.save(user);

        return new DeleteResponse(200, "???? ?????????????? ???????????????? ???? ????????.");
    }
}
