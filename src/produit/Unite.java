package produit;

public enum Unite {
	GRAMME("g"),
	KILOGRAMME("kg"),
	LITRE("l"),
	CENTILITRE("cl"),
	MILLILITRE("ml"),
	PIECE("piece");
	
	private final String sUnite;
	
	Unite(String sUnite){
		this.sUnite = sUnite;
	}
	
	public String getUnite(){
		return sUnite;
	}
}
