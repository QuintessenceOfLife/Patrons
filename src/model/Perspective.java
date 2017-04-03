package model;

import java.io.Serializable;

public class Perspective implements Observable, Serializable {

	private static final long serialVersionUID = 6291767085117089711L;
	public static final double FACTEUR_ZOOM = 0.1;
	private static Perspective perspective1 = new Perspective();
	private static Perspective perspective2 = new Perspective();
	private double x1, y1, x2, y2;	
	private Observateur observateur;

	private Perspective() { }

	public static Perspective getPerspective1() {
		return perspective1;
	}

	public static Perspective getPerspective2() {
		return perspective2;
	}

	public double getX1() {
		return x1;
	}

	public double getY1() {
		return y1;
	}

	public double getX2() {
		return x2;
	}

	public double getY2() {
		return y2;
	}

	/**
	 * Fixer les coordonnées.
	 * @param x1 abscisse du point du haut à gauche 
	 * @param y1 ordonnée du point du haut à gauche
	 * @param x2 abscisse du point du bas à droite 
	 * @param y2 ordonnée du point du bas à droite
	 */
	public void setCoordinates(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		notifier();
		System.out.println("setCoordinates");
		displayCoordinates();
	}
	
	public void setObservateur(Observateur obs) {
		this.observateur = obs;
	}

	/**
	 * Effectuer la translation.
	 * @param deltaX variation des abscisses
	 * @param deltaY variation des ordonnées 
	 */
	public void translater(int deltaX, int deltaY) {
		x1 += deltaX;
		y1 += deltaY;
		x2 += deltaX;
		y2 += deltaY;
		notifier();
		System.out.println("translater");
		displayCoordinates();
	}

	public void notifier() {		
		observateur.update();
	}
	
	private void displayCoordinates() {
		System.out.println("x1: " + x1);
		System.out.println("y1: " + y1);
		System.out.println("x2: " + x2);
		System.out.println("y2: " + y2);
		System.out.println("------------------------------------------------");
	}
	
}