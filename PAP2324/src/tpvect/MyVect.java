package tpvect;

import java.util.Arrays;

import util.IStack;
import util.StackArray;

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
	 * Permet de trier le vecteur dans un intervalle 
	 * @param v
	 * @param a
	 * @param b
	 */
	public static void triInsertion(int[] v, int a, int b) {
		for (int i = a + 1; i <= b; i++) {
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
					posInv = i - 1;
					// swap
					int tmp = v[i];
					v[i] = v[i + 1];
					v[i + 1] = tmp;
				}
		} while (inversion);
	}

	// Tri quicksort V1
	/**
	 * Positionne le pivot dans la zone a,b du vecteur v
	 * @param v
	 * @param a
	 * @param b
	 * @return
	 */
	public static int posPivot(int[] v, int a, int b) {
		int tmp;
		int i = a;
		int j = b - 1;
		int pivot = v[b];
		while (i <= j) {
			while (v[i] < pivot)
				i++;
			while (j >= 0 && v[j] >= pivot)
				j--;
			if (i < j) {// swap v[i]<->v[j]
				tmp = v[i];
				v[i] = v[j];
				v[j] = tmp;
			}
		}
		// swap pour mettre le pivot à sa place v[i]<->v[b]
		v[b] = v[i];
		v[i] = pivot;

		return i;
	}

	/**
	 * 
	 */
	private record Borne(int a, int b) {
	};

	/**
	 * Tri quicksort
	 * @param v
	 */
	public static void quickSort(int[] v) {
		if (v.length < 200) {
			triInsertion(v);
			return;
		}
		Borne borne;
		int p;
		int max = (int) ((Math.log(v.length) / Math.log(2)) * 2);
		IStack<Borne> s = new StackArray<>(max);
		s.push(new Borne(0, v.length - 1));
		do {
			borne = s.pop();
			p = posPivot(v, borne.a, borne.b);
			if (p - borne.a > 1)
				if (p - borne.a > 10)
					s.push(new Borne(borne.a, p - 1));
				else
					triInsertion(v, borne.a, p - 1);
			if (borne.b - p > 1)
				if (borne.b - p > 10)
					s.push(new Borne(p + 1, borne.b));
				else
					triInsertion(v, p + 1, borne.b);
		} while (!s.empty());
		s = null;
	}

	/**
	 * Correction  Rotation de R positions version VO
	 * @param v un vecteur de taille >0
	 * @param r un entier positif ou négatif
	 */
	public static void rotationVR(int[] v, int r) {
		int n = v.length;
		r = r % n;// ajuste r pour que r soit tel que: -n<r<n
		r = (n + r) % n; // assure r soit positif
		if (r != 0) {// si on doit fair des décalages
			int act = 0, prec = 0;// indice de parcours pour la boucle
			int tmp;
			int nbElemBoucle = n % r == 0 ? n / r : n;
			int nbBoucles = n % r == 0 ? r : 1;
			for (int i = 0; i < nbBoucles; i++) {
				tmp = v[act];// libère une case qu'on mémorise ds tmp
				// on fait une boucle jsq avant dernier
				for (int j = 1; j < nbElemBoucle; j++) {
					// indice du précédent
					prec = (n + act - r) % n;
					v[act] = v[prec];
					act = prec;
				}
				// on est sur la dernière case de la boucle
				v[act] = tmp; // recopie le tampon
				act--;// se positionne pour la boucle suivante
			}
		}
	}

	public static void main(String[] args) {
		int[] v = new int[100000];
		for (int i = 0; i < v.length; i++)
			v[i] = (int) (Math.random() * v.length);
		afficheV(v);
		long t0 = System.nanoTime();
		quickSort(v);
		// triInsertion(v);
		// triBulles(v);
		Arrays.sort(v);
		long t1 = System.nanoTime();
		System.out.println("Durée ms: " + (t1 - t0) / 1000000.0);
		// afficheV(v);
	}
}
