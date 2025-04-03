package personnages;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;
	
	public Traitre(String seigneur, String nom, String boisson, int argent) {
		super(seigneur, nom, boisson, argent);
	}
	
	public int getNiveauTraitrise() {
		return niveauTraitrise;
	}

	public void setNiveauTraitrise(int niveauTraitrise) {
		this.niveauTraitrise = niveauTraitrise;
	}

	

	@Override public void direBonjour() {
		super.direBonjour();
		this.parler("Mais je suis un tra�tre et mon niveau de tra�trise est : " + this.getNiveauTraitrise()  + " Chut !" );
	}

	public void ranconner(Commercant commercant) {
		if (this.getNiveauTraitrise() < 3) {
			int argentRanconner = commercant.getArgent()*2/10;
			commercant.perdreArgent(argentRanconner);
			this.gagnerArgent(argentRanconner);
			this.setNiveauTraitrise(this.getNiveauTraitrise() + 1);
			this.parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconner + " sous ou gare � toi !");
			commercant.parler("Tout de suite grand " + commercant.getNom() + " .");
			
		} else {
			this.parler("Mince je ne peux plus ran�onner personne sinon un samoura� rique de me d�masquer ! ");
			
		}
		
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			this.parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
			
		} else {

		}
		
	}
}
