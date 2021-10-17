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
        List<TodoMain> todos = todosService.todos();
        if(todos.isEmpty()) {
            todos.add(TodoMain.builder().id((long)1).text("마트 가서 장보기").color("red").checked(false).build());
            todos.add(TodoMain.builder().id((long)2).text("수학 숙제하기").color("orange").checked(false).build());
            todos.add(TodoMain.builder().id((long)3).text("코딩하기").color("yellow").checked(true).build());
            todos.add(TodoMain.builder().id((long)4).text("넥스트 공부하기").color("green").checked(true).build());
            todos.add(TodoMain.builder().id((long)5).text("요리 연습하기").color("blue").checked(false).build());
            todos.add(TodoMain.builder().id((long)6).text("분리수거 하기").color("navy").checked(false).build());
        }
        return todos;
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
