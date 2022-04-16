package org.verigo.server.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.verigo.server.data.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
