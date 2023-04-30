package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.listener.IListenerDto;
import ru.vsu.cs.languagecourses.dto.listener.ListenerDto;
import ru.vsu.cs.languagecourses.entity.Course;
import ru.vsu.cs.languagecourses.entity.Listener;
import ru.vsu.cs.languagecourses.mapper.ListenerFullMapper;
import ru.vsu.cs.languagecourses.mapper.ListenerMapper;
import ru.vsu.cs.languagecourses.repository.CourseRepository;
import ru.vsu.cs.languagecourses.repository.ListenerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListenerService {
    private final ListenerRepository listenerRepository;
    private final ListenerMapper listenerMapper;
    private final CourseRepository courseRepository;
    private final ListenerFullMapper listenerFullMapper;

    public ListenerService(ListenerRepository listenerRepository, ListenerMapper listenerMapper,
                           CourseRepository courseRepository, ListenerFullMapper listenerFullMapper) {
        this.listenerRepository = listenerRepository;
        this.listenerMapper = listenerMapper;
        this.courseRepository = courseRepository;
        this.listenerFullMapper = listenerFullMapper;
    }

    public List<IListenerDto> getAllListeners(Boolean full) {
        if (!full) {
            return getAllListeners();
        }
        return listenerRepository.findAll().stream()
                .map(listenerFullMapper::toDto).collect(Collectors.toList());
    }

    public List<IListenerDto> getAllListeners() {
        return listenerRepository.findAll().stream()
                .map(listenerMapper::toDto).collect(Collectors.toList());
    }

    public void saveNewListener(ListenerDto listenerDto) {
        listenerRepository.save(listenerMapper.toEntity(listenerDto));
    }

    public void deleteListener(Long id) {
        listenerRepository.delete(listenerRepository.findById(id).
                orElseThrow(() -> new NoClassDefFoundError("Запись не найдена.")));
    }

    public void updateListener(Long id, ListenerDto listenerDto) {
        Listener oldListener = listenerRepository.findById(id).orElseThrow();
        oldListener.setName(listenerDto.getName());
        oldListener.setSurname(listenerDto.getSurname());
        oldListener.setEmail(listenerDto.getEmail());
        listenerRepository.save(oldListener);
    }

    public void addCourseToListener(Long listenerId, Long courseId) {
        Listener listener = listenerRepository.findById(listenerId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        listener.getCourses().add(course);
        listenerRepository.save(listener);
    }
}

