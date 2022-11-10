package com.springgraphql.app.repositories;

import com.springgraphql.app.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
