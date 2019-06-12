package dao;

import java.util.*;

import javax.persistence.*;

import application.Context;
import metier.*;

public class DAOMatiere implements DAO<Matiere,Integer>
{

	public void insert(Matiere object) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(object);
		em.getTransaction().commit();
		em.close();
		Context.destroy();
	}

	public Matiere selectById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		Matiere m = em.find(Matiere.class, id);
		
		em.close();
		Context.destroy();
		return m;
	}


	public void update(Matiere object) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(object);
		
		em.getTransaction().commit();
		
		em.close();
		Context.destroy();
	}


	public void delete(Matiere object) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
		
		em.close();
		Context.destroy();
	}


	public List<Matiere> selectAll() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("from Matiere");
		List<Matiere> liste = query.getResultList();
		
		em.close();
		Context.destroy();
		return liste;
	}
	
	public List<Matiere> selectAllWithSort() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		Query query=em.createNamedQuery("Matiere.findWithSort",Matiere.class);
		List<Matiere> list = query.getResultList();
		
		em.close();
		Context.destroy();
		return list;
	}

}
