package ru.vsu.cs.languagecourses.dto.course;

import lombok.Data;
import ru.vsu.cs.languagecourses.dto.listener.ListenerDto;

import java.util.Set;

@Data
public class CourseFullDto implements ICourseDto{
    private String title;
    private Integer price;

    private Set<ListenerDto> listeners;
}