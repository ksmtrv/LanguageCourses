package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.CourseDto;
import ru.vsu.cs.languagecourses.entity.Course;
import ru.vsu.cs.languagecourses.mapper.CourseMapper;
import ru.vsu.cs.languagecourses.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository repository;
    private final CourseMapper mapper;

    public CourseService(CourseRepository repository, CourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CourseDto> getAllCourses() {
        return repository.findAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    public void saveNewCourse(Course course) {
        repository.save(course);
    }

    private Course findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }

    public void deleteCourse(Long id) {
        repository.delete(findById(id));
    }

    public void updateCourse(Long id, Course course) {
        Course oldCourse = findById(id);
        //oldCourse.setName(course.getName());
        oldCourse.setPrices(course.getPrices());
        repository.save(oldCourse);
    }
}
