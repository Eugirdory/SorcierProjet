package test;

import dao.*;

import metier.*;

public class Test {

	public static void main(String[] args) {
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
