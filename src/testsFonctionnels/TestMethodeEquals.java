package testsFonctionnels;

import cartes.*;

public class TestMethodeEquals {

	public static void main(String args[]) {
		Carte borne25n1 = new Borne(25);
		Carte borne25n2 = new Borne(25);
		Carte feuRouge1 = new Attaque(Type.FEU);
		Carte feuRouge2 = new Attaque(Type.FEU);
		Carte feuVert = new Parade(Type.FEU);
		
		System.out.println(borne25n1.equals(borne25n2));
		System.out.println(feuRouge2.equals(feuRouge1));
		System.out.println(feuRouge1.equals(feuVert));
}

}
