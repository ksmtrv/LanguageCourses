package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.ListenerDto;
import ru.vsu.cs.languagecourses.entity.Listener;
import ru.vsu.cs.languagecourses.mapper.ListenerMapper;
import ru.vsu.cs.languagecourses.repository.ListenerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListenerService {
    private final ListenerRepository repository;
    private final ListenerMapper mapper;

    public ListenerService(ListenerRepository repository, ListenerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ListenerDto> getAllListeners() {
        return repository.findAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    public void saveNewListener(Listener listener) {
        repository.save(listener);
    }

    private Listener findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }

    public void updateListener(Long id, Listener listener) {
        Listener oldListener = findById(id);
        oldListener.setName(listener.getName());
        oldListener.setSurname(listener.getSurname());
        oldListener.setEmail(listener.getEmail());
        repository.save(oldListener);
    }

}
