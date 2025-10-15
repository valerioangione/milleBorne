package testsFonctionnels;

import cartes.Borne;
import cartes.DebutLimite;
import cartes.FinLimite;
import jeu.ZoneDeJeu;

public class TestZoneDeJeu {

	public static void main(String[] args) {
		ZoneDeJeu zdj = new ZoneDeJeu();
		Borne kma = new Borne(25);
		Borne kmb = new Borne(75);
		Borne kmc = new Borne(50);
		Borne kmd = new Borne(200);
		DebutLimite lm = new DebutLimite();
		FinLimite flm = new FinLimite();
		zdj.deposer(kma);
		zdj.deposer(kmb);
		zdj.deposer(kmc);
		System.out.println(zdj.donnerKmParcourus());
		zdj.deposer(lm);
		zdj.deposer(flm);
		zdj.deposer(kmd);
		System.out.println(zdj.donnerKmParcourus());

		
	}

}
