package jeu;


import java.util.*;

import cartes.*;

public class ZoneDeJeu {

	private List<Limite> limites = new LinkedList<Limite>();
	private List<Bataille> bataille = new LinkedList<Bataille>();
	private Collection<Borne> bornes = new LinkedList<Borne>();
	
	public int donnerLimitationVitesse() {
		int limite = 200;
		if(!limites.isEmpty()) {
			if(limites.get(limites.size()-1).toString().equals("limite 50"))
				limite = 50;
		}
		return limite;
	}
	
	public int donnerKmParcourus() {
		int km = 0;
		for(Iterator<Borne> iterateur = bornes.iterator();iterateur.hasNext();) {
			km += iterateur.next().getKm();
		}
		return km;
	}
	
	public void deposer(Carte carte) {
		if(carte instanceof Borne borne) {
			bornes.add(borne);
			System.out.println("Deposer carte " + borne.toString() );
		}
		else if(carte instanceof Limite limite) {
			limites.add(limite);
			System.out.println("Limite : " + donnerLimitationVitesse());
		}
		else if(carte instanceof Bataille bat)
			bataille.add(bat);
	}

	public boolean peutAvancer() {
		boolean etat = true;
		if(!bataille.isEmpty()) {
			if(bataille.get(bataille.size()-1) instanceof Attaque)
				etat = false;
		}
		return etat;
	}
	
	public boolean estDepotVertAutorise() {
		boolean etat = true;
		if(!bataille.isEmpty()) {
			if(bataille.get(bataille.size()-1) instanceof Attaque att) {
				if(att.toString().equals("Feu rouge"))
					etat = true;
				else
					etat = false;
			}
		}
		return etat;
	}
		
}




























