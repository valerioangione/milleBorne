package cartes;

public abstract class Carte {

	public boolean equals(Carte carte) {
		return this.toString().equals(carte.toString());
	}
	
}
