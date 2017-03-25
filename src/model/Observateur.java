package model;

public interface Observateur {
	
	/**
	 * Mettre à jour la vue, suite à un changement de l'état du modèle observé.
	 */
	void update(); 

}
