package dao;

import java.util.List;

import javax.persistence.*;

import application.Context;
import metier.*;

public class DAOSort implements DAO<Sort, Integer>
{

	@Override
	public void insert(Sort object) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(object);
		em.getTransaction().commit();
		em.close();



		

	}

	@Override
	public Sort selectById(Integer id) {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		Sort s = em.find(Sort.class, id);
		
		em.close();

		return s;
	}

	@Override
	public void update(Sort object) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(object);
		
		em.getTransaction().commit();
		
		em.close();



	

	}

	@Override
	public void delete(Sort object) 
	{
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
		
		em.close();



	

	}

	@Override
	public List<Sort> selectAll() 
	{
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("from Sort");
		List<Sort> liste = query.getResultList();
		
		em.close();



	

		return liste;
	}

}
