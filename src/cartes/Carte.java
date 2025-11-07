package cartes;

public abstract class Carte {

	@Override
	
	public boolean equals(Object carte) {
		return this.getClass().equals(carte.getClass());
	}	
	
	@Override
	
	public int hashCode() {
		return getClass().hashCode();
	}
	
}
