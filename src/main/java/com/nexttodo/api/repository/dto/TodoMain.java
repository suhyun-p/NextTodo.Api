package com.nexttodo.api.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nexttodo.api.controller.todos.dto.TodosReq;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String text;

    @Column()
    private String color;

    @Column()
    private Boolean checked;

    public void update() {
        this.checked = !this.checked;
    }
}