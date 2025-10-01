package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.*;

public class Sabot implements Iterable<Carte>{
	
	private int nbCartes;
	private Carte[] cartes;
	int nombreOperations=0;

	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		nbCartes = cartes.length;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(Carte carte) {
		try {
			cartes[nbCartes]=carte;
			nbCartes++;
			nombreOperations++;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("le sabot est déjà plein, impossible d'ajouter une carte");
			nbCartes--;
			nombreOperations--;
		}
	}
	
	public Carte piocher() {
		Iterateur iterateur = new Iterateur();
		Carte carte = iterateur.next();
		iterateur.remove();
		return carte;
	}
	
	
	
	public Iterator<Carte>Iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte>{
		private int indiceIterateur=0;
		private int nombreOperationReference=nombreOperations;
		private boolean nextEffectue=false;
		
		
		public boolean hasNext() {
			return indiceIterateur<nbCartes;
		}
		
		private void verificationConcurrence() {
			if (nombreOperationReference!=nombreOperations) {
				throw new ConcurrentModificationException();
			}
		}
		
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue=true;
				return carte;
			}else {
				throw new NoSuchElementException();
			}
		}
		
		public void remove() {
			verificationConcurrence();
			if(indiceIterateur<1 || !nextEffectue) {
				throw new IllegalStateException();
			}else {
				for(int i=(indiceIterateur-1);i<nbCartes-1;i++) {
					cartes[i]=cartes[i+1];
				}
				nextEffectue=false;
				indiceIterateur--;
				nbCartes--;
				nombreOperationReference++;
				nombreOperations++;
			}
		}
		
	}

	@Override
	public Iterator<Carte> iterator() {
		
		return new Iterateur();
	}

	


}
