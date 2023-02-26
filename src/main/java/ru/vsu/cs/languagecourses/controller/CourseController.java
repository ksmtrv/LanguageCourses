package ru.vsu.cs.languagecourses.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses.dto.CourseDto;
import ru.vsu.cs.languagecourses.entity.Course;
import ru.vsu.cs.languagecourses.service.CourseService;

import java.util.List;


@RestController
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/courses")
    public List<CourseDto> getCourses() {
        return service.getAllCourses();
    }

    @PostMapping("/course/new")
    public void addNewCourse(@RequestBody Course course) {
        service.saveNewCourse(course);
    }

    @PutMapping("/course/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody Course course) {
        service.updateCourse(id, course);
    }

    @DeleteMapping("/course/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }
}
