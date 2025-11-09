package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cartes.*;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	private HashSet<Joueur> joueurs = new HashSet<>();
	Iterator<Joueur> iterateur = joueurs.iterator();
	
	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte carte : jeu.donnerCartes()) {
        listeCarteNonMelangee.add(carte);
        }
        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
        listeCartes = GestionCartes.melanger(listeCartes);
        Carte[] sab = listeCartes.toArray(new Carte[0]);
        this.sabot =new Sabot(sab);
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
	
	public void jouerTour(Joueur joueur) {
		Carte carte = joueur.prendreCarte(sabot);
		joueur.donner(carte);
		System.out.println(joueur.getMain().toString());
		Coup coup = joueur.choisirCoup(joueurs);
		joueur.retirerDeLaMain(coup.getCarte());
		if(coup.getCible()==null) {
			sabot.ajouterCarte(coup.getCarte());
		}
		else
			if(coup.getCible().estDepotAutorise(coup.getCarte()))
				coup.getCible().deposer(coup.getCarte());
			else
				System.out.println("coup non autorisé");
		System.out.println(coup.toString());
	}
	
	public Joueur donnerJoueurSuivant() {
		if(iterateur.hasNext()) 
			return iterateur.next();
		else {
			iterateur = joueurs.iterator();
			if(iterateur.hasNext())
				return iterateur.next();
			else
				return null;
		}
	}
	
	public String lancer() {
		boolean fini = false;
		StringBuilder txt = new StringBuilder();
		while(!fini && !sabot.estVide()) {
			Joueur courant = donnerJoueurSuivant();
			jouerTour(courant);
			if(courant.donnerKmParcourus()==1000) {
				fini = true;
				txt.append(courant.toString()).append(" remporte la partie");
			}
		}
		if(sabot.estVide())
			txt.append("sabot vide");
		return txt.toString();
	}
}
