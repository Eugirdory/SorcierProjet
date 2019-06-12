package dao;

import java.util.*;

import javax.persistence.*;

import application.*;

import metier.*;

public class DaoSorcier implements DAO<Sorcier, Integer> {

	@Override
	public void insert(Sorcier object) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(object);

		em.getTransaction().commit();

		em.close();


	}

	@Override
	public Sorcier selectById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		Sorcier s = em.find(Sorcier.class, id);

		em.close();



		return s;
	}

	@Override
	public void update(Sorcier object) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.merge(object);

		em.getTransaction().commit();

		em.close();


	}

	@Override
	public void delete(Sorcier object) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.remove(object);

		em.getTransaction().commit();

		em.close();


	}

	@Override
	public List<Sorcier> selectAll() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("from Soldat");
		List<Sorcier> liste = query.getResultList();

		em.close();

		return liste;
	}

	public List<Sorcier> selectAllWithMaison() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("Sorcier.findWithMaison", Sorcier.class);
		List<Sorcier> liste = query.getResultList();

		em.close();

		return liste;
	}

	public List<Sorcier> selectAllWithEleve() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		Query query = em.createNativeQuery("SELECT * FROM sorciers where  SORCIER_TYPE='eleve'", Sorcier.class);
		List<Sorcier> liste = query.getResultList();

		em.close();

		return liste;
	}

	public List<Sorcier> selectAllWithProfesseur() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		Query query = em.createNativeQuery("SELECT * FROM Sorciers where  SORCIER_TYPE='professeur'", Sorcier.class);
		List<Sorcier> liste = query.getResultList();

		em.close();

		return liste;
	}

	public List<Sorcier> selectAllWithMatiere() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("Sorcier.findWithMatiere", Sorcier.class);
		List<Sorcier> liste = query.getResultList();

		em.close();

		return liste;
	}

	public List<Sorcier> selectAllWithSort() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("Sorcier.findWithSort", Sorcier.class);
		List<Sorcier> liste = query.getResultList();

		em.close();

		return liste;
	}

	public List<Sorcier> selectAllWithPatronus() {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("Sorcier.findWithPatronus", Sorcier.class);
		List<Sorcier> liste = query.getResultList();

		em.close();

		return liste;
	}

}
