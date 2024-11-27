package produit;

public interface IProduit {

	String getNom();

	Unite getUnite();

	String decrireProduit();
	
	int calculerPrix(int prix);
}