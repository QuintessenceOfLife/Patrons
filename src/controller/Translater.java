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
* Nom du fichier: Translater.java
* Date cree: 2017-03-23
*******************************************************/

package controller;

/*****************************************************************************
 * Translation d'un photo dans une perspective
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public class Translater extends Commande {

	/*****************************
	 * VARIABLES
	 *****************************/
	private int numPerspective;
	private int deltaX;
	private int deltaY;
	
	/**
	 * 
	 * @param numPerspective Numero de perspective
	 * @param curseurX position du curseur en X
	 * @param curseurY position du curseur en Y
	 * @param dragStartX position du curseur en X après le drag
	 * @param dragStartY position du curseur en Y après le drag
	 */
	public Translater(int numPerspective, int curseurX, int curseurY, int dragStartX, int dragStartY) {
		this.numPerspective = numPerspective;
		this.deltaX = curseurX - dragStartX;
		this.deltaY = curseurY - dragStartY;
	}
	
	/**
	 * @return deltaX DeltaX
	 */
	public int getDeltaX() {
		return deltaX;
	}

	/**
	 * @return deltaY DeltaY
	 */
	public int getDeltaY() {
		return deltaY;
	}

	/**
	 * Effectue la translation selon le delta
	 */
	@Override
	public void faire() {
		if (numPerspective == 1) 
			perspective1.translater(deltaX, deltaY);
		else if (numPerspective == 2)
			perspective2.translater(deltaX, deltaY);
	}

}
