package com.example.mock.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.mock.dto.UpdateDTO;
import com.example.mock.model.ToDo;
import com.example.mock.service.ToDoService;
import com.example.mock.service.ToDoServiceImpl;
import jakarta.enterprise.inject.Produces;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Scope("session")
@RestController
public class ToDoController {
	
	@Produces
	ToDoService todoService = new ToDoServiceImpl();
	
	@RequestMapping(value="/mvc/todo", method=RequestMethod.GET)
	public ModelAndView todo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView("todo");
		mv.addObject("text", "MVC ToDo List");
		List<ToDo> todos = todoService.getAll();
		if(!todos.isEmpty()) {
			mv.addObject("todos",todos);
		} else {
			mv.addObject("todos", new ArrayList<>());
		}
		return mv;
	}
	
	@RequestMapping(value="/api/get-all", method=RequestMethod.GET)
	public ResponseEntity<List<ToDo>> getAll() { 
		List<ToDo> todos = todoService.getAll();
		return new ResponseEntity<List<ToDo>>(todos,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/get-by-id", method=RequestMethod.GET)
	public ResponseEntity<ToDo> getById(@RequestParam Long id) { 
		ToDo resp = null;
		Optional<ToDo> todo = todoService.getById(id);
		if(todo.isPresent()) { resp = todo.get();}
		return new ResponseEntity<ToDo>(resp,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/get-by-category", method=RequestMethod.GET)
	public ResponseEntity<List<ToDo>> getByCategory(@RequestParam String category) { 
		List<ToDo> todos = todoService.getByCategory(category);
		return new ResponseEntity<List<ToDo>>(todos,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/save-one", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody ToDo todo) { 
		ToDo todoSaved = todoService.save(todo);
		if(todoSaved != null) {
			return new ResponseEntity<ToDo>(todoSaved,HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/api/toggle-complete", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<UpdateDTO> toggleComplete(@RequestParam Long id) { 
		UpdateDTO updated  = todoService.toggle(id);
		if(updated.isSuccess()) {
			return new ResponseEntity<UpdateDTO>(updated,HttpStatus.OK);
		} else {
			return new ResponseEntity<UpdateDTO>(updated,HttpStatus.NOT_MODIFIED);
		}
	}
	
	@RequestMapping(value="/api/delete-one", method=RequestMethod.GET)
	public ResponseEntity<?> deleteById(@RequestParam Long id)  { 
		String resp = todoService.deleteById(id);
		if(!resp.isBlank()) {
			return new ResponseEntity<String>(resp,HttpStatus.GONE);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/api/get-by-title-like", method=RequestMethod.GET)
	public ResponseEntity<List<ToDo>> getByTitleLike(@RequestParam String term)  { 
		List<ToDo> todos = todoService.getByTitleLike(term);
		return new ResponseEntity<List<ToDo>>(todos,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/api/get-by-completed", method=RequestMethod.GET)
	public ResponseEntity<List<ToDo>> getByCompleted(@RequestParam Boolean isCompleted) { 
		List<ToDo> todos = todoService.getByCompleted(isCompleted);
		return new ResponseEntity<List<ToDo>>(todos,HttpStatus.OK);		
	}
}

