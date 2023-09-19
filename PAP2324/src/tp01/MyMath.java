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

	public static void main(String[] args) {

	}
}
