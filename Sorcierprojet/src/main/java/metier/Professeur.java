package metier;

import javax.persistence.*;

@Entity
@DiscriminatorValue("professeur")
public class Professeur extends Sorcier {
	@OneToOne
	private Matiere matiere;

	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return super.toString() + " [matiere=" + matiere + "]";
	}

}
