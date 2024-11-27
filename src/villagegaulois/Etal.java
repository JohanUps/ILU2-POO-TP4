package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public class Etal<P extends IProduit >implements IEtal {
	private Gaulois vendeur;
	private P[] produits;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;
	private int prix;
	private int nbProduit = 0;

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	public int getQuantite() {
		return quantite;
	}

	public void installerVendeur(Gaulois vendeur, P[] produit, int prix) {
		this.vendeur = vendeur;
		produits = produit;
		quantiteDebutMarche = produit.length;
		quantite = quantiteDebutMarche;
		etalOccupe = true;
		this.prix = prix;
		nbProduit = quantiteDebutMarche;
	}
	
	public int donnerPrix() {
		return prix;
	}
	
	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if (nbProduit != 0 && this.produits[0].getNom().equals(produit)) {
			if (nbProduit >= quantiteSouhaitee) {
				quantiteAVendre = quantiteSouhaitee;
			} else {
				quantiteAVendre = nbProduit;
			}
		}
		return quantiteAVendre;
	}
	
	
	@Override
	public String etatEtal() {
	StringBuilder chaine = new StringBuilder(vendeur.getNom());
	if (nbProduit > 0) {
		chaine.append(" vend ");
		chaine.append(nbProduit + " produits :");
		for (int i = 0; i < nbProduit; i++) {
			chaine.append("\n- " + produits[i].decrireProduit());
		}
	} else {
		chaine.append(" n'a plus rien � vendre.");
	}
	chaine.append("\n");
	return chaine.toString();
	}


		
	@Override
	public int acheterProduit(int quantiteSouhaite) {
		int prixPaye = 0;
		for (int i = nbProduit - 1; i > nbProduit - quantiteSouhaite - 1 || i > 1; i--) {
			prixPaye += produits[i].calculerPrix(prix); //question 3.d
		}
		if (nbProduit >= quantiteSouhaite) {
			nbProduit -= quantiteSouhaite;
		} else {
			nbProduit = 0;
		}
		return prixPaye;

	}	
		
		
		
		
		
		
		
		
		
		
	

}







