package controller;

public class Translater extends Commande {

	private int numPerspective;
	private int deltaX;
	private int deltaY;
	
	/**
	 * Constructeur
	 * @param numPerspective indique le récepteur de cette commande. 1 pour la perspective1, 2 pour la perspective2. 
	 * @param curseurX variation des abscisses.
	 * @param curseurY variation des ordonnées.
	 */ 
	public Translater(int numPerspective, int curseurX, int curseurY, int dragStartX, int dragStartY) {
		this.numPerspective = numPerspective;
		this.deltaX = curseurX - dragStartX;;
		this.deltaY = curseurY - dragStartY;;
	}
	
	@Override
	public void faire() {
		if (numPerspective == 1) 
			perspective1.translater(deltaX, deltaY);
		else if (numPerspective == 2)
			perspective2.translater(deltaX, deltaY);
	}

	@Override
	public void defaire() {
		if (numPerspective == 1)
			perspective1.translater(-1*deltaX, -1*deltaY);
		else if (numPerspective == 2)
			perspective2.translater(-1*deltaX, -1*deltaY);
	}

}
