package ru.vsu.cs.languagecourses.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses.dto.IntensityDto;
import ru.vsu.cs.languagecourses.entity.Intensity;
import ru.vsu.cs.languagecourses.service.IntensityService;

import java.util.List;

@RestController
public class IntensityController {
    private final IntensityService service;

    public IntensityController(IntensityService service) {
        this.service = service;
    }

    @GetMapping("/intensities")
    public List<IntensityDto> getIntensity() {
        return service.getAllIntensity();
    }

    @PostMapping("/intensities")
    public void addNewIntensity(@RequestBody IntensityDto intensityDto) {
        service.saveNewIntensity(intensityDto);
    }

    @PutMapping("/intensities/{id}")
    public void updateIntensity(@PathVariable Long id, @RequestBody Intensity intensity) {
        service.updateIntensity(id, intensity);
    }

    @DeleteMapping("/intensities/{id}")
    public void deleteIntensity(@PathVariable Long id) {
        service.deleteIntensity(id);
    }
}