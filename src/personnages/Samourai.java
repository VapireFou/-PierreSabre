package personnages;

public class Samourai extends Humain {
	private String seigneur;

	public Samourai(String seigneur,String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		this.seigneur = seigneur;
	}
	
	@Override public void direBonjour(){
		this.parler("Bonjour ! Je m'appelle " + this.getNom() + " et j'aime boire du " + this.getBoisson());
		this.parler("Je suis fier de servir le seignuer " + seigneur);
	}
	
	public void boire(String boisson) {
		this.parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du " + boisson);
	}
}
