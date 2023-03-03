package ru.vsu.cs.languagecourses.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private String title;
    @NotNull
    private Integer price;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "intensity_id")
    private Intensity intensity;
    @NotNull
    @ManyToMany
    @JoinTable(
            name = "course_listener",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "listener_id"))
    private Set<Listener> listeners;
}