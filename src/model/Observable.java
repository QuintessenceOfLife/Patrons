package model;

public interface Observable {
	
	/**
	 * Notifier l'observateur du changement d'état de cet objet.
	 */
	void notifier();
	
}
