package metier;

import java.util.*;
import javax.persistence.*;

@Entity
public class Matiere 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matiereId;
	
	private String nom;
	
	@OneToOne(mappedBy = "matiere")
	private Professeur professeur;
	
	
	@OneToMany(mappedBy = "matiere")
	private List<Sort> sortileges = new ArrayList();
	
	public Matiere(){}
	
	public Matiere(String nom, Professeur professeur, List<Sort> sortileges) {
		this.nom = nom;
		//this.professeur = professeur;
		this.sortileges = sortileges;
	}
	
	public Integer getMatiereId() {
		return matiereId;
	}
	public void setMatiereId(Integer matiereId) {
		this.matiereId = matiereId;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	
	public List<Sort> getSortileges() {
		return sortileges;
	}
	public void setSortileges(List<Sort> sortileges) {
		this.sortileges = sortileges;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matiereId == null) ? 0 : matiereId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matiere other = (Matiere) obj;
		if (matiereId == null) {
			if (other.matiereId != null)
				return false;
		} else if (!matiereId.equals(other.matiereId))
			return false;
		return true;
	}
	
}
