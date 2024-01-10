package jeu.carte;

public enum Forme {
	PIQUE(Couleur.NOIR), TREFLE(Couleur.NOIR), CARREAU(Couleur.ROUGE), COEUR(Couleur.ROUGE);

	private final Couleur couleur;

	Forme(Couleur couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the couleur
	 */
	public Couleur getCouleur() {
		return couleur;
	}

	
}
