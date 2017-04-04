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
* Nom du fichier: Zoom.java
* Date cree: 2017-03-23
*******************************************************/

package controller;

/*****************************************************************************
 * Zoom sur une photo dans la bonne perspective
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public class Zoom extends Commande {

	/*****************************
	 * VARIABLES
	 *****************************/
	private int numPerspective;
	private double sx1, sy1, sx2, sy2; //source coordinates
	private double dx1, dy1, dx2, dy2; //destination coordinates
		
	/**
	 * Constructeur
	 * @param numPerspective Numero de perspective
	 * @param sx1 Coordonnée x1 de la source
	 * @param sy1 Coordonnée y1 de la source
	 * @param sx2 Coordonnée x2 de la source
	 * @param sy2 Coordonnée y2 de la source
	 * @param dx1 Coordonnée x1 de la destination
	 * @param dy1 Coordonnée y1 de la destination
	 * @param dx2 Coordonnée x2 de la destination
	 * @param dy2 Coordonnée y2 de la destination
	 */
	public Zoom(int numPerspective, double sx1, double sy1, double sx2, double sy2, 
			double dx1, double dy1, double dx2, double dy2) {
		this.numPerspective = numPerspective;
		this.sx1 = sx1;
		this.sy1 = sy1;
		this.sx2 = sx2;
		this.sy2 = sy2;
		this.dx1 = dx1;
		this.dy1 = dy1;
		this.dx2 = dx2;
		this.dy2 = dy2;
	}
	
	/*****************************
	 * ACCESSEURS
	 *****************************/
	/**
	 * @return sx1 Coordonnée de source x1
	 */
	public double getSX1() {
		return sx1;
	}

	/**
	 * @return sx1 Coordonnée de source y1
	 */
	public double getSY1() {
		return sy1;
	}

	/**
	 * @return sx1 Coordonnée de source x2
	 */
	public double getSX2() {
		return sx2;
	}

	/**
	 * @return sx1 Coordonnée de source y2
	 */
	public double getSY2() {
		return sy2;
	}

	/**
	 * Effectue le zoom selon les coordonnées de destination
	 */
	@Override
	public void faire() {
		if (numPerspective == 1) 
			perspective1.setCoordinates(dx1, dy1, dx2, dy2);
		else if (numPerspective == 2)
			perspective2.setCoordinates(dx1, dy1, dx2, dy2);
	}

}
