package com.example.mock.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import org.hibernate.FlushMode;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import com.example.mock.dto.UpdateDTO;
import com.example.mock.model.ToDo;
import com.example.mock.model.ToDo_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ToDoDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	private EntityManager em = emf.createEntityManager();

	private SessionFactory getSessionFactory() {
		SessionFactory factory; 
	    try {
	        factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ToDo.class) .buildSessionFactory();
	     } catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	     }
	    return factory;
	}

	public List<ToDo> getAll() {
		CriteriaQuery<ToDo> cq = em.getCriteriaBuilder().createQuery(ToDo.class);
		cq.select(cq.from(ToDo.class));
		return em.createQuery(cq).getResultList();
	}

	public Optional<ToDo> getById(Long id) {
		CriteriaQuery<ToDo> cq = em.getCriteriaBuilder().createQuery(ToDo.class);
		Root<ToDo> root = cq.from(ToDo.class);
		cq.select(root).where(em.getCriteriaBuilder().equal(root.get(ToDo_.ID),id));
		Query<ToDo> query = (Query<ToDo>) em.createQuery(cq);
		Optional<ToDo> todo = Optional.ofNullable(query.getSingleResultOrNull());
		return todo;
	}

	public List<ToDo> getByCategory(String category) {
		CriteriaQuery<ToDo> cq = em.getCriteriaBuilder().createQuery(ToDo.class);
		Root<ToDo> root = cq.from(ToDo.class);
		cq.select(root).where(em.getCriteriaBuilder().equal(root.get(ToDo_.CATEGORY),category));
		Query<ToDo> query = (Query<ToDo>) em.createQuery(cq);
		List<ToDo> todos = query.getResultList();
		return todos;
	}
	
	public ToDo save(ToDo todo) {
		Transaction transaction = null;
 		try (Session session = this.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(todo);
			transaction.commit();
			return todo;
		} catch (Exception e) {
			log.error(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return null;
	}

	@Transactional
	public UpdateDTO toggle(Long id){
		Optional<ToDo> td = this.getById(id);
		if(td.isPresent()) {
			Boolean comp = !td.get().getFinished();
			Transaction transaction = null;
			try (Session session = this.getSessionFactory().openSession()) {
				session.setHibernateFlushMode(FlushMode.COMMIT);
				transaction = session.beginTransaction();
				MutationQuery uq = session.createNativeMutationQuery("UPDATE to_do SET finished=? WHERE id=?")
										  .setParameter(1, comp)
										  .setParameter(2, id);
				int rows = uq.executeUpdate();
				transaction.commit();
				return UpdateDTO.builder()
						.success(true)
						.message(rows + " records was/were updated")
						.todos(Arrays.asList(this.getById(id).get()))
						.build();
			} catch (Exception e) {
				log.error(e.getMessage());
				if (transaction != null) {
					transaction.rollback();
				}
				return UpdateDTO.builder().success(false).message("Could not perform the update requested").build();
			}
		} else {
			return UpdateDTO.builder().success(false).message("Could not find a record with such id").build();
		}	
	}

	public String deleteById(Long id) {	
		Optional<ToDo> todo = this.getById(id);
		if(todo.isPresent()) {
			CriteriaDelete<ToDo> cd = em.getCriteriaBuilder().createCriteriaDelete(ToDo.class);
			Root<ToDo> root = cd.from(ToDo.class);
			cd.where(em.getCriteriaBuilder().equal(root.get(ToDo_.ID),id));
			Transaction transaction = null;
			try (Session session = this.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				session.createMutationQuery(cd).executeUpdate();
				transaction.commit();
				return "The todo with id = " + id + " was deleted";
			} catch (Exception e) {
				log.error(e.getMessage());
				if (transaction != null) {
					transaction.rollback();
				}
			}
		} else {
			return "There is no todo with id = " + id;
		}	
		return "";
	}
	
	public List<ToDo> getByTitleLike(String term) {
		List<ToDo> todos = em.createNativeQuery("SELECT * FROM to_do WHERE title ILIKE :term", ToDo.class)
							 .setParameter("term", "%"+term+"%")
							 .getResultList();
		return todos;
	}

	public List<ToDo> getByCompleted(Boolean isCompleted) { 
		List<ToDo> todos = em.createNativeQuery("SELECT * FROM to_do WHERE finished = :completed", ToDo.class)
				 .setParameter("completed", isCompleted)
				 .getResultList();
		return todos;
	}

}






