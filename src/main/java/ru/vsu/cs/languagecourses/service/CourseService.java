package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.mapper.CourseMapper;
import ru.vsu.cs.languagecourses.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository repository;
    private final CourseMapper mapper;

    public CourseService(CourseRepository repository, CourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


}
