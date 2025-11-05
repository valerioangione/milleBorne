package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int km) {
		this.km = km;
	}
	
	public String toString() {
		StringBuilder txt = new StringBuilder();
		txt.append(km).append(" km");
		return txt.toString();
	}
	
	public int getKm() {
		return km;
	}
	
	@Override
	
	public boolean equals(Object borne) {
		return super.equals(borne) && this.getKm()==((Borne)borne).getKm();
	}
}