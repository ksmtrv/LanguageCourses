package ru.vsu.cs.languagecourses.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CourseDto {
    private String title;
    private Integer price;
//    private Set<ListenerDto> listeners;
}

