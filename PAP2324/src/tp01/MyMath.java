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

	public static void main(String[] args) {
		System.out.println(MyMath.nbBitsV2(-1));
	}
}
