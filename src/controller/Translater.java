package controller;

public class Translater extends Commande {

	private int numPerspective;
	private int deltaX;
	private int deltaY;
	
	/**
	 * Constructeur
	 * @param numPerspective indique le récepteur de cette commande. 1 pour la perspective1, 2 pour la perspective2. 
	 * @param deltaX variation des abscisses.
	 * @param deltaY variation des ordonnées.
	 */ 
	public Translater(int numPerspective, int deltaX, int deltaY) {
		this.numPerspective = numPerspective;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		gestionnaire.executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		boolean returnValue = true;
		if (numPerspective == 1) 
			perspective1.translater(deltaX, deltaY);
		else if (numPerspective == 2)
			perspective2.translater(deltaX, deltaY);
		else 
			returnValue = false;
		return returnValue;		
	}

	@Override
	public void defaire() {
		if (numPerspective == 1)
			perspective1.translater(-1*deltaX, -1*deltaY);
		else if (numPerspective == 2)
			perspective2.translater(-1*deltaX, -1*deltaY);
	}

}
