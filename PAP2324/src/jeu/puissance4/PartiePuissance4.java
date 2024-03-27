package jeu.puissance4;

import java.util.Scanner;

public class PartiePuissance4 {
	// Etats possible d'une partie
	private enum Etat {
		INIT, START, END
	};

	// matrice d'une partie pour un état initial
	private static int[][] initPartie = { { -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1 } };
	// Code assicié à une couleur
	private static final int JAUNE = 1;
	private static final int ROUGE = 2;

	// indique la position d'insertion pour chaque colonne
	// structure initiale pour le vecteur colonne
	private final static int[] colonnesInit = { 0, 6, 6, 6, 6, 6, 6, 6 };// 0 inutilisé

	// Etat de la partie
	private Etat etat = Etat.END;
	// matrice de la partie
	private int[][] jeu;

	// indique si c'est le trour du joueur A
	private boolean tourDesJaunes;
	// vecteur colonne pour faciliter l'insertion d'un pion
	private int[] colonnes;

	// Scanner pour lire les entrées
	Scanner scan;

	// affiche la matrice du jeu
	public void afficheJeu() {
		System.out.println();
		for (int i = 1; i < 7; i++) {
			System.out.printf("%2d ", i);
			for (int j = 1; j < 8; j++) {
				System.out.printf("%3d", jeu[i][j]);
			}
			System.out.println();
		}
		System.out.printf("%3s", "");
		for (int j = 1; j < 8; j++)
			System.out.printf("%3d", j);
		System.out.println();
	}

	/**
	 * 
	 * @param col la colonne dans laquelle le joueur a joué
	 * @param pion qui a été joué
	 * @return true si gagné plus de 4 pions de sa couleur à la suite
	 */
	public boolean suiteDe4(int col, int pion) {
		int cpt = 1;

		return cpt >= 4;
	}

	/**
	 * 
	 * @param col colonne spécifiée 1..7
	 * @param pion couleur 1..2
	 * @return true si ok
	 */
	public boolean introduirePion(int col, int pion) {
		assert col > 0 && col < 8 && (pion == 1 || pion == 2) : "erreur de donnée";
		if (colonnes[col] == 0)
			return false;
		jeu[colonnes[col]][col] = pion;
		colonnes[col]--;
		return true;
	}

	// initialise une partie
	public void initPartie() {
		etat = Etat.INIT;
		jeu = initPartie.clone();
		colonnes = colonnesInit.clone();
		// initialise le scanner
		scan = new Scanner(System.in);
	}

	/**
	 * La partie doit être dans l'état Init
	 */
	public void startPartie() {
		if (etat != Etat.INIT) {
			System.err.println("La partie doit d'abord être initialisée");
			return;
		}
		etat = Etat.START; // partie démarrée
		tourDesJaunes = true; // les Jaunes commencent
		boolean abandon = false; // abandon d'un joueur
		boolean gagne = false; // partie gagnée
		boolean finPartie = false; // partie terminée
		boolean choixValide = false; // choix de l'entrée est une position valide
		int choixJ;// colonne choisie
		int nbPionsSurJeu = 0;// nombre de pions joués
		String couleurJoueur = "Jaunes"; /// couleur du joueur en cours
		// boucle générale de la partie
		while (!finPartie && !abandon) {
			afficheJeu();
			// mémorise la couleur du joueur qui va jouer
			couleurJoueur = tourDesJaunes ? "Jaunes" : "Rouges";
			// Indique qui doit jouer
			System.out.println("Le joueur avec les " + couleurJoueur + " doit faire son choix (1..7): ");

			// Tant que la donnée entrée n'est pas valable on boucle
			do {
				/*
				 * entrée entre 1 et 7 pour la colonne 
				 * un nombre négatif signifie que le joueur abandonne
				 */
				choixJ = lireEntier();
				abandon = choixJ < 0;// Une entrée <0 signifie un abandon
				if (!abandon) {
					// introduit le pion et vérifie si le coup est valide
					choixValide = introduirePion(choixJ, tourDesJaunes ? JAUNE : ROUGE);
					if (!choixValide)
						System.out.println("La position n'est pas valide");
					else
						nbPionsSurJeu++;
				}
			} while (!abandon && !choixValide);
			// vérifie si le joueur a gagné
			gagne = suiteDe4(choixJ, tourDesJaunes ? JAUNE : ROUGE);
			if (!abandon && !gagne) {
				// au tour de l'autre joueur
				tourDesJaunes = !tourDesJaunes;
			}

			// si abandon, si gagné ou si plus de pion
			finPartie = abandon || gagne || nbPionsSurJeu == 42;
		}
		System.out.println("FIN PARTIE:");
		afficheJeu();
		// Affiche le résultat de la partie
		String resultat;
		if (abandon)
			resultat = "Le joueur avec les pions " + couleurJoueur + " a abandonné";
		else if (!gagne)
			resultat = "Partie nulle";
		else
			resultat = "Le joueur avec les pions " + couleurJoueur + " a gagné!";

		System.out.println(resultat);

		// Il faut démarrer une nouvelle partie
		etat = Etat.END;
		scan.close();
	}

	/**
	 * Lit une entrée entre 1 et 7 ou -1 pour abandon
	 * 
	 * @return le nombre
	 */
	private int lireEntier() {
		String input;
		int x = -1;
		boolean ok;
		// attend un nombre entre 1 et 7 ou -1
		do {// lit la prochaine ligne
			ok = false;
			input = scan.nextLine();
			try {// parse un entier
				x = Integer.parseInt(input);
				// vérifie validité du nombre
				ok = x == -1 || (x > 0 && x < 8);
				if (!ok)
					System.err.println("Entrez une valeur entre 1 et 7 , ou -1 pour un abandon");
			} catch (NumberFormatException e) {
				System.err.println("Entrez un nombre!");
			}
		} while (!ok);
		return x;
	}

	public static void main(String[] args) {
		PartiePuissance4 partie = new PartiePuissance4();
		partie.initPartie();
		partie.startPartie();

	}
}
