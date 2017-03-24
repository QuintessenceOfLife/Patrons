package controller;

public class Defaire extends Commande implements IDefaire {

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
