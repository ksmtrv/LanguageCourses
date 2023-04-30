package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.LanguageDto;
import ru.vsu.cs.languagecourses.entity.Language;
import ru.vsu.cs.languagecourses.mapper.LanguageMapper;
import ru.vsu.cs.languagecourses.repository.LanguageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {
    private final LanguageRepository repository;
    private final LanguageMapper mapper;

    public LanguageService(LanguageRepository repository, LanguageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<LanguageDto> getAllLanguages() {
        return repository.findAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    public void saveNewLanguage(LanguageDto languageDto) {
        repository.save(mapper.toEntity(languageDto));
    }

    public void deleteLanguage(Long id) {
        repository.delete(repository.findById(id).
                orElseThrow(() -> new NoClassDefFoundError("Запись не найдена.")));
    }

    public void updateLanguage(Long id, Language language) {
        Language oldLanguage = repository.findById(id).orElseThrow();
        oldLanguage.setName(language.getName());
        repository.save(oldLanguage);
    }
}
