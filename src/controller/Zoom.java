package controller;
import model.Perspective;

public class Zoom extends Commande {

	private int deltaX1;
	private int deltaY1;
	private int deltaX2;
	private int deltaY2;
	
	public Zoom(Perspective perspective, int x1, int y1, int x2, int y2) {
		// Appelle le gestionnaire de commande pour executer this.
		GestionnaireCmd.getGestionnaireCmd().executerCommande(this);
	}
	
	@Override
	public boolean faire() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void defaire() {
		// TODO Auto-generated method stub
	}

}
