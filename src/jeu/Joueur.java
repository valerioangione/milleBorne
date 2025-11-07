package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;
import java.util.LinkedList;

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
	
	@Override
	
	public int hashCode() {
		return 31*nom.hashCode();
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
	
	public boolean estDepotAutorise(Carte carte) {
		return zonedejeu.estDepotAutorise(carte);
	}
	
	public HashSet<Coup> coupsPossibles(HashSet<Joueur> participants){
		HashSet<Coup> coups = new HashSet<>();
		LinkedList<Carte> mainJoueur = main.getMain();
		for(Iterator<Carte> iterateur = mainJoueur.iterator();iterateur.hasNext();) {
			for(Joueur adv : participants) {
				Coup coup = new Coup(this,iterateur.next(),adv);
				if(coup.estValide())coups.add(coup);
			}
		}
		return coups;
	}
	
	public HashSet<Coup> coupsDefausse() {
		HashSet<Coup> coups = new HashSet<>();
		for(Iterator<Carte> iterateur = main.getMain().iterator();iterateur.hasNext();) {
			Coup coup = new Coup(this,iterateur.next(),null);
			coups.add(coup);
		}
		return coups;
	}
	
	public void retirerDeLaMain(Carte carte) {
		main.jouer(carte);
	}
	
	public Coup choisirCoup(HashSet<Joueur> participants) {
		HashSet<Coup> coups = coupsPossibles(participants);
		if(coups.isEmpty())
			coups = coupsDefausse();
		Random random = new Random();
		ArrayList<Coup> liste = new ArrayList<Coup>(coups);
		int indexAleatoire = random.nextInt(liste.size());
		return liste.get(indexAleatoire);
	}
	
}
