package controller;
import model.Perspective;

public class Zoom extends Commande {

	private Perspective perspective;
	private int deltaX1, deltaY1, deltaX2, deltaY2;
	
	/**
	 * Constructeur
	 * @param perspective est le récepteur de cette commande. 
	 * @param deltaX1 variation de l'abscisse du point du haut à gauche de l'image.
	 * @param deltaY1 variation de l'ordonnée du point du haut à gauche de l'image.
	 * @param deltaX2 variation de l'abscisse du point du bas à droite de l'image.
	 * @param deltaY2 variation de l'ordonnée du point bas à droite de l'image.
	 */
	public Zoom(Perspective perspective, int deltaX1, int deltaY1, int deltaX2, int deltaY2) {
		this.perspective = perspective;
		this.deltaX1 = deltaX1;
		this.deltaY1 = deltaY1;
		this.deltaX2 = deltaX2;
		this.deltaY2 = deltaY2;
		gestionnaire.executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		// TODO Auto-generated method stub
		//perspective.
		return false;
	}

	@Override
	public void defaire() {
		// TODO Auto-generated method stub
	}

}
