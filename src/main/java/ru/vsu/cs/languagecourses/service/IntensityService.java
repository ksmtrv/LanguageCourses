package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.IntensityDto;
import ru.vsu.cs.languagecourses.entity.Intensity;
import ru.vsu.cs.languagecourses.mapper.IntensityMapper;
import ru.vsu.cs.languagecourses.repository.IntensityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntensityService {
    private final IntensityRepository repository;
    private final IntensityMapper mapper;

    public IntensityService(IntensityRepository repository, IntensityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<IntensityDto> getAllIntensity() {
        return repository.findAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    public void saveNewIntensity(Intensity intensity) {
        repository.save(intensity);
    }

    private Intensity findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }

    public void updateIntensity(Long id, Intensity intensity) {
        Intensity oldIntensity = findById(id);
        oldIntensity.setName(intensity.getName());
        repository.save(oldIntensity);
    }
}
