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
@Table(name = "listener")
public class Listener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JoinColumn(name = "name")
    private String name;

    @NotNull
    @JoinColumn(name = "surname")
    private String surname;

    @NotNull
    @JoinColumn(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "course_listener",
            joinColumns = {
                    @JoinColumn(name = "listener_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id")})
    private Set<Course> courses = new HashSet<>();
}
