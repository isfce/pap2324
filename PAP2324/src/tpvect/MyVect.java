package tpvect;

public class MyVect {

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

	public static void main(String[] args) {
		int[] v0 = {};
		MyVect.afficheV(v0);
		int[] v1 = { 0, 1, 1, 2, 3, 5, 8, 13, 21 };
		MyVect.afficheV(v1);
		System.out.println(MyVect.sommeV(v1));
	}
}
