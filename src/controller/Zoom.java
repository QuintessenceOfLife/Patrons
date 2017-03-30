package controller;

public class Zoom extends Commande {

	private int numPerspective;
	private int curseurX, curseurY, notches;
	
	/**
	 * Constructeur
	 * @param numPerspective indique le récepteur de cette commande. 1 pour la perspective1, 2 pour la perspective2. 
	 * @param deltaX1 variation de l'abscisse du point du haut à gauche de l'image.
	 * @param deltaY1 variation de l'ordonnée du point du haut à gauche de l'image.
	 * @param deltaX2 variation de l'abscisse du point du bas à droite de l'image.
	 * @param deltaY2 variation de l'ordonnée du point bas à droite de l'image.
	 */
	public Zoom(int numPerspective, int curseurX, int curseurY, int notches) {
		this.numPerspective = numPerspective;
		this.curseurX = curseurX;
		this.curseurY = curseurY;
		this.notches = notches;
		gestionnaire.executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		boolean returnValue = true;
		if (numPerspective == 1) 
			perspective1.zoom(curseurX, curseurY, notches);
		else if (numPerspective == 2)
			perspective2.zoom(curseurX, curseurY, notches);
		else 
			returnValue = false;
		return returnValue;
	}

	@Override
	public void defaire() {
		if (numPerspective == 1)
			perspective1.zoom(-1*curseurX, -1*curseurY, -1*notches);
		else if (numPerspective == 2)
			perspective2.zoom(-1*curseurX, -1*curseurY, -1*notches);
	}

}
