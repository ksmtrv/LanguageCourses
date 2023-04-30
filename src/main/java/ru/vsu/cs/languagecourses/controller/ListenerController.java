package ru.vsu.cs.languagecourses.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.languagecourses.dto.listener.IListenerDto;
import ru.vsu.cs.languagecourses.dto.listener.ListenerDto;
import ru.vsu.cs.languagecourses.service.ListenerService;

import java.util.List;

@RestController
public class ListenerController {
    private final ListenerService service;

    public ListenerController(ListenerService service) {
        this.service = service;
    }

    @GetMapping("/listeners")
    public List<IListenerDto> getListeners(@RequestParam(required = false) Boolean full) {
        if (full == null || !full) {
            return service.getAllListeners();
        }
        return service.getAllListeners(true);

    }

    @PostMapping("/listeners")
    public void addNewListener(@RequestBody ListenerDto listenerDto) {
        service.saveNewListener(listenerDto);
    }

    @PutMapping("/listeners/{id}")
    public void updateListener(@PathVariable Long id, @RequestBody ListenerDto listenerDto) {
        service.updateListener(id, listenerDto);
    }

    @DeleteMapping("/listeners/{id}")
    public void deleteListener(@PathVariable Long id) {
        service.deleteListener(id);
    }

    @PostMapping("/listeners/addCourse")
    public void addCourse(@RequestParam Long lId, @RequestParam Long cId) {
        service.addCourseToListener(lId, cId);
    }
}
