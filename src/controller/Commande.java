package controller;

public abstract class Commande {

	protected final static GestionnaireCmd gestionnaire = GestionnaireCmd.getGestionnaireCmd();
    
	//TODO review and adapt this comment to Sauvegarder and Récupérer
	/**
	 * Appeler la méthode appropriée du récepteur de cette commande, dans le but de la réaliser.
	 * @return true pour permettre de défaire cette commande, false sinon.
	 */
	public abstract boolean faire();
	
	/**
	 * Appeler la méthode appropriée du récepteur de cette commande, dans le but de la défaire.
	 */
	public abstract void defaire();
}
