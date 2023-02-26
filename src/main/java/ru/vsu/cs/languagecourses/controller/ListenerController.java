package ru.vsu.cs.languagecourses.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses.dto.LanguageDto;
import ru.vsu.cs.languagecourses.dto.ListenerDto;
import ru.vsu.cs.languagecourses.entity.Language;
import ru.vsu.cs.languagecourses.entity.Listener;
import ru.vsu.cs.languagecourses.service.ListenerService;

import java.util.List;

@RestController
public class ListenerController {
    private final ListenerService service;

    public ListenerController(ListenerService service) {
        this.service = service;
    }

    @GetMapping("/listeners")
    public List<ListenerDto> getListeners() {
        return service.getAllListeners();
    }

    @PostMapping("/listener/new")
    public void addNewListener(@RequestBody Listener listener) {
        service.saveNewListener(listener);
    }

    @PutMapping("/listener/{id}")
    public void updateListener(@PathVariable Long id, @RequestBody Listener listener) {
        service.updateListener(id, listener);
    }

    @DeleteMapping("/listener/delete/{id}")
    public void deleteListener(@PathVariable Long id) {
        service.deleteListener(id);
    }
}
