package com.example.mock.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Scope("session")
@RestController
@RequestMapping("/mvc") 
public class ToDoController {
	
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public ModelAndView todo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView("todo");
		
		mv.addObject("text", "MVC ToDo List");
		
		return mv;
	}
	

}
