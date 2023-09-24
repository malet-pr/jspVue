package com.example.mock.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.mock.model.ToDo;
import com.example.mock.service.ToDoService;
import com.example.mock.service.ToDoServiceImpl;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Scope("session")
@RestController
@RequestMapping("/mvc") 
public class ToDoController {
	
	private static final Logger log = LogManager.getLogger("ToDoController");
	
	@Produces
	ToDoService todoService = new ToDoServiceImpl();
	
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public ModelAndView todo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView("todo");
		
		mv.addObject("text", "MVC ToDo List");
		
		List<ToDo> todos = todoService.getAll();
		log.atError();
		if(!todos.isEmpty()) {
			mv.addObject("todos",todos);
		} else {
			mv.addObject("todos", new ArrayList<>());
		}
		
		return mv;
	}
	

}
