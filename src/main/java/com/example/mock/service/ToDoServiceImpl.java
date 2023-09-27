package com.example.mock.service;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.example.mock.model.ToDo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
public class ToDoServiceImpl implements ToDoService {
	
	private static final Logger log = LogManager.getLogger("ToDoServiceImpl");
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	private EntityManager em = emf.createEntityManager();

	@Override
	public List<ToDo> getAll() {
		//List<ToDo> todoList = new ArrayList<>();

		CriteriaQuery<ToDo> cq = em.getCriteriaBuilder().createQuery(ToDo.class);
		cq.select(cq.from(ToDo.class));
		
		return em.createQuery(cq).getResultList();
	}
	
}







