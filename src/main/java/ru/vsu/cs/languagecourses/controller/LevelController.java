package ru.vsu.cs.languagecourses.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses.dto.LevelDto;
import ru.vsu.cs.languagecourses.service.LevelService;

import java.util.List;

@RestController
public class LevelController {
    private final LevelService service;

    public LevelController(LevelService service) {
        this.service = service;
    }

    @GetMapping("/levels")
    public List<LevelDto> getLevels() {
        return service.getAllLevels();
    }

    @PostMapping("/levels")
    public void addNewLevel(@RequestBody LevelDto levelDto) {
        service.saveNewLevel(levelDto);
    }

    @PutMapping("/levels/{id}")
    public void updateLevel(@PathVariable Long id, @RequestBody LevelDto levelDto) {
        service.updateLevel(id, levelDto);
    }

    @DeleteMapping("/levels/{id}")
    public void deleteLevel(@PathVariable Long id) {
        service.deleteLevel(id);
    }
}
