package ru.vsu.cs.languagecourses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses.entity.Course;

import java.util.List;
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();
}
