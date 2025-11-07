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
	
	@Override
	
	public int hashCode() {
		return 11*super.hashCode() + 31*type.hashCode();
	}
}
