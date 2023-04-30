package ru.vsu.cs.languagecourses.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.languagecourses.dto.course.CourseFullDto;
import ru.vsu.cs.languagecourses.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseFullMapper {
        CourseFullDto toDto(Course course);
        Course toEntity(CourseFullDto dto);
}