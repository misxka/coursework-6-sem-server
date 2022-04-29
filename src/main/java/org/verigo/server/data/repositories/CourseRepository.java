package org.verigo.server.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.verigo.server.data.entities.Course;
import org.verigo.server.data.entities.User;

import java.math.BigDecimal;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Page<Course> findAllByTitleContainsIgnoreCaseAndLanguageContainsIgnoreCaseAndLevelContainsIgnoreCaseAndIsOnlineAndPriceGreaterThanEqualAndPriceLessThanEqual(String title, String language, String level, boolean isOnline, BigDecimal min, BigDecimal max, Pageable page);
    List<Course> findAllByParticipantsNot(User user);
    List<Course> findAllByParticipants(User user);
}
