package model;

import java.util.Observable;
import java.util.Observer;

public class Perspective extends Observable {
	
	private int x1, y1, x2, y2;
	//TODO add image
	private Observer obs; //TODO need a collection of observers?
	
	//TODO add a constructor with an Observer in an argument? or add a setObserver() instead?	
	
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
		setChanged();
		notifyObservers();
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
		setChanged();
		notifyObservers();		
	}
	
	@Override
	public void notifyObservers() {
		obs.update(this, "zoom");  //TODO remove these args if not needed
	}
}