package personnages;

public class Humain {
	private static final int MEMOIRE_TAILLE = 30;
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissance = 0;
	protected Humain[] memoire = new Humain[MEMOIRE_TAILLE]; 

	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}
	
	public void setMemoire(Humain[] memoire) {
		this.memoire = memoire;
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
		System.out.println("(" + this.getNom() + ") " + texte);
		
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
	
	public void memoriser(Humain humainAMemoriser) {
		if (nbConnaissance == MEMOIRE_TAILLE) {
			Humain[] nouvelleMemoire = new Humain[MEMOIRE_TAILLE];
			for (int i = 1; i < memoire.length; i++) {
				nouvelleMemoire[i-1] = memoire[i];
			}
			this.setMemoire(nouvelleMemoire);
			
			memoire[nbConnaissance - 1] = humainAMemoriser;
			
		} else {
			memoire[nbConnaissance] = humainAMemoriser;
			nbConnaissance += 1;
		}
		
	}

	public void repondre(Humain homme1) {
		this.direBonjour();
		this.memoriser(homme1);
		
		
	}
	
	
	public void faireConnaissanceAvec(Humain homme2) {
		this.direBonjour();
		homme2.repondre(this);
		this.memoriser(homme2);
			
	}
	
	public void listerConnaissance() {
		String texte = "";
		for (int i = 0; i < nbConnaissance; i++) {
			texte += memoire[i].getNom() + ", ";
		}
		this.parler("Je connais beaucoup de monde dont : " + texte);
		
	}
	

	
	
	
	
	
	
	
}
