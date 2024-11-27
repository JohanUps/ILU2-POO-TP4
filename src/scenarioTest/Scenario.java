package scenarioTest;

import personnages.Gaulois;
import produit.IProduit;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IVillage;

public class Scenario {

	public static void main(String[] args) {

		//Partie 4 : creer de la classe anonyme Village
		IVillage village = new IVillage() {
            private Etal[] marche = new Etal[3];

            @Override
            public <P extends IProduit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produits, int prix) {
                for (int i = 0; i < marche.length; i++) {
                    if (marche[i] == null) { 
                        etal.installerVendeur(vendeur, produits, prix); 
                        marche[i] = etal; 
                        return true;
                    }
                }
                return false;
            }

            @Override
            public void acheterProduit(String produit, int quantiteSouhaitee) {
            	StringBuilder message = new StringBuilder();
            	int quantiteAcheter = 0;
            	int quantiteAcheterEtal = 0;
            	
            	int i = 0;
            	while(i<marche.length && quantiteAcheter<quantiteSouhaitee) {
            		if (marche[i] != null && marche[i].contientProduit(produit,quantiteSouhaitee) > 0) {
            			
            			if(marche[i].contientProduit(produit, quantiteSouhaitee)<= quantiteSouhaitee - quantiteAcheter) {
            				quantiteAcheterEtal = marche[i].contientProduit(produit, quantiteSouhaitee);
            			}
            			else {
            				quantiteAcheterEtal = quantiteSouhaitee - quantiteAcheter;
            			}
            			
            			quantiteAcheter += quantiteAcheterEtal;
            			int prix = marche[i].acheterProduit(quantiteAcheterEtal);
            			message.append("A l'étal n°");
            			message.append(i+1);
            			message.append(" j'achète ");
            			message.append(quantiteAcheterEtal);
            			message.append(" ");
            			message.append(produit);
            			message.append(" et je paye ");
            			message.append(prix);
            			message.append("\n");
            		}
            		i++;
            	}
            	message.append("Je voulais acheter ");
            	message.append(quantiteSouhaitee);
            	message.append(" ");
            	message.append(produit);
            	message.append(", j'en ai acheter ");
            	message.append(quantiteAcheter);
            	message.append("\n");
            	
            	System.out.println(message.toString());
            }
			
			
            @Override
            public String toString(){
            	StringBuilder affichage = new StringBuilder();
            	for(int i = 0; i<marche.length; i++) {
            		if(marche[i] != null) {
            			affichage.append(marche[i].etatEtal());
            		}
            		else {
            			affichage.append("Etal n°");
            			affichage.append(i+1);
            			affichage.append(" vide");
            		}
            		affichage.append("\n");
            	}
            	return affichage.toString();
            }
			
			
			
			
			
			
			
			
		};

		// fin

		Gaulois ordralfabetix = new Gaulois("OrdralfabÃ©tix", 9);
		Gaulois obelix = new Gaulois("ObÃ©lix", 20);
		Gaulois asterix = new Gaulois("AstÃ©rix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}
