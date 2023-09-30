package com.example.mock.service;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.mock.dao.ToDoDAO;
import com.example.mock.dto.UpdateDTO;
import com.example.mock.model.ToDo;
import jakarta.enterprise.inject.Produces;


@Service
public class ToDoServiceImpl implements ToDoService {
	
	@Produces
	ToDoDAO todoDAO = new ToDoDAO();
	

	@Override
	public List<ToDo> getAll() {
		return todoDAO.getAll();
	}

	@Override
	public Optional<ToDo> getById(Long id) {
		return todoDAO.getById(id);
	}

	@Override
	public List<ToDo> getByCategory(String category) {
		return todoDAO.getByCategory(category);
	}
	
	@Override
	public ToDo save(ToDo todo) {
		return todoDAO.save(todo);
	}
	
	@Override
	public UpdateDTO toggle(Long id){
		return todoDAO.toggle(id);
	}

	@Override
	public String deleteById(Long id) {	
		return todoDAO.deleteById(id);
	}

	@Override
	public List<ToDo> getByTitleLike(String term) {
		return todoDAO.getByTitleLike(term);
	}

	@Override
	public List<ToDo> getByCompleted(Boolean isCompleted) {
		return todoDAO.getByCompleted(isCompleted);
	}
	
}







