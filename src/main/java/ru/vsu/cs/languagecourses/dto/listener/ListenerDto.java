package ru.vsu.cs.languagecourses.dto.listener;

import lombok.Data;

@Data
public class ListenerDto implements IListenerDto{
    private String surname;
    private String name;
    private String email;
}

