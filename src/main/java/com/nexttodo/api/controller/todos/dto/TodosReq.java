package com.nexttodo.api.controller.todos.dto;

import com.nexttodo.api.repository.dto.TodoMain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodosReq {
    private String text;
    private String color;

    public TodoMain toEntity() {
        return TodoMain.builder()
                .text(this.text)
                .color(this.color)
                .checked(false)
                .build();
    }
}