package com.example.mock.service;

import java.util.List;
import java.util.Optional;

import com.example.mock.model.ToDo;


public interface ToDoService {
	
	public List<ToDo> getAll();
	public Optional<ToDo> getById(Long id);
	public List<ToDo> getByCategory(String category);
	public ToDo save(ToDo todo);
	public ToDo toggle(Long id);
	public String deleteById(Long id);
	public List<ToDo> getByTitleLike(String term);
	public List<ToDo> getByCompleted(Boolean isCompleted);

}
