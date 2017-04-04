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
* Nom du fichier: Observateur.java
* Date cree: 2017-03-23
*******************************************************/

package model;

/*****************************************************************************
 * Interface qui contient la methode que doit contenir toute classe qui l'herite.
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public interface Observateur {
	
	/**
	 * Mettre à jour la vue, suite à un changement de l'état du modèle observé.
	 */
	void update(); 

}
