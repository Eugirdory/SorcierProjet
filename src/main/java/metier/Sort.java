package metier;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name = "Sort.findWithMatiere", query = "select s from Sort s left join fetch s.matiere")
	})
public class Sort 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortId;
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="matiere")
	private Matiere matiere;
	@Enumerated(EnumType.STRING)
	private TypeSort typesort;
	
	public Sort(){}
	
	public Sort(String libelle, Matiere matiere, TypeSort typesort) 
	{
		this.libelle = libelle;
		this.matiere = matiere;
		this.typesort = typesort;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public TypeSort getTypesort() {
		return typesort;
	}

	public void setTypesort(TypeSort typesort) {
		this.typesort = typesort;
	}

	@Override
	public String toString() {
		return "Sort [sortId=" + sortId + ", libelle=" + libelle + ", matiere=" + matiere + ", typesort=" + typesort
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sortId == null) ? 0 : sortId.hashCode());
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
		Sort other = (Sort) obj;
		if (sortId == null) {
			if (other.sortId != null)
				return false;
		} else if (!sortId.equals(other.sortId))
			return false;
		return true;
	}

		
}
