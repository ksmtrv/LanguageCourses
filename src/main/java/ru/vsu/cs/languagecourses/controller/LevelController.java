package ru.vsu.cs.languagecourses.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses.dto.LevelDto;
import ru.vsu.cs.languagecourses.entity.Level;
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

    @PostMapping("/level/new")
    public void addNewLevel(@RequestBody Level level) {
        service.saveNewLevel(level);
    }

    @PutMapping("/level/{id}")
    public void updateLevel(@PathVariable Long id, @RequestBody Level level) {
        service.updateLevel(id, level);
    }

    @DeleteMapping("/level/delete/{id}")
    public void deleteLevel(@PathVariable Long id) {
        service.deleteLevel(id);
    }
}
