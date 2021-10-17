package com.nexttodo.api.service.impl;

import com.nexttodo.api.controller.todos.dto.TodosReq;
import com.nexttodo.api.repository.TodosRepository;
import com.nexttodo.api.repository.dto.TodoMain;
import com.nexttodo.api.service.TodosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodosServiceImpl implements TodosService {

    private final TodosRepository todosRepository;

    public List<TodoMain> todos() { return todosRepository.findAll(); }

    @Transactional
    public Long addTodo(TodosReq req) {
        return todosRepository.save(req.toEntity()).getId();
    }

    @Transactional
    public Long updateTodo(Long id) {
        TodoMain todo = todosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Data"));
        todo.update();
        return id;
    }

    @Transactional
    public Long deleteTodo(Long id) {
        TodoMain todo = todosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Data"));
        todosRepository.delete(todo);
        return id;
    }
}