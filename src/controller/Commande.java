package controller;

import model.Image;
import model.Perspective;

public abstract class Commande {

	protected final static GestionnaireCmd gestionnaire = GestionnaireCmd.getGestionnaireCmd();
	protected static Image image = Image.getInstance();
	protected static Perspective perspective1 = Perspective.getPerspective1();
	protected static Perspective perspective2 = Perspective.getPerspective2();
	
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
