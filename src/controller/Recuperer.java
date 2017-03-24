package controller;

public class Recuperer extends Commande {

	//TODO add constructor and attributes
	
	@Override
	public boolean faire() {
		// TODO Auto-generated method stub
		
		//Doit toujours retourner false!
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
