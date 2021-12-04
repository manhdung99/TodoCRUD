package com.dungnm.todocrud.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dungnm.todocrud.model.Todo;

@Service
public interface TodoService {
	List<Todo> getTodos();

    Todo getTodoById(int id);

    Todo insertTodo(Todo todo);

    void updateTodo(int id, Todo todo);

    void deleteTodo(int todoId);
    
    Page<Todo> getTodoByPage(Pageable pageable);

	List<Todo> search(String keyword);
    
    
}
