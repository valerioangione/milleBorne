package jeu;


import java.util.*;

import cartes.*;

public class ZoneDeJeu {

	private List<Limite> limites = new LinkedList<Limite>();
	private List<Bataille> bataille = new LinkedList<Bataille>();
	private Collection<Borne> bornes = new LinkedList<Borne>();
	private Set<Botte> bottes = new HashSet<>();
	
	
	
	public List<Limite> getLimites() {
		return limites;
	}

	public List<Bataille> getBataille() {
		return bataille;
	}

	public Collection<Borne> getBornes() {
		return bornes;
	}

	public Set<Botte> getBottes() {
		return bottes;
	}

	public int donnerLimitationVitesse() {
		int limite = 200;
		if(!limites.isEmpty()&&!estPrioritaire()) {
			if(limites.get(limites.size()-1).toString().equals("limite 50"))
				limite = 50;
		}
		return limite;
	}
	
	public int donnerKmParcourus() {
		int km = 0;
		for(Iterator<Borne> iterateur = bornes.iterator();iterateur.hasNext();) {
			km += iterateur.next().getKm();
		}
		return km;
	}
	
	public void deposer(Carte carte) {
		if(carte instanceof Borne borne) {
			bornes.add(borne);
			//System.out.println("Deposer carte " + borne.toString() );
		}
		else if(carte instanceof Limite limite) {
			limites.add(limite);
			//System.out.println("Limite : " + donnerLimitationVitesse());
		}
		else if(carte instanceof Bataille bat)
			bataille.add(bat);
		else if(carte instanceof Botte bot)
			bottes.add(bot);
	}

	public boolean peutAvancer() {
		boolean etat = false;
		if(!bataille.isEmpty()) {
			Bataille carte = bataille.get(bataille.size()-1);
			if(carte instanceof Parade par) {
				if(par.toString().equals("Feu vert") || estPrioritaire())
					return true;
			}else {
				Botte bot = new Botte(carte.getType());
				if (bottes.contains(bot))return true;
			}
					
		}else 
			return estPrioritaire();
		return etat;
	}
	
	public boolean estDepotVertAutorise() {
		if(estPrioritaire())return false;
		boolean etat = true;
		if(!bataille.isEmpty()) {
			if(bataille.get(bataille.size()-1) instanceof Attaque att) {
				if(att.toString().equals("Feu rouge"))
					etat = true;
				else
					etat = false;
			}
		}
		return etat;
	}
	
	public boolean estDepotBorneAutorise(Borne borne) {
		boolean test = false;
		if(estPrioritaire())test =  true;
		if(borne.getKm()>donnerLimitationVitesse()) {
			return false || test;
		}
		if(borne.getKm()+donnerKmParcourus()>1000) {
			return false;
		}
		return peutAvancer();
	}
	
	public boolean estDepotLimiteAutorise(Limite limite) {
		if(estPrioritaire())return false;
		if(limites.isEmpty()) {
			if(limite instanceof DebutLimite)return true;
			else return false;
		}
		if(limite instanceof DebutLimite) {
			if(limites.get(limites.size()-1).toString().equals("fin limite"))return true;
		}else {
			if(limites.get(limites.size()-1).toString().equals("limite 50"))return true;
		}
		return false;
	}
	

	
	
	public boolean estDepotBatailleAutorise(Bataille bataille) {
		Botte botte = new Botte(bataille.getType());
		if(bottes.contains(botte))return false;
		if(bataille instanceof Attaque) {
			if(peutAvancer())return true;
		}else {
			if(bataille.toString().equals("Feu vert"))return estDepotVertAutorise();
			if(!this.bataille.isEmpty()) {
				if(this.bataille.get(this.bataille.size()-1).getType()==bataille.getType())
					return true;
			}
		}
		return false;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if(carte instanceof Bataille bat)
			return estDepotBatailleAutorise(bat);
		if(carte instanceof Limite lim)
			return estDepotLimiteAutorise(lim);
		if(carte instanceof Borne bor)
			return estDepotBorneAutorise(bor);
		if(carte instanceof Botte)
			return true;
		return false;
	}
	
	public boolean estPrioritaire() {
		Botte prio = new Botte(Type.FEU);
		return bottes.contains(prio);
	}
}




























