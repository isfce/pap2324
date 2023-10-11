package tp00;

import java.util.Scanner;

public class Evaluation {
	
	/**
	 * Evalue la note pour attribuer une décision
	 * 0<=note<=100
	 * @param note une note entre 0 et 100
	 * @return la décision
	 */
	public static String calculDecision(double note) {
		assert 0<=note && note<=100 : "La note doit être entre 0 et 100";
		String res;
		res="A FAIRE";
		return res;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Entrez une note: ");
		int note = scan.nextInt();
		
		String decision = calculDecision(note);
		System.out.println("Hello ta note est: " + note + " la décision est: " + decision);
		scan.close();
	}

	

}
