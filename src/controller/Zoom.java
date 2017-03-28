package controller;

public class Zoom extends Commande {

	private int numPerspective;
	private int deltaX1, deltaY1, deltaX2, deltaY2;
	
	/**
	 * Constructeur
	 * @param numPerspective indique le récepteur de cette commande. 1 pour la perspective1, 2 pour la perspective2. 
	 * @param deltaX1 variation de l'abscisse du point du haut à gauche de l'image.
	 * @param deltaY1 variation de l'ordonnée du point du haut à gauche de l'image.
	 * @param deltaX2 variation de l'abscisse du point du bas à droite de l'image.
	 * @param deltaY2 variation de l'ordonnée du point bas à droite de l'image.
	 */
	public Zoom(int numPerspective, int deltaX1, int deltaY1, int deltaX2, int deltaY2) {
		this.numPerspective = numPerspective;
		this.deltaX1 = deltaX1;
		this.deltaY1 = deltaY1;
		this.deltaX2 = deltaX2;
		this.deltaY2 = deltaY2;
		gestionnaire.executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		boolean returnValue = true;
		if (numPerspective == 1) 
			perspective1.zoom(deltaX1, deltaY1, deltaX2, deltaY2);
		else if (numPerspective == 2)
			perspective2.zoom(deltaX1, deltaY1, deltaX2, deltaY2);
		else 
			returnValue = false;
		return returnValue;
	}

	@Override
	public void defaire() {
		if (numPerspective == 1)
			perspective1.zoom(-1*deltaX1, -1*deltaY1, -1*deltaX2, -1*deltaY2);
		else if (numPerspective == 2)
			perspective2.zoom(-1*deltaX1, -1*deltaY1, -1*deltaX2, -1*deltaY2);
	}

}
