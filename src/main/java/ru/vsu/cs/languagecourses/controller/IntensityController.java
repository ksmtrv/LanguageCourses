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

    @GetMapping("/intensity")
    public List<IntensityDto> getIntensity() {
        return service.getAllIntensity();
    }

    @PostMapping("/intensity/new")
    public void addNewIntensity(@RequestBody Intensity intensity) {
        service.saveNewIntensity(intensity);
    }

    @PutMapping("/intensity/{id}")
    public void updateIntensity(@PathVariable Long id, @RequestBody Intensity intensity) {
        service.updateIntensity(id, intensity);
    }
}
