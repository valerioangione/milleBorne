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
		if(cible==null)return true;
		if(!(cible.equals(joueur))){
			if(carte instanceof Attaque || carte instanceof DebutLimite)
				return cible.estDepotAutorise(carte);
			else
				return false;
		}else {
			if(carte instanceof Parade || carte instanceof FinLimite || carte instanceof Borne || carte instanceof Botte) 
				return cible.estDepotAutorise(carte);
			else
				return false;
		}
	}
	
	@Override
	
	public String toString() {
		StringBuilder txt = new StringBuilder();
		txt.append(joueur.toString());
		if(cible==null) 
			txt.append(" defausse la carte ").append(carte.toString()).append(".");
		else {
			txt.append(" depose la carte ").append(carte.toString());	
			if(joueur.equals(cible))
				txt.append(" dans sa zone de jeu.");
			else
				txt.append(" dans la zone de jeu de ").append(cible.toString()).append(".");	
		}
		return txt.toString();
	}
	                        
	
	@Override
	
	public boolean equals(Object objet) {
		if(objet instanceof Coup coup) {
			boolean res1 = this.carte.equals(coup.carte);
			boolean res2 = this.joueur.equals(coup.joueur);
			boolean res3;
			if(this.cible==null||coup.cible==null) {
				res3=false;
				if(this.cible==null&&coup.cible==null)
					res3=true;
			}else
				res3 = this.cible.equals(coup.cible);
			return res1&&res2&&res3;
		}
		return false;
	}
	
	@Override
	
	public int hashCode() {
		int hashcible;
		if(cible==null) 
			hashcible=1;
		else
			hashcible=29*cible.hashCode();
		return 17*carte.hashCode()+23*joueur.hashCode()+hashcible;
	}
	
}
