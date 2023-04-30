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
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JoinColumn(name = "title")
    private String title;

    @NotNull
    @JoinColumn(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "intensity_id")
    private Intensity intensity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "course_listener",
            joinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id")},
            inverseJoinColumns = {
            @JoinColumn(name = "listener_id", referencedColumnName = "id")})
    private Set<Listener> listeners = new HashSet<>();
}