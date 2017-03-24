package controller;

public class Ouvrir extends Commande {

	//TODO add constructor and attributes
	
	@Override
	public boolean faire() {
		// TODO Auto-generated method stub
		
		//Doit toujours retourner false!
		return false;
	}

	@Override
	public void defaire() {
		//Ne pas appeler cette méthode!
        throw new NoSuchMethodError();
	}

}
