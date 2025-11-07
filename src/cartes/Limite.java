package cartes;

public abstract class Limite extends Carte{
	
	@Override
	
	public boolean equals(Object obj) {
		if(obj instanceof Limite lim) {
			return this.toString().equals(lim.toString());
		}
		return false;
	}
	
	@Override
	
	public int hashCode() {
		return 17*super.hashCode() + 31*this.toString().hashCode();
	}
}
