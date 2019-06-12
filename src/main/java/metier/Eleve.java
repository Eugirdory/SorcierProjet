package metier;

import java.util.*;

import javax.persistence.*;


@Entity
@DiscriminatorValue("eleve")
public class Eleve extends Sorcier {
	//attributs
	@Id
	private Integer id;
	@ManyToMany
	@JoinTable(name="etudes")
	private List<Matiere> matieres = new ArrayList<Matiere>();
	@ManyToOne
	@JoinColumn(name = "maison")
	private Maison maison;
	@Version
	private Integer version;

	
	//getters et setters
	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Matiere matiere) {
		this.matieres.add(matiere);
	}

	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}

	//constructeurs
	public Eleve(Maison maison) {
		super();
		this.maison = maison;
	}

	public Eleve() {
	}
//to String
	public String toString() {
		return super.toString()+" [matieres=" + matieres + ", maison=" + maison + "]";
	}
	
}
