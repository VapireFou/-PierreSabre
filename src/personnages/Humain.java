package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;

	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}
	
	public String getBoisson() {
		return boisson;
	}
	
	public int getArgent() {
		return argent;
	}
	
	public void setArgent(int argent) {
		this.argent = argent;
	}

	protected void parler(String texte) {
		System.out.println(texte);
		
	}

	public void direBonjour() {
		this.parler("Bonjour ! Je m'appelle " + this.getNom() + " et j'aime boire du " + this.getBoisson());
		
	}
	
	public void boire() {
		this.parler("Mmmm, un bon verre de " + this.getBoisson() + "! GLOUPS !");
		
		
	}
	
	protected void perdreArgent(int prix) {
		int nouveauSolde = this.getArgent() - prix;
		this.setArgent(nouveauSolde);
		
	}
	
	protected void gagnerArgent(int prix) {
		int nouveauSolde = this.getArgent() + prix;
		this.setArgent(nouveauSolde);
	}
	
	public void acheter(String bien, int prix) {
		if (prix > this.getArgent()) {
			this.parler("Je n'ai plus que " + this.getArgent() + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
			
		} else {
			this.parler("J'ai " + this.getArgent() + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			this.perdreArgent(prix);

		}
		
	}
}
