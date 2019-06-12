package test;

import dao.*;

import metier.*;

public class Test {

	public static void main(String[] args) {

		//InitMaison();
		//InitMatieres();
		//testSorciers();
		//testProfPrincipal();
		testSort();

	}
	
	public static void testSort() {
		DAOSort daoS = new DAOSort();
		DAOMatiere daoMat = new DAOMatiere();
		
		Sort s1=new Sort();
		s1.setLibelle("Expillarmus");
		s1.setMatiere(daoMat.selectById(5));
		s1.setTypesort(TypeSort.defense);
		
		Matiere dcfm=daoMat.selectById(5);
		dcfm.setSortileges(s1);
		
		/*Sort s2=new Sort("Accio", daoMat.selectById(2),TypeSort.enchantement);
		
		Matiere ench=daoMat.selectById(2);
		ench.setSortileges(s2);
		
		Sort s3=new Sort("VeraVerto", daoMat.selectById(1),TypeSort.metamorphose);
		
		Matiere transf=daoMat.selectById(1);
		transf.setSortileges(s3);
		
		Sort s4=new Sort("Wingardium Leviosa", daoMat.selectById(2),TypeSort.deplacement);
		ench.setSortileges(s4);*/
		
		System.out.println(s1);
		
		daoS.insert(s1);
//		daoS.insert(s2);
//		daoS.insert(s3);
//		daoS.insert(s4);
		
		/*daoMat.update(transf);
		daoMat.update(ench);
		daoMat.update(dcfm);*/


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
}
