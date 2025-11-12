package testsFonctionnels;

import cartes.*;
import jeu.*;
import utils.*;

public class TestJeu {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		Joueur jack = new Joueur("Jack");
		Joueur paul = new Joueur("Paul");
		Joueur jean = new Joueur("Jean");
		jeu.inscrire(jack,jean,paul);
		jeu.distribuerCartes();
		System.out.println("jeu distribué");
//		jeu.jouerTour(jack);
//		jeu.jouerTour(paul);
//		jeu.jouerTour(jean);
		System.out.println(jeu.lancer());
	}
	
}
