package controller;

public class Defaire extends Commande implements IDefaire {

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
