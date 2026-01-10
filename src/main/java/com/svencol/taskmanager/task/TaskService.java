package com.svencol.taskmanager.task;

import com.svencol.taskmanager.task.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public TaskOut create(TaskCreate req) {
        Task saved = repo.save(new Task(req.title()));
        return toOut(saved);
    }

    public List<TaskOut> list() {
        return repo.findAll().stream().map(this::toOut).toList();
    }

    public TaskOut get(long id) {
        Task t = repo.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
        return toOut(t);
    }

    public TaskOut update(long id, TaskUpdate req) {
        Task t = repo.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
        if (req.title() != null) t.setTitle(req.title());
        if (req.done() != null) t.setDone(req.done());
        return toOut(repo.save(t));
    }

    public void delete(long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Task not found");
        repo.deleteById(id);
    }

    private TaskOut toOut(Task t) {
        return new TaskOut(t.getId(), t.getTitle(), t.isDone());
    }
}
