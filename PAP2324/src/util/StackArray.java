package util;

/**
 * Stack générique ayant une taille maximum pré-définie 
 * lors de la construction
 * 
 * @param <T>
 */
public class StackArray<T> implements IStack<T> {
	private final int tailleMax;
	private int sommet;
	private T[] v;

	/**
	 * Constructeur 
	 * 
	 * @param tailleMax : taille maximum du stack
	 */
	@SuppressWarnings("unchecked")
	public StackArray(int tailleMax) {
		this.tailleMax = tailleMax;
		this.sommet = 0;
		this.v = (T[]) new Object[tailleMax];
	}

	/**
	 * Ajoute l'élément au stack
	 * 
	 * @param elem
	 */
	@Override
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
	@Override
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
	@Override
	public T top() {
		assert sommet > 0 : "Le stack est vide";
		return v[sommet - 1];
	}

	/**
	 * Indique si le stack est vide
	 * 
	 * @return
	 */
	@Override
	public boolean empty() {
		return sommet == 0;
	}

	@Override
	public String toString() {
		return "Stack [tailleMax=" + tailleMax + ", nbElem=" + sommet + "]";
	}

	@Override
	public void pushBottom(T elem) {
		assert sommet < tailleMax : "Le stack est plein";
		for (int i = sommet; i > 0; i--)
			v[i] = v[i - 1];
		v[0] = elem;
		sommet++;
	}

}
