package controller;

public class Refaire extends Commande {

	/**
	 * Il est interdit d'appeler cette méthode!
	 * @throws NoSuchMethodError
	 * @return 
	 */
	@Override
	public boolean faire() {
		gestionnaire.refaire();
		return false;
	}

	/**
	 * Il est interdit d'appeler cette méthode!
	 * @throws NoSuchMethodError
	 */
	@Override
	public void defaire() {
		//Ne pas appeler cette méthode!
        throw new NoSuchMethodError();
	}
}
