package test;

import java.util.*;

import dao.*;

import metier.*;

public class Test {

	public static void main(String[] args) {

		// Initialisation de la base
		InitMaison();
		InitMatieres();
		testSorciers();
		testProfPrincipal();
		testSort();

		menuPrincipal();

	}

	public static void menuPrincipal() {
		Scanner clavier = new Scanner(System.in);
		System.out.println("Bienvenue à Poudlard !");
		System.out.println(
				"Que souhaitez-vous faire?\n1 : Gestion des Maisons\n2 : Gestion des Eleves\n3 : Gestion des Professeurs\n4 : Gestion des Matières");
		int choix1 = clavier.nextInt();
		switch (choix1) {
		case 1:
			menuMaison();
			break;
		case 2:
			menuEleves();
			break;
		case 3:
			menuProfesseurs();
			break;
		case 4:
			// menuMatieres();
			break;
		}

	}

	public static void menuProfesseurs() {
		Scanner clavier = new Scanner(System.in);
		Scanner clavier2 = new Scanner(System.in);
		System.out.println("Vous êtes dans le menu de gestion des Professeurs");
		System.out.println("Que souhaitez-vous faire?\n1 : Ajouter un professeur\n2 : Modifier un professeur");
		int choix1 = clavier.nextInt();
		switch (choix1) {
		case 1:
			DaoSorcier daoS = new DaoSorcier();
			Professeur prof = new Professeur();
			System.out.println("Nom du professeur ?");
			String nom = clavier2.nextLine();
			prof.setNom(nom);
			System.out.println("Prenom du professeur ?");
			String prenom = clavier2.nextLine();
			prof.setPrenom(prenom);
			System.out.println("Age du professeur ?");

			System.out.println(FonctionProf.ajoutProf(nom, prenom));
			break;
		case 2:
			DaoSorcier daoS2 = new DaoSorcier();
			for (Sorcier s : daoS2.selectAllWithProfesseur()) {
				System.out.println(s);
			}
			System.out.println("Choisir le professeur que vous souhaitez modifier : quel est son 'Id'? ");
			int id = clavier.nextInt();
			Professeur prof1 = (Professeur) daoS2.selectById(id);
			menuProf2(prof1);

			break;
		}
	}
	public static void menuProf2(Professeur prof) {
		Scanner clavier = new Scanner(System.in);
		Scanner clavier2 = new Scanner(System.in);
		System.out
				.println("Que voulez vous modifier?\1 : Ajouter une matière");
		int choix1 = clavier.nextInt();
		switch (choix1) {
		case 1:
			DAOMatiere daoM = new DAOMatiere();
			DaoSorcier daoS = new DaoSorcier();
			for (Matiere m : daoM.selectAllWithSort()) {
				System.out.println(m);
			}
			System.out.println("Choisir la matière que vous souhaitez ajouter : quel est son 'Id'? ");
			int id = clavier.nextInt();
			Matiere mat = daoM.selectById(id);
			prof.setMatiere(mat);
			daoS.update(prof);
			System.out.println(prof.getNom() + " enseigne maintenant la matière : " + mat.getNom());
			break;
		}
	}

	public static void menuEleves() {
		Scanner clavier = new Scanner(System.in);
		Scanner clavier2 = new Scanner(System.in);
		System.out.println("Vous êtes dans le menu de gestion des Eleves");
		System.out.println("Que souhaitez-vous faire?\n1 : Ajouter un élève\n2 : Modifier un élève");
		int choix1 = clavier.nextInt();
		switch (choix1) {
		case 1:
			DaoSorcier daoS = new DaoSorcier();
			Eleve eleve = new Eleve();
			System.out.println("Nom de l'élève ?");
			String nom = clavier2.nextLine();
			eleve.setNom(nom);
			System.out.println("Prenom de l'élève ?");
			String prenom = clavier2.nextLine();
			eleve.setPrenom(prenom);
			System.out.println("Age de l'élève ?");
			Integer age = clavier2.nextInt();
			eleve.setAge(age);

			System.out.println(FonctionEleve.ajoutEleve2(nom, prenom, age));
			break;
		case 2:
			DaoSorcier daoS2 = new DaoSorcier();
			for (Sorcier s : daoS2.selectAllWithEleve()) {
				System.out.println(s);
			}
			System.out.println("Choisir l'élève que vous souhaitez modifier : quel est son 'Id'? ");
			int id = clavier.nextInt();
			Eleve eleve1 = (Eleve) daoS2.selectById(id);
			menuEleves2(eleve1);

			break;
		}
	}

