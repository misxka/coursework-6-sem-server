package org.verigo.server.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.verigo.server.data.entities.Course;

import java.math.BigDecimal;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Page<Course> findAllByTitleContainsIgnoreCaseAndLanguageContainsIgnoreCaseAndLevelContainsIgnoreCaseAndIsOnlineAndPriceGreaterThanEqualAndPriceLessThanEqual(String title, String language, String level, boolean isOnline, BigDecimal min, BigDecimal max, Pageable page);
}
