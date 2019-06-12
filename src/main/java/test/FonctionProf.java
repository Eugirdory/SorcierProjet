package test;

import java.util.Scanner;

import dao.*;
import metier.*;

public class FonctionProf 
{
	public static String ajoutProf(String nom, String prenom)
	{
		DaoSorcier daoS = new DaoSorcier();
		Professeur prof = new Professeur();
		
		prof.setNom(nom);
		
		prof.setPrenom(prenom);
		
		daoS.insert(prof);
		
		return "Ajout du professeur: "+nom+" "+prenom;
	}
	
	//professeur
	public void modifProf()
	{
		DaoSorcier daoS = new DaoSorcier();
		Professeur prof = new Professeur();
		Maison maison = new Maison();
		Matiere matiere = new Matiere();
		//Lister les sorts à faire
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("Saisissez l'ID de votre élève: ");
		int id = sc2.nextInt();
		daoS.selectById(id);
		
		/*
		System.out.println("Quelle est votre maison?");
		String nomMaison = sc1.nextLine();
		maison.setNom(nomMaison);
		maison.setProfesseur(prof);
		
		System.out.println("Voulez-vous suivre une matiere: oui/non?");
		String rep = sc1.nextLine().toLowerCase();
		while(rep == "oui")
		{*/
			System.out.println("Quelle matière enseignez-vous?");
			String nomMatiere = sc1.nextLine();
			matiere.setNom(nomMatiere);
			prof.setMatiere(matiere);
		//}
				
		daoS.update(prof);
		
	}


}

