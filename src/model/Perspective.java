/******************************************************
* Cours:   LOG121
* Session: H2017
* Groupe:  03
* Projet: Laboratoire #4
* Etudiant(e)s: Youssef Soliman
				Yassine Abdellaoui
				Raph Jobin
				Victor Trinh
* Professeur : 	Vincent Lacasse
* Charge : 		Patrice Boucher
* Nom du fichier: Perspective.java
* Date cree: 2017-03-23
*******************************************************/

package model;

import java.io.Serializable;

/*****************************************************************************
 * Modèle pour la perspective. 
 * Contient les coordonées des perspectives. Notifie les observateurs
 * lorsqu'il y a un changement. 
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public class Perspective implements Observable, Serializable {

	/*****************************
	 * VARIABLES
	 *****************************/
	private static final long serialVersionUID = 6291767085117089711L;
	private static Perspective perspective1 = new Perspective();
	private static Perspective perspective2 = new Perspective();
	private double x1, y1, x2, y2;	
	private Observateur observateur;

	/*****************************
	 * CONSTRUCTEUR
	 *****************************/
	private Perspective() { }

	/*****************************
	 * ACCESSEURS
	 *****************************/
	/**
	 * @return perspective1 La perspective 1
	 */
	public static Perspective getPerspective1() {
		return perspective1;
	}

	/**
	 * @return perspective2 La perspective 2
	 */
	public static Perspective getPerspective2() {
		return perspective2;
	}

	/**
	 * @return x1 La coordonnée en haut à gauche 
	 */
	public double getX1() {
		return x1;
	}

	/**
	 * @return y1 La coordonnée en bas à gauche 
	 */
	public double getY1() {
		return y1;
	}

	/**
	 * @return x2 La coordonnée en haut à droite
	 */
	public double getX2() {
		return x2;
	}

	/**
	 * @return y2 La coordonnée en bas à droite
	 */
	public double getY2() {
		return y2;
	}

	/*****************************
	 * SETTERS
	 *****************************/
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
	}
	
	/**
	 * Ajout de l'observateur
	 * @param obs Observateur
	 */
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
	}

	/**
	 * Notifie les observateur du changement
	 */
	public void notifier() {		
		observateur.update();
	}	
}