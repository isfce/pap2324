package util;

/**
 * Stack générique ayant une taille maximum pré-définie 
 * lors de la construction
 * 
 * @param <T>
 */
public class Stack<T> {
	private final int tailleMax;
	private int sommet;
	private T[] v;

	/**
	 * Constructeur 
	 * 
	 * @param tailleMax : taille maximum du stack
	 */
	@SuppressWarnings("unchecked")
	public Stack(int tailleMax) {
		this.tailleMax = tailleMax;
		this.sommet = 0;
		this.v = (T[]) new Object[tailleMax];
	}

	/**
	 * Ajoute l'élément au stack
	 * 
	 * @param elem
	 */
	public void push(T elem) {
		assert sommet < tailleMax : "Le stack est plein";
		v[sommet] = elem;
		sommet++;
	}

	/**
	 * supprime l'élément au sommet du stack et le renvoie
	 * 
	 * @return l'élément au sommet du stack
	 */
	public T pop() {
		assert sommet > 0 : "Le stack est vide";
		sommet--;
		T tmp = v[sommet];
		v[sommet] = null;// efface l'adresse
		return tmp;
	}

	/**
	 * retourne l'élément au sommet du stack
	 * 
	 * @return l'élément au sommet du stack
	 */
	public T top() {
		assert sommet > 0 : "Le stack est vide";
		return v[sommet - 1];
	}

	/**
	 * Indique si le stack est vide
	 * 
	 * @return
	 */
	public boolean empty() {
		return sommet == 0;
	}

	@Override
	public String toString() {
		return "Stack [tailleMax=" + tailleMax + ", nbElem=" + sommet + "]";
	}

}
