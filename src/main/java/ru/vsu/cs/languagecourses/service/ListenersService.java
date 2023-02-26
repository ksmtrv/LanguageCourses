package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.mapper.ListenersMapper;
import ru.vsu.cs.languagecourses.repository.ListenersRepository;

@Service
public class ListenersService {
    private final ListenersRepository repository;
    private final ListenersMapper mapper;

    public ListenersService(ListenersRepository repository, ListenersMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

}
