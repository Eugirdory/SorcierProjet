package dao;

import java.util.*;

import javax.persistence.*;

import application.Context;
import metier.*;

public class DaoMaison implements DAO<Maison, String> {

	public void insert(Maison object) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		// déclarer une transaction
		em.getTransaction().begin();

		em.persist(object);// ajoute l'objet en base

		em.getTransaction().commit();// fin de la transaction

		em.close();
		Context.destroy();

	}

	public Maison selectById(String id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Maison m = em.find(Maison.class, id);
		em.close();
		Context.destroy();
		return m;
	}

	@Override
	public void update(Maison object) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		// déclarer une transaction
		em.getTransaction().begin();

		em.merge(object);// ajoute l'objet en base

		em.getTransaction().commit();// fin de la transaction

		em.close();
		Context.destroy();

	}

	@Override
	public void delete(Maison object) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		// déclarer une transaction
		em.getTransaction().begin();

		em.remove(object);// ajoute l'objet en base

		em.getTransaction().commit();// fin de la transaction

		em.close();
		Context.destroy();

	}


	public List<Maison> selectAll() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("from Maison");

		List<Maison> list = query.getResultList();
		em.close();
		Context.destroy();
		return list;
	}
	public List<Maison> selectAllWithEleves() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
	
		Query query=em.createNamedQuery("Maison.findWithEleves",Maison.class);
		List<Maison> list = query.getResultList();
		em.close();
		Context.destroy();
		return list;
	}
}
