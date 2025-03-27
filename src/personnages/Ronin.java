package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}

	
	public int getHonneur() {
		return honneur;
	}


	public void setHonneur(int honneur) {
		this.honneur = honneur;
	}


	public void donner(Commercant beneficiaire) {
		int valeurDon = this.getArgent() / 10;
		beneficiaire.recevoir(valeurDon);
		
	}
	
	public void provoquer(Yakusa adversaire) {
		int forceRonin = this.honneur*2;
		this.parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
		if ( forceRonin >= adversaire.getReputation() ) {
			this.parler("Je t'ai eu petit yakusa !");
			adversaire.perdre();
			
		} else {
			int argentPerdu = this.getArgent();
			this.honneur -= 1;
			this.perdreArgent(argentPerdu);
			adversaire.gagner(argentPerdu);
			

		}
		
	}
}
