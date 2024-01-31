package util;

public class StackListe<T> implements IStack<T> {
	//Maillon pour la chaine
	private class Maillon<K>{
		public final K info;
		public Maillon<K> suiv;
		
		/**
		 * @param info
		 * @param suiv
		 */
		public Maillon(K info, Maillon<K> suiv) {
			this.info = info;
			this.suiv = suiv;
		}
	};

	private Maillon<T> sommet = null;

	@Override
	public void push(T info) {
		sommet = new Maillon<>(info, sommet);
	}

	@Override
	public T pop() {
		assert sommet != null : "Le stack ne peut pas être vide";
		T tmp = sommet.info;
		sommet = sommet.suiv;
		return tmp;
	}

	@Override
	public T top() {
		assert sommet != null : "Le stack ne peut pas être vide";
		return sommet.info;
	}

	@Override
	public boolean empty() {
		return sommet == null;
	}

}
