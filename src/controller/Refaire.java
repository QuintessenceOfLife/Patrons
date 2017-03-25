package controller;

public class Refaire extends Commande implements IRefaire {

	/**
	 * Il est interdit d'appeler cette méthode!
	 * @throws NoSuchMethodError
	 * @return 
	 */
	@Override
	public boolean faire() {
		//Ne pas appeler cette méthode!
        throw new NoSuchMethodError();
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
