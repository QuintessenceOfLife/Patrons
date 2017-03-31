package controller;

public class Defaire extends Commande {

	/**
	 * Il est interdit d'appeler cette méthode!
	 * @throws NoSuchMethodError
	 * @return 
	 */
	@Override
	public void faire() {
		gestionnaire.defaire();
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

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}
