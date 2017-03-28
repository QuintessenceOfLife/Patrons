package model;

import java.io.File;
import java.io.Serializable;

public class Perspective implements Observable, Serializable {
	
	private static final long serialVersionUID = 6291767085117089711L;
	private static Perspective perspective1 = new Perspective();
	private static Perspective perspective2 = new Perspective();
	private int x1, y1, x2, y2;	
	private Observateur observateur;
	
	private Perspective() { }
	
	public static Perspective getPerspective1() {
		return perspective1;
	}

	public static Perspective getPerspective2() {
		return perspective2;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}
	
	/**
	 * Fixer les coordonnées.
	 * @param x1 abscisse du point du haut à gauche 
	 * @param y1 ordonnée du point du haut à gauche
	 * @param x2 abscisse du point du bas à droite 
	 * @param y2 ordonnée du point du bas à droite
	 */
	public void setCoordinates(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		notifier();
	}
	
	public void setObservateur(Observateur obs) {
		this.observateur = obs;
	}
	
	
	/**
	 * Effectuer le zoom.
	 * @param deltaX1 variation de l'abscisse du point du haut à gauche de l'image.
	 * @param deltaY1 variation de l'ordonnée du point du haut à gauche de l'image.
	 * @param deltaX2 variation de l'abscisse du point du bas à droite de l'image.
	 * @param deltaY2 variation de l'ordonnée du point bas à droite de l'image.
	 */
	public void zoom(int deltaX1, int deltaY1, int deltaX2, int deltaY2) {
		x1 += deltaX1;
		y1 += deltaY1;
		x2 += deltaX2;
		y2 += deltaY2;	
		notifier();
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
	}
	
	public void notifier() {		
		observateur.update();
	}
}