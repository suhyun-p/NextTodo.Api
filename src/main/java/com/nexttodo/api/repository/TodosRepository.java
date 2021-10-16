package com.nexttodo.api.repository;

import com.nexttodo.api.repository.dto.TodoMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosRepository extends JpaRepository<TodoMain, Long> {
}
