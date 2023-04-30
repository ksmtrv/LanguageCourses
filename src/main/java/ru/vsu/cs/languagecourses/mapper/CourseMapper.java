package ru.vsu.cs.languagecourses.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.languagecourses.dto.course.CourseDto;
import ru.vsu.cs.languagecourses.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDto(Course course);
    Course toEntity(CourseDto dto);
}