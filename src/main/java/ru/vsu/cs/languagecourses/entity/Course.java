package ru.vsu.cs.languagecourses.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    private Integer prices;
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
    @OneToMany
    @JoinColumn(name = "id")
    private List<CourseListener> course_listeners;
}
