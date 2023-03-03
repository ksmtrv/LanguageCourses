package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.ListenerDto;
import ru.vsu.cs.languagecourses.entity.Listener;
import ru.vsu.cs.languagecourses.mapper.ListenerMapper;
import ru.vsu.cs.languagecourses.repository.ListenerRepository;

import java.util.List;
import java.util.Optional;
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

    private Optional<Listener> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteListener(Long id) {
        var listener = findById(id);
        if (listener.isPresent()) {
            repository.delete(listener.get());
        }

    }

    public void updateListener(Long id, Listener listener) {
        var optOldListener = findById(id);
        if (optOldListener.isPresent()) {
            Listener oldListener = optOldListener.get();
            oldListener.setName(listener.getName());
            oldListener.setSurname(listener.getSurname());
            oldListener.setEmail(listener.getEmail());
            repository.save(oldListener);
        }
    }
}
