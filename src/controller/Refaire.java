package controller;

public class Refaire extends Commande implements IRefaire {

	@Override
	public boolean faire() {
		//Ne pas appeler cette méthode!
        throw new NoSuchMethodError();
	}

	@Override
	public void defaire() {
		//Ne pas appeler cette méthode!
        throw new NoSuchMethodError();
	}

}