	public static void menuEleves2(Eleve eleve) {
		Scanner clavier = new Scanner(System.in);
		Scanner clavier2 = new Scanner(System.in);
		System.out
				.println("Que voulez vous modifier?\1 : Changer la maison\n2: Suivre une matière\3 :Lister les sorts");
		int choix1 = clavier.nextInt();
		switch (choix1) {
		case 1:
			System.out.println("Choix de la maison :\n1 : Griffondor\n2 : Serdaigle\n3 : Poufsoufle\n4 : Serpentard");
			int choix2 = clavier.nextInt();
			switch (choix2) {
			case 1:
				System.out.println(ajoutEleveMaison(eleve, "Griffondor"));
				break;
			case 2:
				System.out.println(ajoutEleveMaison(eleve, "Serdaigle"));
				break;
			case 3:
				System.out.println(ajoutEleveMaison(eleve, "Poufsoufle"));
				break;
			case 4:
				System.out.println(ajoutEleveMaison(eleve, "Serpentard"));
				break;
			}
			break;
		case 2:
			DAOMatiere daoM = new DAOMatiere();
			DaoSorcier daoS = new DaoSorcier();
			for (Matiere m : daoM.selectAllWithSort()) {
				System.out.println(m);
			}
			System.out.println("Choisir la matière que vous souhaitez ajouter : quel est son 'Id'? ");
			int id = clavier.nextInt();
			Matiere mat = daoM.selectById(id);
			eleve.setMatieres(mat);
			daoS.update(eleve);
			System.out.println(eleve.getPrenom() + " étudie maintenant la matière : " + mat.getNom());
			break;
		case 3:
			break;
		}
	}

	public static void menuMaison() {
		Scanner clavier = new Scanner(System.in);
		Scanner clavier2 = new Scanner(System.in);
		System.out.println("Vous êtes dans le menu de gestion des Maisons");
		System.out.println("Que souhaitez-vous faire?\n1 : Ajouter une maison\n2 : Consulter une maison");
		int choix1 = clavier.nextInt();
		switch (choix1) {
		case 1:
			System.out.println("Nom de la maison à ajouter ?");
			String nom = clavier2.nextLine();
			System.out.println(ajoutMaison(nom));
			break;
		case 2:
			System.out.println("Choix de la maison :\n1 : Griffondor\n2 : Serdaigle\n3 : Poufsoufle\n4 : Serpentard");
			int choix2 = clavier.nextInt();
			switch (choix2) {
			case 1:
				menuMaison2("Griffondor");
				break;
			case 2:
				menuMaison2("Serdaigle");
				break;
			case 3:
				menuMaison2("Poufsoufle");
				break;
			case 4:
				menuMaison2("Serpentard");
				break;
			}
			break;
		}
	}

	public static void menuMaison2(String nom) {
		Scanner clavier = new Scanner(System.in);
		Scanner clavier2 = new Scanner(System.in);
		System.out.println("Vous êtes dans le menu de gestion de la maison " + nom);
		System.out.println(
				"Que souhaitez-vous faire?\n1 : Ajouter des points\n2 : Ajouter un élève\n3 : Modifier le professeur principal");
		int choix1 = clavier.nextInt();
		switch (choix1) {
		case 1:
			System.out.println("Nombre de points à ajouter à " + nom + " ?");
			int points = clavier2.nextInt();
			System.out.println(ajoutPoints(nom, points));
			break;
		case 2:
			DaoSorcier daoS = new DaoSorcier();

			for (Sorcier s : daoS.selectAllWithEleve()) {
				System.out.println(s);
			}
			System.out.println("Choisir l'élève que vous souhaitez ajouter : quel est son 'Id'? ");
			int id = clavier.nextInt();
			Eleve eleve = (Eleve) daoS.selectById(id);
			System.out.println(ajoutEleveMaison(eleve, nom));
			break;
		case 3:
			DaoSorcier daoS2 = new DaoSorcier();

			for (Sorcier s : daoS2.selectAllWithPatronus()) {
				System.out.println(s);
			}
			System.out.println("Choisir le professeur principal de " + nom + " : quel est son 'Id'?");
			int id2 = clavier.nextInt();
			Professeur prof = (Professeur) daoS2.selectById(id2);
			System.out.println(modifProfPrincipal(prof, nom));
			break;
		}
	}

	public static void testModifProfPrincipal() {
		DaoSorcier daoS = new DaoSorcier();
		Sorcier sorc = daoS.selectById(5);
		Professeur prof = (Professeur) sorc;

		System.out.println(modifProfPrincipal(prof, "Gryffondor"));
	}

