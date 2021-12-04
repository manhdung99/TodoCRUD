package com.dungnm.todocrud.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dungnm.todocrud.model.Todo;

@Repository
public interface TodoReponsitory extends JpaRepository<Todo,Integer> {
	
	@Query("SELECT t FROM Todo t WHERE t.workName LIKE %?1%")
	public List<Todo> search(String keyword);

}
