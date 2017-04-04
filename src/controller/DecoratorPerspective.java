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
* Nom du fichier: DecoratorPerspective.java
* Date cree: 2017-03-23
*******************************************************/

package controller;

/*****************************************************************************
 * Classe abstraite qui permet l'ajout de la méthode défaire et qui a besoin
 * du gestionnaire de commande.
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public abstract class DecoratorPerspective extends CommandeDecorator {

	/*****************************
	 * CONSTRUCTEUR
	 * @param command Commande
	 *****************************/
	public DecoratorPerspective(Commande command) {
		super(command);
	}
	
	/***************************************************************************
	 * La commande qui reçoit le décorateur va aussi avoir cette méthode
	 ***************************************************************************/
	public abstract void defaire();
	
}
