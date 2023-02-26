package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.mapper.LevelMapper;
import ru.vsu.cs.languagecourses.repository.LevelRepository;

@Service
public class LevelService {
    private final LevelRepository repository;
    private final LevelMapper mapper;

    public LevelService(LevelRepository repository, LevelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
