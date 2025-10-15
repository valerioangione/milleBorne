package jeu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cartes.*;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	
	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte carte : jeu.donnerCartes()) {
        listeCarteNonMelangee.add(carte);
        }
        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
        listeCartes = GestionCartes.melanger(listeCartes);
        this.sabot =new Sabot( (Carte[]) listeCartes.toArray());
	}
}
