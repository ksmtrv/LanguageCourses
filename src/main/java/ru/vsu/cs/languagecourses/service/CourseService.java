package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.course.CourseDto;
import ru.vsu.cs.languagecourses.dto.course.ICourseDto;
import ru.vsu.cs.languagecourses.entity.Course;
import ru.vsu.cs.languagecourses.entity.Listener;
import ru.vsu.cs.languagecourses.mapper.CourseFullMapper;
import ru.vsu.cs.languagecourses.mapper.CourseMapper;
import ru.vsu.cs.languagecourses.repository.CourseRepository;
import ru.vsu.cs.languagecourses.repository.ListenerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final ListenerRepository listenerRepository;
    private final CourseFullMapper courseFullMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper,
                         ListenerRepository listenerRepository, CourseFullMapper courseFullMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.listenerRepository = listenerRepository;
        this.courseFullMapper = courseFullMapper;
    }

    public List<ICourseDto> getAllCourses(Boolean full) {
        if (!full) {
            return getAllCourses();
        }
        return courseRepository.findAll().stream()
                .map(courseFullMapper::toDto).collect(Collectors.toList());
    }

    public List<ICourseDto> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto).collect(Collectors.toList());
    }


    public void saveNewCourse(CourseDto courseDto) {
        courseRepository.save(courseMapper.toEntity(courseDto));
    }

    public void deleteCourse(Long id) {
        courseRepository.delete(courseRepository.findById(id).
                orElseThrow(() -> new NoClassDefFoundError("Запись не найдена.")));
    }

    public void updateCourse(Long id, CourseDto courseDto) {
        Course oldCourse = courseRepository.findById(id).orElseThrow();
        oldCourse.setTitle(courseDto.getTitle());
        oldCourse.setPrice(courseDto.getPrice());
        courseRepository.save(oldCourse);
    }

    public void addListenerToCourse(Long courseId, Long listenerId) {
        Listener listener = listenerRepository.findById(listenerId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        course.getListeners().add(listener);
        courseRepository.save(course);
    }
}
