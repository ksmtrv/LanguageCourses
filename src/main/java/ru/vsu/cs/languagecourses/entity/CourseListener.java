package ru.vsu.cs.languagecourses.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courseListener")
public class CourseListener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "listener_id")
    private Listener listener;
}
