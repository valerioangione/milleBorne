package jeu;

import cartes.*;

public class Coup {
	private Joueur joueur;
	private Carte carte;
	private Joueur cible;
	
	public Coup(Joueur joueur,Carte carte,Joueur cible) {
		this.joueur = joueur;
		this.carte=carte;
		this.cible=cible;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public Carte getCarte() {
		return carte;
	}

	public Joueur getCible() {
		return cible;
	}
	
	public boolean estValide() {
		if(carte instanceof Attaque || carte instanceof FinLimite)
			return cible.estDepotAutorise(carte);
		else
			return false;
	}
	
	@Override
	
	public boolean equals(Object objet) {
		if(objet instanceof Coup coup) {
			boolean res1 = this.carte.equals(coup.carte);
			boolean res2 = this.joueur.equals(coup.joueur);
			boolean res3 = this.cible.equals(coup.cible);
			return res1&&res2&&res3;
		}
		return false;
	}
	
	@Override
	
	public int hashCode() {
		return 17*carte.hashCode()+23*joueur.hashCode()+29*cible.hashCode();
	}
	
}
