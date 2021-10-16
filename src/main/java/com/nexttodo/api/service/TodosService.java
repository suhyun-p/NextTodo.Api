package com.nexttodo.api.service;

import com.nexttodo.api.controller.todos.dto.TodosReq;
import com.nexttodo.api.repository.dto.TodoMain;

import java.util.List;

public interface TodosService {
    List<TodoMain> todos();
    Long updateTodo(Long id, TodosReq req);
    Long addTodo(TodosReq req);
}
