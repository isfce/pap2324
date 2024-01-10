package jeu.carte;

public class Test {
	
	public static Carte[] creeJeu(){
		Carte[] jeu = new Carte[52];
		//TODO
		
		return jeu;
	}
	

	public static void main(String[] args) {
		Forme c1 = Forme.COEUR;
		
		System.out.println(c1+" ordre: "+c1.ordinal());
		System.out.println(c1.getCouleur());
		
		Carte asP = new Carte(1,Motif.AS, Forme.PIQUE);
		Carte dameC = new Carte(12,Motif.DAME, Forme.COEUR);
		System.out.println(asP + "Couleur: "+asP.forme().getCouleur());
		System.out.println(dameC+ "Couleur: "+dameC.forme().getCouleur());
		
	//	for (Forme f : Forme.values())
	//		System.out.println(f);
	
		
		
	}

}
