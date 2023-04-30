package ru.vsu.cs.languagecourses.dto.listener;

import lombok.Data;
import ru.vsu.cs.languagecourses.dto.course.CourseDto;

import java.util.Set;
@Data
public class ListenerFullDto implements IListenerDto{
    private String surname;
    private String name;
    private String email;
    private Set<CourseDto> courses;
}
