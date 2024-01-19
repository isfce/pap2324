package util;

import jeu.carte.Carte;
import jeu.carte.Forme;
import jeu.carte.Motif;

public class Test {

	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<>(10);
		s1.push(67);

		s1.push(92);
		s1.push(5);
		s1.push(1000);
		while (!s1.empty()) {
			System.out.println(s1);
			System.out.println(s1.pop());
		}
		System.out.println(s1);
		s1 = null;
		System.out.println("============================");

		Stack<Carte> pot = new Stack<>(52);
		pot.push(new Carte(1, Motif.AS, Forme.PIQUE));
		pot.push(new Carte(5, Motif.CINQ, Forme.CARREAU));
		pot.push(new Carte(12, Motif.DAME, Forme.COEUR));
		while (!pot.empty()) {
			System.out.println(pot);
			System.out.println("pop ==> " + pot.pop());
		}
		System.out.println(pot);
		pot = null;
	}
}
