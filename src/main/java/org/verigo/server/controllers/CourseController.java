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
import org.verigo.server.payloads.responses.DeleteResponse;
import org.verigo.server.payloads.responses.MessageResponse;
import org.verigo.server.payloads.requests.course.CreateRequest;
import org.verigo.server.payloads.responses.course.UpdateResponse;
import org.verigo.server.services.CourseService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CourseController {
    @Autowired
    private CourseRepository repository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "", produces = "application/json")
    public Page<Course> getCourses(@RequestParam(name = "page", required = false) String page,
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

    @GetMapping(value = "/students/{id}", produces = "application/json")
    public List<Course> getStudentCourses(@PathVariable int id) {
        List<Course> allCourses = repository.findAll();

        User user = userRepository.findById(id).get();
        List<Integer> excludedIds = repository.findAllByParticipants(user).stream().map(Course::getId).collect(Collectors.toList());

        List<Course> courses = new ArrayList(allCourses);
        excludedIds.forEach(excludedId -> courses.removeIf(course -> course.getId() == excludedId));

        return courses;
    }

    @GetMapping(value = "/students/self/{id}", produces = "application/json")
    public List<Course> getStudentPersonalCourses(@PathVariable int id) {
        List<Course> allCourses = repository.findAll();

        User user = userRepository.findById(id).get();
        List<Integer> includedIds = repository.findAllByParticipants(user).stream().map(Course::getId).collect(Collectors.toList());

        List<Course> courses = new ArrayList(allCourses);
        List<Course> filtered = new ArrayList<>();
        includedIds.forEach(includedId -> {
            courses.forEach(course -> {
                if(course.getId() == includedId) filtered.add(course);
            });
        });

        return filtered;
    }

    @GetMapping(value = "/filter", produces = "application/json")
    public Page<Course> getFilteredCourses(@RequestParam(name = "page", required = false) String page,
           @RequestParam(name = "size", required = false) String size,
           @RequestParam(name = "field", required = false) String field,
           @RequestParam(name = "direction", required = false) boolean direction,
           @RequestParam(name = "title", required = false) String title,
           @RequestParam(name = "priceMin", required = false) BigDecimal priceMin,
           @RequestParam(name = "priceMax", required = false) BigDecimal priceMax,
           @RequestParam(name = "language", required = false) String language,
           @RequestParam(name = "level", required = false) String level,
           @RequestParam(name = "isOnline", required = false) boolean isOnline
    ) {
        return repository.findAllByTitleContainsIgnoreCaseAndLanguageContainsIgnoreCaseAndLevelContainsIgnoreCaseAndIsOnlineAndPriceGreaterThanEqualAndPriceLessThanEqual(title, language, level, isOnline, priceMin, priceMax, PageRequest.of(
            Integer.valueOf(page),
            Integer.valueOf(size),
            direction ? Sort.by(field).ascending() : Sort.by(field).descending()
        ));
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<MessageResponse> addCourse(@RequestBody CreateRequest payload) {
        Course course = new Course(payload.getTitle(), payload.getPrice(), payload.getLanguage(), payload.getLevel(), payload.isOnline());
        Course createdCourse = repository.save(course);

        return ResponseEntity.ok(new MessageResponse("Курс успешно создан!"));
    }

    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    public UpdateResponse updateCourse(@PathVariable int id, @RequestBody JsonPatch patch) {
        if (!repository.existsById(id)) return new UpdateResponse(id, null, 404, "Курс не найден.");

        try {
            Course course = repository.findById(id).get();
            Course coursePatched = courseService.applyPatchToCourse(patch, course);
            repository.save(coursePatched);

            return new UpdateResponse(id, course, 200, "Курс успешно изменен.");
        } catch (Exception e) {
            return new UpdateResponse(id, null, 500, "Серверная ошибка.");
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public DeleteResponse deleteCourse(@PathVariable int id) {
        boolean isPresent = repository.existsById(id);
        if(!isPresent) return new DeleteResponse(404, "Курс не найден.");

        repository.deleteById(id);
        return new DeleteResponse(200, "Курс удален.");
    }
}
