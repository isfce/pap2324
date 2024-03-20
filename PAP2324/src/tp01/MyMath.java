package tp01;

/**
 * 
 * @author Didier VO
 *
 */
public class MyMath {

	/**
	 * Vérifie si le nombre est pair
	 * 
	 * @param n entier >=0
	 * @return true si pair
	 */
	public static boolean estPair(int n) {
		assert n >= 0 : "n doit être un entier >=0";
		return n % 2 == 0;
	}

	/**
	 * Calcul le nombre de bits à 1 dans n
	 * 
	 * @param n
	 * @return nombre de bits à 1
	 */
	public static int nbBitsV1(int n) {
		int cpt = 0;
		int masque = 1;
		for (int i = 1; i <= 32; i++) {
			if ((n & masque) == masque)// on a un bit à 1?
				cpt++;
			// ajuste mon masque d'une pos vers la gauche
			masque = masque << 1;
		}
		return cpt;
	}

	/**
	 * Calcul le nombre de bits à 1 dans n
	 * 
	 * @param n
	 * @return nombre de bits à 1
	 */
	public static int nbBitsV2(int n) {
		int cpt = 0;
		int masque = 1;
		int masque2 = -1;// 0xFFFFFFFF;
		while ((n & masque2) != 0) {
			if ((n & masque) == masque)// on a un bit à 1?
				cpt++;
			// ajuste mon masque d'une pos vers la gauche
			masque = masque << 1;
			masque2 = masque2 << 1;
		}
		return cpt;
	}

	/**
	 * Recherche la position du dernier bit à 1
	 * 
	 * @param n entier 32 bits
	 * @return positon 0..31 sinon -1
	 */
	public static int posBit1(int n) {
		if (n == 0)
			return -1;
		int pos = 31;
		int masque = 1 << 31;
		while ((n & masque) == 0) {
			masque = masque >>> 1;
			pos--;
		}
		return pos;
	}

	/**
	 * Calcul x^y de manière récursive
	 * @param x réel
	 * @param y entier peut être négatif
	 * @return
	 */
	public static double power(double x, int y) {
		assert !(x == 0 && y <= 0) : "x==0 et y<=0 pas accepté";
		if (y == 0)
			return 1.0;
		if (y == 1 || x == 0 || x == 1)
			return x;
		if (y == -1)
			return 1 / x;
		double res = power(x, y / 2);
		res = res * res;
		if (y % 2 != 0)
			res = res * (y > 0 ? x : 1 / x);
		return res;
	}

	/**
	 * Déplacement des disques (Tour de Hanoï)
	 * @param n nombre de diques à déplacer
	 * @param d 0..2  code du piquet de départ
	 * @param a 0..2  code du piquet d'arrivée
	 */
	public static void deplacer(int n, int d, int a) {
		if (n == 1)
			System.out.println("deplacer le disque de " + d + " vers " + a);
		else {
			int i = 3 - d - a;
			deplacer(n - 1, d, i);
			deplacer(1, d, a);
			deplacer(n - 1, i, a);
		}
	}

	/**
	 * Factorielle appels recursifs
	 * @param 0<=n<=20 
	 * @return
	 */
	public static long fact(byte n) {
		if (n <= 1)// condition d'arrêt
			return 1;
		// appel recursif fact(n-1)
		return n * fact((byte) (n - 1));
	}

	public static void main(String[] args) {
		deplacer(5, 0, 2);
	}
}
