package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}

	@Override
	public String decrireProduit() {
		StringBuilder description = new StringBuilder();
		description.append(super.getNom());
		description.append(" de ");
		description.append(String.valueOf(poids));
		description.append(" ");
		description.append(super.getUnite());
		description.append(" chassé par ");
		description.append(chasseur.getNom());
		
		return description.toString();
	}

	@Override
	public int calculerPrix(int prix) {
		return (prix * poids)/1000;
	}
	
	
}
