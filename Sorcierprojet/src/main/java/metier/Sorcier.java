package metier;

import javax.persistence.*;

@Entity
// @NamedQueries({
//
// @NamedQuery(name = "Sorcier.findWithMatiere", query = "select s from Sorcier
// s left join fetch s.matiere"),
// @NamedQuery(name = "Sorcier.findWithSort", query = "select s from Sorcier s
// left join fetch s.sort")
// })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SORCIER_TYPE")
@Table(name = "Sorciers")
public  class Sorcier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Version
	private Integer version;

	private String nom;
	private String prenom;
	private Integer age;
	private Civilite civilite;
	private Patronus patronus;

	public Sorcier() {
	}

	public Sorcier(String nom, String prenom, Integer age, Civilite civilite, Patronus patronus) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.civilite = civilite;
		this.patronus = patronus;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Patronus getPatronus() {
		return patronus;
	}

	public void setPatronus(Patronus patronus) {
		this.patronus = patronus;
	}

	@Override
	public String toString() {
		return super.getClass().getSimpleName() + " [id=" + id + ", version=" + version + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
				+ ", civilite=" + civilite + ", patronus=" + patronus + "]";
	}

}