	public static String modifProfPrincipal(Professeur prof, String nom) {
		DaoSorcier daoS = new DaoSorcier();
		DaoMaison daoM = new DaoMaison();
		Maison maison = daoM.selectById(nom);
		String nomProfesseur = prof.getNom();

		maison.setNomProfesseur(nomProfesseur);
		;
		daoM.update(maison);

		return "Le Professeur " + nomProfesseur + " est maintenant responsable de la maison " + maison.getNom();
	}

	public static void testajoutEleveMaison() {
		Eleve eleve = new Eleve();
		eleve.setNom("Weasley");
		eleve.setPrenom("Ron");
		eleve.setCivilite(Civilite.Monsieur);
		eleve.setPatronus(Patronus.poisson);

		System.out.println(ajoutEleveMaison(eleve, "Gryffondor"));
	}

	public static String ajoutEleveMaison(Eleve eleve, String nom) {
		DaoSorcier daoS = new DaoSorcier();
		DaoMaison daoM = new DaoMaison();
		Maison maison = daoM.selectById(nom);

		eleve.setMaison(maison);
		daoS.update(eleve);

		return "Le Choixpeau Magique à placé " + eleve.getPrenom() + " à " + maison.getNom();
	}

	public static String ajoutPoints(String nom, int points) {
		DaoMaison daoM = new DaoMaison();
		Maison maison = daoM.selectById(nom);
		int score = maison.getScore();
		score += points;
		maison.setScore(score);
		daoM.update(maison);

		return points + " points pour " + nom + " !";
	}

	public static String consultMaison(String nom) {
		DaoMaison daoM = new DaoMaison();
		Maison maison = daoM.selectById(nom);
		String reponse = maison.toString();

		return reponse;
	}

	public static String ajoutMaison(String nom) {
		DaoMaison daoM = new DaoMaison();

		int count = 0;
		String reponse = " ";
		for (Maison s : daoM.selectAll()) {
			count++;
		}
		if (count == 4)
			reponse = "Il y a déjà quatre maisons à Poudlard !";
		else {
			Maison maison = new Maison();
			maison.setNom(nom);
			daoM.insert(maison);
			reponse = "La maison " + nom + " a été ajoutée à Poudlard";
		}
		return reponse;
	}

	public static void testSort() {
		DAOSort daoS = new DAOSort();
		DAOMatiere daoMat = new DAOMatiere();

		Sort s1 = new Sort();
		s1.setLibelle("Expillarmus");
		s1.setMatiere(daoMat.selectById(5));
		s1.setTypesort(TypeSort.defense);

		Sort s2 = new Sort("Accio", daoMat.selectById(2), TypeSort.enchantement);

		Sort s3 = new Sort("VeraVerto", daoMat.selectById(1), TypeSort.metamorphose);

		Sort s4 = new Sort("Wingardium Leviosa", daoMat.selectById(2), TypeSort.deplacement);

		daoS.insert(s1);
		daoS.insert(s2);
		daoS.insert(s3);
		daoS.insert(s4);

	}

	public static void testProfPrincipal() {
		DaoSorcier daoS = new DaoSorcier();
		DaoMaison daoM = new DaoMaison();

		Maison griff = daoM.selectById("Gryffondor");
		Sorcier prof1 = daoS.selectById(5);
		griff.setNomProfesseur(prof1.getNom());

		Maison serd = daoM.selectById("Serdaigle");
		Sorcier prof2 = daoS.selectById(6);
		serd.setNomProfesseur(prof2.getNom());

		Maison serp = daoM.selectById("Serpentard");
		Sorcier prof3 = daoS.selectById(7);
		serp.setNomProfesseur(prof3.getNom());

		Maison pouf = daoM.selectById("Pouffsoufle");
		Sorcier prof4 = daoS.selectById(8);
		pouf.setNomProfesseur(prof4.getNom());

		System.out.println(griff.getNomProfesseur());

		daoM.update(griff);
		daoM.update(serd);
		daoM.update(pouf);
		daoM.update(serp);

	}

