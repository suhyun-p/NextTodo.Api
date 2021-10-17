package com.nexttodo.api.controller.todos;

import com.nexttodo.api.controller.todos.dto.TodosReq;
import com.nexttodo.api.repository.dto.TodoMain;
import com.nexttodo.api.service.TodosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TodosController {

    @Autowired
    TodosService todosService;

    @GetMapping("/todos")
    public List<TodoMain> todos() {
        return todosService.todos();
    }

    @PostMapping("/todos")
    public long addTodo(@RequestBody TodosReq req) {
        return todosService.addTodo(req);
    }

    @PatchMapping("/todos/{id}")
    public long updateTodo(@PathVariable long id) {
        return todosService.updateTodo(id);
    }

    @DeleteMapping("/todos/{id}")
    public long deleteTodo(@PathVariable long id) {
        return todosService.deleteTodo(id);
    }
}
