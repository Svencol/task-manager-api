package com.svencol.taskmanager.task;

import com.svencol.taskmanager.task.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskOut create(@Valid @RequestBody TaskCreate req) {
        return service.create(req);
    }

    @GetMapping
    public List<TaskOut> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public TaskOut get(@PathVariable long id) {
        return service.get(id);
    }

    @PatchMapping("/{id}")
    public TaskOut update(@PathVariable long id, @Valid @RequestBody TaskUpdate req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
