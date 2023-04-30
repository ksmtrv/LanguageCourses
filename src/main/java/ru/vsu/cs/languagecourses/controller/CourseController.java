package ru.vsu.cs.languagecourses.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses.dto.course.CourseDto;
import ru.vsu.cs.languagecourses.dto.course.ICourseDto;
import ru.vsu.cs.languagecourses.service.CourseService;

import java.util.List;


@RestController
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/courses")
    public List<ICourseDto> getCourses(@RequestParam(required = false) Boolean full) {
        if (full == null || !full) {
            return service.getAllCourses();
        }
        return service.getAllCourses(true);

    }

    @PostMapping("/courses")
    public void addNewCourse(@RequestBody CourseDto courseDto) {
        service.saveNewCourse(courseDto);
    }

    @PutMapping("/courses/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        service.updateCourse(id, courseDto);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }

    @PostMapping("/courses/addListener")
    public void addListener(@RequestParam Long cId, @RequestParam Long lId) {
        service.addListenerToCourse(cId, lId);
    }
}