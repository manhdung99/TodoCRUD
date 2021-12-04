package com.dungnm.todocrud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dungnm.todocrud.model.Todo;
import com.dungnm.todocrud.service.TodoService;

@CrossOrigin(origins = {"http://localhost:3000","https://manhdung99.github.io"})

@RestController
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	TodoService todoService;
	
	@GetMapping("/listAll")
	public List<Todo> getAllTodos(Model model){
		return (List<Todo>) todoService.getTodos();
	}
	
	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable("id") int id) {
		Todo todo = todoService.getTodoById(id);
		return todo;
	}
	@PostMapping("/add")
	public Todo addTodo(@RequestBody Todo todo ) {
		todoService.insertTodo(todo);
		return todo;
	}
	
	@PutMapping({"/{todoId}"})
    public Todo updateTodo(@PathVariable("todoId") int todoId, @RequestBody Todo todo) {
        todoService.updateTodo(todoId, todo);
        return todo;
    }
	
	@DeleteMapping("delete/{id}")
	public void deleteTodo(@PathVariable("id") int id) {
		todoService.deleteTodo(id); 
	}
	@GetMapping("/search/{keyword}")
    public List<Todo> searchTodo(@PathVariable("keyword") String keyword) {
        return (List<Todo>) todoService.search(keyword);
    }
	
	@GetMapping("listAll/{page}")
	public ResponseEntity<List<Todo>> listTodoByPage(@PathVariable("page") int page){
        Sort sort = Sort.by("todoStatus").ascending();
        int recordOnPage = 5;
        int startRecord = (page-1);     
        Pageable pageable = PageRequest.of(startRecord, recordOnPage, sort);
        List<Todo> pageList = null;
        Page<Todo> pageTodo= todoService.getTodoByPage(pageable);
        if(pageTodo != null && pageTodo.hasContent()) {
            pageList = pageTodo.getContent();
        }
        
        return new ResponseEntity<List<Todo>>(pageList, HttpStatus.OK);
    }
}
