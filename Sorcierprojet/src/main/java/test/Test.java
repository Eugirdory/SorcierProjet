package test;

import dao.*;

import metier.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoMaison daoM=new DaoMaison();
		DaoSorcier daoS=new DaoSorcier();
		Maison griff =new Maison();
		Maison serd =new Maison();
		Maison pouf =new Maison();
		Maison serp =new Maison();
		griff.setNom("Gryffondor");
//		serd.setNom("Serdaigle");
//		pouf.setNom("Pouffsoufle");
//		serp.setNom("Serpentard");
		Professeur prof = new Professeur();
		prof.setNom("zertuio");
		griff.setProfesseur(prof);
		daoS.insert(prof);
		daoM.insert(griff);
//		daoM.insert(serd);
//		daoM.insert(pouf);
//		daoM.insert(serp);
//		
		
		for (Maison m: daoM.selectAll()){
			System.out.println(m);
		}
	}

}
