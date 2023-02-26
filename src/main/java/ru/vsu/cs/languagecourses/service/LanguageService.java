package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.mapper.LanguageMapper;
import ru.vsu.cs.languagecourses.repository.LanguageRepository;

@Service
public class LanguageService {
    private final LanguageRepository repository;
    private final LanguageMapper mapper;

    public LanguageService(LanguageRepository repository, LanguageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
