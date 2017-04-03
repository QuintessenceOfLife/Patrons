package controller;

public class Zoom extends Commande {

	private int numPerspective;
	private double sx1, sy1, sx2, sy2; //source coordinates
	private double dx1, dy1, dx2, dy2; //destination coordinates
		
	/**
	 * Constructeur
	 * @param numPerspective indique le récepteur de cette commande. 1 pour la perspective1, 2 pour la perspective2. 
	 * @param deltaX1 variation de l'abscisse du point du haut à gauche de l'image.
	 * @param deltaY1 variation de l'ordonnée du point du haut à gauche de l'image.
	 * @param deltaX2 variation de l'abscisse du point du bas à droite de l'image.
	 * @param deltaY2 variation de l'ordonnée du point bas à droite de l'image.
	 */
	public Zoom(int numPerspective, double sx1, double sy1, double sx2, double sy2, double dx1, double dy1, double dx2, double dy2) {
		this.numPerspective = numPerspective;
		this.sx1 = sx1;
		this.sy1 = sy1;
		this.sx2 = sx2;
		this.sy2 = sy2;
		this.dx1 = dx1;
		this.dy1 = dy1;
		this.dx2 = dx2;
		this.dy2 = dy2;
		System.out.println("create Zoom command with these values:");
		System.out.println("sx1: " + sx1);
		System.out.println("sy1: " + sy1);
		System.out.println("sx2: " + sx2);
		System.out.println("sy2: " + sy2);
		System.out.println("dx1: " + dx1);
		System.out.println("dy1: " + dy1);
		System.out.println("dx2: " + dx2);
		System.out.println("dy2: " + dy2);
	}
	
	public double getSX1() {
		return sx1;
	}

	public double getSY1() {
		return sy1;
	}

	public double getSX2() {
		return sx2;
	}

	public double getSY2() {
		return sy2;
	}

	@Override
	public void faire() {
		if (numPerspective == 1) 
			perspective1.setCoordinates(dx1, dy1, dx2, dy2);
		else if (numPerspective == 2)
			perspective2.setCoordinates(dx1, dy1, dx2, dy2);
	}

}
