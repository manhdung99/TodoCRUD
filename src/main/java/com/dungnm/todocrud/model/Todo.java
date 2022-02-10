package com.dungnm.todocrud.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todo")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "work")
	private String workName;
	@Column(name = "startDate")
	private LocalDate startDate;
	@Column(name = "endDate")
	private LocalDate endDate;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private TodoStatus todoStatus;
	public Todo() {
		super();
	}
	
	public Todo(Integer id, String workName, LocalDate startDate, LocalDate endDate, TodoStatus todoStatus) {
		super();
		this.id = id;
		this.workName = workName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.todoStatus = todoStatus;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public TodoStatus getTodoStatus() {
		return todoStatus;
	}
	public void setTodoStatus(TodoStatus todoStatus) {
		this.todoStatus = todoStatus;
	}
	
	

	
	
	
	
	
	
	
}
