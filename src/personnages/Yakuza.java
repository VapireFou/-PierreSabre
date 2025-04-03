package personnages;

public class Yakuza extends Humain{
	private String clan;
	private int reputation = 1;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		
	}
	
	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public String getClan() {
		return clan;
	}

	public void extorquer(Commercant victime) {
		this.parler("Tiens,tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		this.parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int argentExtorquer = victime.seFaireExtorquer();
		this.gagnerArgent(argentExtorquer);
		this.parler("J'ai piqué les " + argentExtorquer + " sous de " + victime.getNom() + ", ce qui me fait " + this.getArgent() + " sous dans ma poche. Hi ! Hi !");
		int rep = this.getReputation();
		this.setReputation(rep + 1);
	}
	
	public void gagner(int gain) {
		this.reputation += 1;
		this.parler("Ce ronin pensait vraiment battre " + this.getNom() + "du clan " + this.getClan() + " ? Je l'ai dépouillé de " + gain + " sous.");
		this.gagnerArgent(gain);
		
		
	}
	
	public int perdre() {
		this.reputation -= 1;
		this.parler("J'ai perdu mon duel et mes " + this.getArgent() + " sous, snif... J'ai déshonoré le clan de Warsong");
		int argentPerdu = this.getArgent();
		this.perdreArgent(argentPerdu);
		return argentPerdu;
		
	}
	
	@Override public void direBonjour() {
		this.parler("Bonjour ! Je m'appelle " + this.getNom() + " et j'aime boire du " + this.getBoisson());
		this.parler("Mon clan est celui de " + this.getClan());
	}
	
}
