package controller;

public abstract class Commande {

	protected final static GestionnaireCmd gestionnaire = GestionnaireCmd.getGestionnaireCmd();
    
	public abstract boolean faire();
	public abstract void defaire();
}
