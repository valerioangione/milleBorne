package jeu;

import java.util.*;
import cartes.*;

public class MainJoueur {

	private List<Carte> main = new LinkedList<Carte>();
	
	
	public void prendre(Carte carte) {
		main.add(carte);
	}
		
	public void jouer(Carte carte) {
		assert main.contains(carte) : "La carte " + carte.toString() + " n'est pas présente dans la main";
		main.remove(carte);
	}
	
	@Override
	
	public String toString() {
		StringBuilder txt = new StringBuilder();
		txt.append("Cartes de la main : ");
		for(Iterator<Carte> iterateur = main.iterator(); iterateur.hasNext();) {
			txt.append(iterateur.next().toString()).append(" ");
		}
		return txt.toString();
	}

}
