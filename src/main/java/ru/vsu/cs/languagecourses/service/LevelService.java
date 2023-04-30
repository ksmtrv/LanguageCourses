package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.LevelDto;
import ru.vsu.cs.languagecourses.entity.Level;
import ru.vsu.cs.languagecourses.mapper.LevelMapper;
import ru.vsu.cs.languagecourses.repository.LevelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LevelService {
    private final LevelRepository repository;
    private final LevelMapper mapper;

    public LevelService(LevelRepository repository, LevelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<LevelDto> getAllLevels() {
        return repository.findAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    public void saveNewLevel(LevelDto levelDto) {
        repository.save(mapper.toEntity(levelDto));
    }

    public void deleteLevel(Long id) {
        repository.delete(repository.findById(id).
                orElseThrow(() -> new NoClassDefFoundError("Запись не найдена.")));
    }

    public void updateLevel(Long id, LevelDto levelDto) {
        Level oldLevel = repository.findById(id).orElseThrow();
        oldLevel.setName(levelDto.getName());
        repository.save(oldLevel);
    }
}
