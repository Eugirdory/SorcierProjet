package test;

import java.util.*;

import dao.*;
import metier.*;

public class fonctionMatiere {

	public String fonctionMatiere() {
		String rep = "";

		return rep;
	}

	public Matiere creerMatiere(String nom, Professeur professeur) {

		Matiere matiere = new Matiere(nom,  professeur);

		return matiere;
	}

	public String ajoutMatiere(Matiere matiere) {
		String rep = "";
		DAOMatiere daoMatiere = new DAOMatiere();
		daoMatiere.insert(matiere);
		rep += "Vous avez ajouté " + matiere;
		return rep;
	}

	public Sort creerSort(String nom, Matiere matiere, TypeSort typesort) {

		Sort sort = new Sort(nom, matiere, typesort);

		return sort;
	}

	public String ajoutSort(Sort sort) {
		String rep = "";
		DAOSort daoSort = new DAOSort();
		daoSort.insert(sort);
		rep += "Vous avez ajouté " + sort;

		return rep;
	}

}
