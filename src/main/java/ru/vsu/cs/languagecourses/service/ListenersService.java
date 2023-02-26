package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.ListenersDto;
import ru.vsu.cs.languagecourses.dto.UsersDto;
import ru.vsu.cs.languagecourses.entity.Listeners;
import ru.vsu.cs.languagecourses.entity.Users;
import ru.vsu.cs.languagecourses.mapper.ListenersMapper;
import ru.vsu.cs.languagecourses.repository.ListenersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListenersService {
    private final ListenersRepository repository;
    private final ListenersMapper mapper;

    public ListenersService(ListenersRepository repository, ListenersMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ListenersDto> getAllListeners() {
        return repository.findAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    public void saveNewListener(Listeners listeners) {
        repository.save(listeners);
    }

    private Listeners findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }

    public void updateListener(Long id, Listeners listener) {
        Listeners oldListener = findById(id);
        oldListener.setName(listener.getName());
        oldListener.setSurname(listener.getSurname());
        oldListener.setEmail(listener.getEmail());
        repository.save(oldListener);
    }

}
