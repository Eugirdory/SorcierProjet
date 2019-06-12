package test;
import metier.*;
import java.util.*;
import dao.*;

public class FonctionEleve 
{
	public static void ajoutEleve()
	{
		DaoSorcier daoS = new DaoSorcier();
		Eleve eleve = new Eleve();
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("Quel est le nom de votre élève?");
		String nom = sc1.nextLine();
		eleve.setNom(nom);
		
		System.out.println("Quel est le prenom de votre élève?");
		String prenom = sc1.nextLine();
		eleve.setPrenom(prenom);
		
		System.out.println("Quel est son age?");
		int age = sc2.nextInt();
		eleve.setAge(age);
		
		daoS.insert(eleve);
	}
	
	public static String ajoutEleve2(String nom, String prenom, int age)
	{
		DaoSorcier daoS = new DaoSorcier();
		Eleve eleve = new Eleve();
		
		eleve.setNom(nom);
		
		eleve.setPrenom(prenom);
	
		eleve.setAge(age);
		
		daoS.insert(eleve);
		
		return "Ajout de l'élève: "+nom+" "+prenom+", "+age+" ans.";
	}
	
	
	public void modifEleve()
	{
		DaoSorcier daoS = new DaoSorcier();
		Eleve eleve = new Eleve();
		Maison maison = new Maison();
		Matiere matiere = new Matiere();
		//Lister les sorts à faire
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("Saisissez l'ID de votre élève: ");
		int id = sc2.nextInt();
		daoS.selectById(id);
		
		System.out.println("Quelle est votre nouvelle maison?");
		String nomMaison = sc1.nextLine();
		maison.setNom(nomMaison);
		eleve.setMaison(maison);
		
		/*System.out.println("Voulez-vous suivre une matiere: oui/non?");
		String rep = sc1.nextLine().toLowerCase();
		while(rep == "oui")
		{*/
			System.out.println("Quelle matière voulez-vous suivre?");
			String nomMatiere = sc1.nextLine();
			matiere.setNom(nomMatiere);
			eleve.setMatieres(matiere);
			System.out.println("Voulez-vous suivre une autre matiere: oui/non?");
		//}
			
		daoS.update(eleve);
		
	}

}
