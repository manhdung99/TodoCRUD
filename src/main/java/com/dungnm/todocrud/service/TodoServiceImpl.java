package com.dungnm.todocrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dungnm.todocrud.model.Todo;
import com.dungnm.todocrud.reponsitory.TodoReponsitory;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoReponsitory todoReponsitory;
	

	@Override
	public List<Todo> getTodos() {
		List<Todo> todos =  (List<Todo>) todoReponsitory.findAll();	
		return todos;
	}

	@Override
	public Todo getTodoById(int id) {
		Todo todo = todoReponsitory.findById(id).get();
		return todo;
	}

	@Override
	public Todo insertTodo(Todo todo) {
		return todoReponsitory.save(todo);
	}

	@Override
	public void updateTodo(int id, Todo todo) {
		Todo todoFormDB = todoReponsitory.findById(id).get();
		todoFormDB.setWorkName(todo.getWorkName());
		todoFormDB.setStartDate(todo.getEndDate());
		todoFormDB.setEndDate(todo.getEndDate());
		todoFormDB.setTodoStatus(todo.getTodoStatus());
		todoReponsitory.save(todoFormDB);
	}

	@Override
	public void deleteTodo(int todoId) {
		todoReponsitory.deleteById(todoId);		
	}

	@Override
	public Page<Todo> getTodoByPage(Pageable pageable) {
		Page<Todo> todos =  (Page<Todo>) todoReponsitory.findAll(pageable);	
		return todos;
	}

	@Override
	public List<Todo> search(String keyword) {
		return todoReponsitory.search(keyword);
	}

}
