package ru.vsu.cs.languagecourses.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses.dto.LanguageDto;
import ru.vsu.cs.languagecourses.entity.Language;
import ru.vsu.cs.languagecourses.service.LanguageService;

import java.util.List;

@RestController
public class LanguageController {
    private final LanguageService service;

    public LanguageController(LanguageService service) {
        this.service = service;
    }

    @GetMapping("/languages")
    public List<LanguageDto> getLanguages() {
        return service.getAllLanguages();
    }

    @PostMapping("/language/new")
    public void addNewLanguage(@RequestBody Language language) {
        service.saveNewLanguage(language);
    }

    @PutMapping("/language/{id}")
    public void updateLanguage(@PathVariable Long id, @RequestBody Language language) {
        service.updateLanguage(id, language);
    }

    @DeleteMapping("/language/delete/{id}")
    public void deleteLanguage(@PathVariable Long id) {
        service.deleteLanguage(id);
    }
}
