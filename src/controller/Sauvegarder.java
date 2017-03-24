package controller;

public class Sauvegarder extends Commande implements ISauvegarder {

	//TODO ajouter le constructeur et les attributs
	
	@Override
	public boolean faire() {
		// TODO Auto-generated method stub
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
