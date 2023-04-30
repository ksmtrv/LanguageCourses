package ru.vsu.cs.languagecourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "intensity")
public class Intensity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JoinColumn(name = "name")
    private String name;

    @OneToMany(mappedBy = "intensity")
//    @JoinColumn(name = "id")
    private Set<Course> courses = new HashSet<>();
}
