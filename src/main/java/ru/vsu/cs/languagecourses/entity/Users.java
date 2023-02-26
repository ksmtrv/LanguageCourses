package ru.vsu.cs.languagecourses.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Users {
    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer age;

}
