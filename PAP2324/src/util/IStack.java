package util;

public interface IStack<T> {

	/**
	 * Ajoute l'élément au stack
	 * 
	 * @param elem
	 */
	void push(T elem);

	/**
	 * supprime l'élément au sommet du stack et le renvoie
	 * 
	 * @return l'élément au sommet du stack
	 */
	T pop();

	/**
	 * retourne l'élément au sommet du stack
	 * 
	 * @return l'élément au sommet du stack
	 */
	T top();

	/**
	 * Indique si le stack est vide
	 * 
	 * @return
	 */
	boolean empty();

}