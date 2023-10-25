package tp00;

import java.util.Scanner;

public class Evaluation {

	/**
	 * Evalue la note pour attribuer une décision 0<=note<=100
	 * 
	 * @param note une note entre 0 et 100
	 * @return la décision
	 */
	public static String calculDecision(double note) {
		assert 0 <= note && note <= 100 : "La note doit être entre 0 et 100";
		if (note < 30)
			return "Refus";
		if (note < 50)
			return "Ajourné";
		return "Réussite";
	}

	/**
	 * Calcule la somme de 1 à n via une boucle pour
	 * 
	 * @param n >=1
	 * @return la somme
	 */
	public static long calculSomme1(int n) {
		assert n >= 1 : "n doit être >=1";
		long s = 1;
		for (int i = 2; i <= n; i++)
			s = s + i;
		return s;
	}

	/**
	 * Calcule la somme de 1 à n Via une formule
	 * 
	 * @param n >=1
	 * @return la somme
	 */
	public static long calculSomme2(int n) {
		assert n >= 1 : "n doit être >=1";
		return n * (long) (n + 1) / 2;
	}

	/**
	 * Calcule la somme de 1 à n Via une formule
	 * valable pour les plus grands nombres
	 * @param n >=1
	 * @return la somme
	 */
	public static long calculSomme3(int n) {
		assert n >= 1 : "n doit être >=1";
		long n1 = n, n2 = n;

		if ((n & 1) == 0) {
			n1 = n / 2;
			n2 = n + 1;
		} else
			n2 = (n2 + 1) / 2;
		return n1 * n2;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean ok;
		int note;
		// Input
		do {
			System.out.print("Entrez une note: ");
			note = scan.nextInt();
			ok = (note >= 0 && note <= 100);
			if (!ok)
				System.err.println("ERREUR");
		} while (!ok);
		// traitement
		String decision = calculDecision(note);
		// Output
		System.out.println("Hello ta note est: " + note + " la décision est: " + decision);

		scan.close();
	}

}
