package metier;

import java.util.*;

import javax.persistence.*;
@Entity
@NamedQueries({
	//@NamedQuery(name = "Maison.findWithEleves", query = "select m from Maison m left join fetch m.sorcier")
	})
public class Maison {
	// attributs
	@Id
	@Column(unique = true)
	private String nom;
	private Integer score;
	@Column(name="prof_principal")
	private String nomProfesseur;
	@OneToMany(mappedBy="maison")
	private List<Eleve> eleves = new ArrayList<Eleve>();
	@Version
	private Integer version;

	//getters et setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getNomProfesseur() {
		return nomProfesseur;
	}

	public void setNomProfesseur(String nomProfesseur) {
		this.nomProfesseur = nomProfesseur;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}
	public void setEleves(Eleve eleve) {
		this.eleves.add(eleve);
	}

	//constructeurs
	public Maison(String nom, Integer score) {
		super();
		this.nom = nom;
		this.score = score;
	}

	public Maison() {

	}

	//to String
	public String toString() {
		return "nom=" + nom + ", score=" + score ;
	}

}
