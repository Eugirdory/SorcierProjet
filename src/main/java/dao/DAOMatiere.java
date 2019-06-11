package dao;

import java.util.*;

import javax.persistence.*;

import application.Context;
import metier.*;

public class DAOMatiere implements DAO<Matiere,Integer>
{

	@Override
	public void insert(Matiere object) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(object);
		em.getTransaction().commit();
		em.close();
		Context.destroy();
	}

	@Override
	public Matiere selectById(Integer id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		Matiere m = em.find(Matiere.class, id);
		
		em.close();
		Context.destroy();
		return m;
	}

	@Override
	public void update(Matiere object) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(object);
		
		em.getTransaction().commit();
		
		em.close();
		Context.destroy();
	}

	@Override
	public void delete(Matiere object) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
		
		em.close();
		Context.destroy();
	}

	@Override
	public List<Matiere> selectAll() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("from Matiere");
		List<Matiere> liste = query.getResultList();
		
		em.close();
		Context.destroy();
		return liste;
	}

}
