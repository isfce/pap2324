package fichier.notes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectureCSV {
	// Définition d'une Ligne
	public record Achat(String prenom, String nom, double montant) {
	};

	public static void main(String[] args) {
		File file = new File(".\\python\\achats.txt");
		// liste d'achat
		List<Achat> liste = new ArrayList<>();
		try (Scanner scan = new Scanner(file, "utf8")) {
			// lecture des entêtes de colonnes:
			if (scan.hasNext()) {
				for (String txt : scan.nextLine().split(";"))
					System.out.printf("%1$-10s", txt);
				System.out.println("\n-----------------------------");
			}
			while (scan.hasNext()) {
				// charge une ligne, splitée en mots
				String[] ligne = scan.nextLine().split(";");
				liste.add(new Achat(ligne[0], // charge le prenom
						ligne[1], // charge le nom
						Double.parseDouble(ligne[2])// charge le montant
				));
			}
			// affiche la liste
			liste.forEach(a -> {
				System.out.printf("%1$-10s%2$-10s%3$-7.2f", a.prenom, a.nom, a.montant);
				System.out.println();
			});
			// System.out.println(liste);
		} catch (FileNotFoundException e) {
			System.err.println("Fichier introuvable: " + e.getLocalizedMessage());
		}

	}

}
