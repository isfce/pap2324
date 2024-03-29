package util;

public interface IStack<T> {

	/**
	 * Ajoute l'élément au sommet du stack
	 * 
	 * @param elem
	 */

	void push(T elem);

	/**
	* Ajoute l'élément au fond du stack
	* 
	* @param elem
	*/

	void pushBottom(T elem);

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