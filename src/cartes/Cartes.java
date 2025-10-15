package cartes;

public interface Cartes {
	Botte PRIORITAIRE = new Botte(Type.FEU);
	Attaque FEU_ROUGE = new Attaque(Type.FEU);
	Parade FEU_VERT = new Parade(Type.FEU);
	Botte CITERNE = new Botte(Type.ESSENCE);
	Attaque PANNE_ESSENCE = new Attaque(Type.ESSENCE);
	Parade ESSENCE = new Parade(Type.ESSENCE);
	Botte INCREVABLE = new Botte(Type.CREVAISON);
	Attaque CREVAISON = new Attaque(Type.CREVAISON);
	Parade ROUE_DE_SECOURS = new Parade(Type.CREVAISON);
	Botte AS_DU_VOLANT = new Botte(Type.ACCIDENT);
	Attaque ACCIDENT = new Attaque(Type.ACCIDENT);
	Parade REPARATION = new Parade(Type.ACCIDENT);
}
