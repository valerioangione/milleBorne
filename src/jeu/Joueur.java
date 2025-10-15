package jeu;

import cartes.*;

public class Joueur {

	private String nom;
	private ZoneDeJeu zonedejeu = new ZoneDeJeu();
	private MainJoueur main = new MainJoueur();
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	@Override
	
	public boolean equals(Object obj) {
		if(obj instanceof Joueur joueur) {
			return nom.equals(joueur.nom);
		}
		return false;
	}
	
	@Override
	
	public String toString() {
		return nom;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public MainJoueur getMain() {
		return main;
	}
	
	public Carte prendreCarte(Sabot sabot) {
		Carte carte = sabot.piocher();
		main.prendre(carte);
		return carte;
	}
	
	public int donnerKmParcourus() {
		return zonedejeu.donnerKmParcourus();
	}
}
