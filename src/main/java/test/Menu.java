package test;

public class Menu {

	public String menu(Integer choix) {
		switch (choix) {
		case 1:
			// Maison
			return fonctionMaison();

			break;
		case 2:
			// Eleve
			return fonctionEleve();
			break;
		case 3:
			// Professeur
			return fonctionProfesseur();
			break;
		case 4:
			// Matiere
			return focntionMatiere();
			break;
		default:
			// code block
		}
	}

}
