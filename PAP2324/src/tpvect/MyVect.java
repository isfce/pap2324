package tpvect;

import java.util.Arrays;

public class MyVect {
	/**
	 * Affiche un vecteur [1,2]
	 * 
	 * @param v
	 */
	public static void afficheV(int[] v) {
		System.out.print("[");
		for (int i = 0; i < v.length - 1; i++)
			System.out.print(v[i] + ",");
		if (v.length > 0)
			System.out.print(v[v.length - 1]);
		System.out.println("]");
	}

	/**
	 * Calcule la somme des éléments du vecteur for each
	 * 
	 * @param v
	 * @return
	 */
	public static long sommeV(int[] v) {
		long s = 0;
		for (int elem : v)
			s = s + elem;
		return s;
	}

	/**
	 * Calcule la somme des éléments du vecteur for i
	 * 
	 * @param v
	 * @return
	 */
	public static long sommeV2(int[] v) {
		long s = 0;
		for (int i = 0; i < v.length; i++)
			s = s + v[i];
		return s;
	}

	/**
	 * Retourne l'élément maximum du vecteur
	 * 
	 * @param v vecteur d'entier. Taille>0
	 * @return maximum
	 */
	public static int maxElemV(int[] v) {
		assert v.length > 0 : "Le vecteur doit avoir au moins un élément";
		int maxi = v[0];
		for (int i = 1; i < v.length; i++)
			if (v[i] > maxi)
				maxi = v[i];
		return maxi;
	}

	/**
	 * Retourne la moyenne des éléments du vecteur
	 * 
	 * @param v vecteur d'entier. Taille>0
	 * @return moyenne
	 */
	public static double avgElemV(int[] v) {
		assert v.length > 0 : "Le vecteur doit avoir au moins un élément";
		return (double) sommeV(v) / v.length;
	}

	/**
	 * retourne le min max du vecteur
	 * 
	 * @param v
	 * @return [min,max]
	 */
	public static int[] minMaxElemV(int[] v) {
		assert v.length > 0 : "Le vecteur doit avoir au moins un élément";
		// int[] res=new int[2];
		// res[0]=v[0]; res[1]=v[0];
		int[] res = { v[0], v[0] };// vecteur résultat [min,max]
		for (int i = 1; i < v.length; i++)
			if (v[i] < res[0])
				res[0] = v[i];
			else if (v[i] > res[1])
				res[1] = v[i];
		return res;
	}

	/**
	 * Clonage d'un vecteur
	 * 
	 * @param v
	 * @return
	 */
	public static int[] cloneV(int[] v) {
		int[] clone = new int[v.length];
		for (int i = 0; i < v.length; i++)
			clone[i] = v[i];
		return clone;
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public static boolean estTrieV1(int[] v) {
		assert v.length > 0 : "Le vecteur doit avoir au moins un élément";
		int i = 0;
		boolean trie = true;
		int limite = v.length - 1;
		while (i < limite && trie) {
			trie = v[i] <= v[i + 1];
			i++;
		}
		return trie;
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public static boolean estTrieV2(int[] v) {
		assert v.length > 0 : "Le vecteur doit avoir au moins un élément";
		int i = 0;
		int limite = v.length - 1;
		while (i < limite && v[i] <= v[i + 1])
			i++;

		return i == limite;
	}

	/**
	 * Indique si un mot existe dans le texte
	 * 
	 * @param texte
	 * @param mot   doit contenir au moins un caractère
	 * @return boolean trouvé
	 */
	public static boolean existeMot(char[] texte, char[] mot) {
		assert mot.length > 0 : "Le mot ne peut pas être vide";
		int i = 0;
		boolean trouve = false;
		int limite = texte.length - mot.length;
		while (limite >= i && !trouve) {
			// recherche la première lettre du mot dans texte
			while (limite >= i && texte[i] != mot[0])
				i++;
			if (limite >= i) {
				int k = 1;
				int j = i + 1;
				// vérifie les autres lettres du mot
				while (k < mot.length && texte[j] == mot[k]) {
					j++;
					k++;
				}
				trouve = k == mot.length;
				i++;
			}
		}
		return trouve;
	}

	/**
	 * Tri par insertion
	 * 
	 * @param v
	 */
	public static void triInsertion(int[] v) {
		for (int i = 1; i < v.length; i++) {
			int tmp = v[i];
			int j = i - 1;
			// cherche la position d'insertion
			while (j >= 0 && v[j] > tmp) {
				v[j + 1] = v[j]; // décale les éléments plus grands
				j--;
			}
			v[j + 1] = tmp;// insère tmp à sa bonne place
		}
	}

	/**
	 * Tri Bulles
	 * 
	 * @param v
	 */
	public static void triBulles(int[] v) {
		int posInv = v.length - 2;
		boolean inversion;
		do {
			int fin = posInv;
			inversion = false;
			for (int i = 0; i <= fin; i++)
				if (v[i] > v[i + 1]) {
					inversion = true;
					posInv = i-1;
					// swap
					int tmp = v[i];
					v[i] = v[i + 1];
					v[i + 1] = tmp;
				}
		} while (inversion);
	}

	public static void main(String[] args) {
		int[] v = new int[100];
		for (int i = 0; i < v.length; i++)
			v[i] = 100 - i;

		long t0 = System.nanoTime();
		//triInsertion(v);
		//triBulles(v);
		Arrays.sort(v);
		long t1 = System.nanoTime();
		System.out.println("Durée ms: " + (t1 - t0) / 1000000.0);
	}
}
