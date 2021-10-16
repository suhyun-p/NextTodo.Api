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
    public List<TodoMain> todos() { return todosService.todos(); }

    @PutMapping("/todos/{id}")
    public long updateTodo(@PathVariable long id, @RequestBody TodosReq req) {
        return todosService.updateTodo(id, req);
    }

    @PostMapping("/todos")
    public long addTodo(@RequestBody TodosReq req) {
        return todosService.addTodo(req);
    }
}