	public static void testSorciers() {
		DaoSorcier daoS = new DaoSorcier();
		DaoMaison daoM = new DaoMaison();
		DAOMatiere daoMat = new DAOMatiere();

		Eleve eleve1 = new Eleve();
		eleve1.setNom("Potter");
		eleve1.setPrenom("Harry");
		eleve1.setCivilite(Civilite.Monsieur);
		eleve1.setMaison(daoM.selectById("Gryffondor"));
		eleve1.setPatronus(Patronus.cerf);
		eleve1.setMatieres(daoMat.selectById(1));
		eleve1.setMatieres(daoMat.selectById(2));

		Eleve eleve2 = new Eleve();
		eleve2.setNom("Lovegood");
		eleve2.setPrenom("Luna");
		eleve2.setCivilite(Civilite.Madame);
		eleve2.setMaison(daoM.selectById("Serdaigle"));
		eleve2.setPatronus(Patronus.lapin);
		eleve2.setMatieres(daoMat.selectById(2));
		eleve2.setMatieres(daoMat.selectById(3));

		Eleve eleve3 = new Eleve();
		eleve3.setNom("Bones");
		eleve3.setPrenom("Susan");
		eleve3.setCivilite(Civilite.Madame);
		eleve3.setMaison(daoM.selectById("Pouffsoufle"));
		eleve3.setPatronus(Patronus.tortue);
		eleve3.setMatieres(daoMat.selectById(3));
		eleve3.setMatieres(daoMat.selectById(4));

		Eleve eleve4 = new Eleve();
		eleve4.setNom("Malfoy");
		eleve4.setPrenom("Draco");
		eleve4.setCivilite(Civilite.Monsieur);
		eleve4.setMaison(daoM.selectById("Serpentard"));
		eleve4.setPatronus(Patronus.serpent);
		eleve4.setMatieres(daoMat.selectById(4));
		eleve4.setMatieres(daoMat.selectById(5));

		daoS.insert(eleve1);
		daoS.insert(eleve2);
		daoS.insert(eleve3);
		daoS.insert(eleve4);

		Professeur p1 = new Professeur();
		p1.setNom("McGonagall");
		p1.setPrenom("Minerva");
		p1.setCivilite(Civilite.Madame);
		p1.setMatiere(daoMat.selectById(1));

		Professeur p2 = new Professeur();
		p2.setNom("Flitwick");
		p2.setPrenom("Filius");
		p2.setCivilite(Civilite.Monsieur);
		p2.setMatiere(daoMat.selectById(2));

		Professeur p3 = new Professeur();
		p3.setNom("Rogue");
		p3.setPrenom("Severus");
		p3.setCivilite(Civilite.Monsieur);
		p3.setMatiere(daoMat.selectById(3));

		Professeur p4 = new Professeur();
		p4.setNom("Chourave");
		p4.setPrenom("Pomona");
		p4.setCivilite(Civilite.Madame);
		p4.setMatiere(daoMat.selectById(4));

		daoS.insert(p1);
		daoS.insert(p2);
		daoS.insert(p3);
		daoS.insert(p4);

	}

	public static void InitMatieres() {
		DAOMatiere daoM = new DAOMatiere();

		// Initialisation des matières
		Matiere m1 = new Matiere();
		m1.setNom("Transfiguration");

		Matiere m2 = new Matiere();
		m2.setNom("Enchantements");

		Matiere m3 = new Matiere();
		m3.setNom("Potions");

		Matiere m4 = new Matiere();
		m4.setNom("Botanique");

		Matiere m5 = new Matiere();
		m5.setNom("DCFM");

		daoM.insert(m1);
		daoM.insert(m2);
		daoM.insert(m3);
		daoM.insert(m4);
		daoM.insert(m5);
	}

	public static void InitMaison() {
		DaoMaison daoM = new DaoMaison();

		// Initialisation des maisons
		Maison griff = new Maison();
		Maison serd = new Maison();
		Maison pouf = new Maison();
		Maison serp = new Maison();
		griff.setNom("Gryffondor");
		serd.setNom("Serdaigle");
		pouf.setNom("Pouffsoufle");
		serp.setNom("Serpentard");

		griff.setScore(0);
		serd.setScore(0);
		pouf.setScore(0);
		serp.setScore(0);

		daoM.insert(griff);
		daoM.insert(serd);
		daoM.insert(pouf);
		daoM.insert(serp);
	}

		testProf();
		
		}
		public static void testEleve(){
			DaoSorcier daoS = new DaoSorcier();
			Sorcier s = new Eleve();
			s.setCivilite(Civilite.Monsieur);
			s.setNom("Merdeux");
			
			daoS.insert(s);
			
			System.out.println(s);
			
		}
		public static void testProf(){
			DaoSorcier daoS = new DaoSorcier();
			Sorcier s = new Professeur();
			s.setCivilite(Civilite.Monsieur);
			s.setNom("Cassekouille");
			
			daoS.insert(s);
			
			System.out.println(s);
			
		}


}
