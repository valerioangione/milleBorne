package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import cartes.*;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	private HashSet<Joueur> joueurs = new HashSet<>();
	
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
	
	public void inscrire(Joueur ... args) {
		for(Joueur joueur : args) {
			joueurs.add(joueur);
		}
	}
	
	public void distribuerCartes() {
		for(int i = 0;i<6;i++) {
			for(Joueur joueur:joueurs) {
				if (joueur.getMain().getMain().size()<6) 
					joueur.donner(sabot.piocher());
			}
		}
	}
}
