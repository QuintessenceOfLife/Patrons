package controller;
import model.Perspective;

public class Translater extends Commande {

	private Perspective perspective;
	private int deltaX;
	private int deltaY;
	
	/**
	 * Constructeur
	 * @param perspective est le récepteur de cette commande. 
	 * @param deltaX variation des abscisses.
	 * @param deltaY variation des ordonnées.
	 */ 
	public Translater(Perspective perspective, int deltaX, int deltaY) {
		this.perspective = perspective;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		gestionnaire.executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		perspective.translater(deltaX, deltaY);
		return true;
	}

	@Override
	public void defaire() {
		perspective.translater(-1*deltaX, -1*deltaY);
	}

}
