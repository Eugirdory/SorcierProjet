package metier;

public enum Civilite {
Monsieur("M. "), Madame("Mme "), NC ("NC ");
	private String libelle;
	private Civilite(String libelle){
		this.libelle=libelle;
	}
	public String getLibelle() {
		return libelle;
	}
	
	
}
