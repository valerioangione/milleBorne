package testsFonctionnels;

import java.util.*;

import cartes.*;
import utils.*;

public class TestJeuDeCartes {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		
		
		
		System.out.println(jeu.affichageJeuDeCartes());
		
		
		
        if (!jeu.checkCount()) {
            System.out.println("erreur de nombre");
        }
        

        List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte carte : jeu.donnerCartes()) {
        listeCarteNonMelangee.add(carte);
        }
        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
        System.out.println(listeCartes);
        listeCartes = GestionCartes.melanger(listeCartes);
        System.out.println(listeCartes);
        System.out.println("liste mélangée sans erreur ? "
        + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
        listeCartes = GestionCartes.rassembler(listeCartes);
        System.out.println(listeCartes);
        System.out.println("liste rassemblée sans erreur ? "
        + GestionCartes.verifierRassemblement(listeCartes));
	}
	

}