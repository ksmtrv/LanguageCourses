package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.mapper.IntensityMapper;
import ru.vsu.cs.languagecourses.repository.IntensityRepository;

@Service
public class IntensityService {
    private final IntensityRepository repository;
    private final IntensityMapper mapper;

    public IntensityService(IntensityRepository repository, IntensityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
