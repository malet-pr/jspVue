package com.example.mock.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.mock.model.ToDo;

@Service
public class ToDoServiceImpl implements ToDoService {
	
	private static final Logger log = LogManager.getLogger("ToDoServiceImpl");

	@Override
	public List<ToDo> getAll() {
		List<ToDo> todoList = new ArrayList<>();
		/*
		ToDo mockTodo = new ToDo();
		mockTodo.setId(1L);
		mockTodo.setTitle("prueba");
		todoList.add(mockTodo);
		*/
		log.atError();
		return todoList;
	}
	
}
