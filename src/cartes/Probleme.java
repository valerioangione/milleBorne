package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	public Probleme(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	
	public boolean equals(Object probleme) {
		return super.equals(probleme) && this.getType() == ((Probleme)probleme).getType();
	}
	
	public int hashCode() {
		return 31*type.hashCode();
	}
}
