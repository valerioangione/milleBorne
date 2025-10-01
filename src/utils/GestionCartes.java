package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import cartes.*;

public class GestionCartes {

//	public static <T> T extraire(List<T> list){
//		Random random = new Random();
//		int indice = random.nextInt(list.size());
//		T element = list.get(indice);
//		list.remove(indice);
//		return element;
//	}
	
	public static <T> T extraire(List<T> list){
		Random random = new Random();
		int indice = random.nextInt(list.size());
		ListIterator<T> iterateur = list.listIterator(indice);
		T element = iterateur.next();
		iterateur.remove();
		return element;
	}
	
	public static <T> List<T> melanger(List<T> list) {
		List<T>resultat = new ArrayList<T>();
		int taille = list.size();
		for (int i = 0; i<taille;i++) {
			resultat.add(extraire(list));
		}
		return resultat;
	}
	
	public static <T> boolean verifiermelange(List<T> list1, List<T> list2){
		boolean test = true;
		for (int i=0; i<list1.size();i++) {
			test = Collections.frequency(list1, list1.get(i))==Collections.frequency(list2, list1.get(i));
			if(!test)return test;
		}
		return test;
	}
	
	public static <T> List<T> rassembler(List<T> list){
		List<T> resultat = new ArrayList<T>();
		int taille = list.size();
		T element;
		for (int i=0; i<taille;i++) {
			element = list.get(i);
			boolean trouver = false;
			int j = 0;
			for(ListIterator<T>iterateur = resultat.listIterator();iterateur.hasNext()&&!trouver;) {
				T test = iterateur.next();
				if(element.equals(test)) {
					resultat.add(j, element);
					trouver = true;
				}
				j++;
				
			}
			if(!trouver) {
				resultat.add(element);
			}
		}
		
		return resultat;
	}
}
