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
* Nom du fichier: Commande.java
* Date cree: 2017-03-23
*******************************************************/

package controller;
import model.Photo;
import model.Perspective;

/***************************************************************************************
 * Classe abstraite qui contient les variables et la methode que doit contenir
 * toute classe qui l'herite.
 * Toute commande peut faire une action et a acces a la photo et des deux perspectives.
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 ***************************************************************************************/
public abstract class Commande {

	/*****************************
	 * VARIABLES
	 *****************************/
	protected static Photo photo = Photo.getInstance();
	protected static Perspective perspective1 = Perspective.getPerspective1();
	protected static Perspective perspective2 = Perspective.getPerspective2();
		
	/*******************************************************************************************
	 * Appeler la méthode appropriée du récepteur de cette commande, dans le but de la réaliser.
	 *******************************************************************************************/
	public abstract void faire();
}
