package controller;

public class Zoom extends Commande {

	private int numPerspective;
	private int wheelX, wheelY, notches;
	
	/**
	 * Constructeur
	 * @param numPerspective indique le récepteur de cette commande. 1 pour la perspective1, 2 pour la perspective2. 
	 * @param deltaX1 variation de l'abscisse du point du haut à gauche de l'image.
	 * @param deltaY1 variation de l'ordonnée du point du haut à gauche de l'image.
	 * @param deltaX2 variation de l'abscisse du point du bas à droite de l'image.
	 * @param deltaY2 variation de l'ordonnée du point bas à droite de l'image.
	 */
	public Zoom(int numPerspective, int wheelX, int wheelY, int notches) {
		this.numPerspective = numPerspective;
		this.wheelX = wheelX;
		this.wheelY = wheelY;
		this.notches = notches;
		gestionnaire.executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		boolean returnValue = true;
		if (numPerspective == 1) 
			perspective1.zoom(wheelX, wheelY, notches);
		else if (numPerspective == 2)
			perspective2.zoom(wheelX, wheelY, notches);
		else 
			returnValue = false;
		return returnValue;
	}

	@Override
	public void defaire() {
		if (numPerspective == 1)
			perspective1.zoom(-1*wheelX, -1*wheelY, -1*notches);
		else if (numPerspective == 2)
			perspective2.zoom(-1*wheelX, -1*wheelY, -1*notches);
	}

}
