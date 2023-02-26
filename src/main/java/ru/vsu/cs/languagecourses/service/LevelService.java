package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.LevelDto;
import ru.vsu.cs.languagecourses.dto.UsersDto;
import ru.vsu.cs.languagecourses.entity.Level;
import ru.vsu.cs.languagecourses.entity.Users;
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

    public void saveNewLevel(Level level) {
        repository.save(level);
    }

    private Level findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }

    public void updateLevel(Long id, Level level) {
        Level oldLevel = findById(id);
        oldLevel.setName(level.getName());
        repository.save(oldLevel);
    }
}
