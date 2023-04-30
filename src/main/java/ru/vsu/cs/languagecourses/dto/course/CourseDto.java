package ru.vsu.cs.languagecourses.dto.course;

import lombok.Data;

@Data
public class CourseDto implements ICourseDto{
    private String title;
    private Integer price;
}