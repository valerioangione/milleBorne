package cartes;

public enum Type {	
	FEU("Feu rouge", "Feu vert", "vehicule prioritair"),
	ESSENCE("panne d'essence", "essence", "citerne"),
	CREVAISON("crevaison", "roue de secours", "increvable"),
	ACCIDENT("accident", "réparation", "as du volant");
	
	private String attaque;
	private String parade;
	private String botte;
	
	Type(String attaque, String parade, String botte) {
		this.attaque=attaque;
		this.parade=parade;
		this.botte=botte;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}
	
	
}
