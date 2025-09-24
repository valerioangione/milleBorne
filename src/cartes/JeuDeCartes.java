package cartes;

public class JeuDeCartes {

	private Configuration[] typesDeCartes = new Configuration[19];
	
	public String affichageJeuCartes() {
		StringBuilder txt = new StringBuilder();
		txt.append("JEU : \n");
		for(Configuration config : typesDeCartes) {
			txt.append(config.nbExemplaires).append(" ");
			txt.append(config.getCarte().toString());
		}
		return txt.toString();
	}
	
	public Carte[] donnerCartes() {
		int nbCartes=0;
		for(Configuration config : typesDeCartes) {
			nbCartes=nbCartes+config.getNbExemplaires();
		}
		Carte[] cartes = new Carte[nbCartes];
		int i = 0;
		for (Configuration config : typesDeCartes) {
			for (int j=0; j<config.nbExemplaires;j++) {
				cartes[i]=config.getCarte();
				i++;
			}
		}
		return cartes;
	}
	
	
	
	private static class Configuration {
		private int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}

		private int getNbExemplaires() {
			return nbExemplaires;
		}

		private Carte getCarte() {
			return carte;
		}
		
		
		
	}

}
