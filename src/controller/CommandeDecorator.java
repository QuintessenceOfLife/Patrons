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
* Nom du fichier: CommandeDecorator.java
* Date cree: 2017-03-23
*******************************************************/

package controller;

/*****************************************************************************
 * Classe abstraite qui permet l'ajout de methodes et de variables que
 * necessiterait une commande.
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public abstract class CommandeDecorator extends Commande {
	
	/*****************************
	 * VARIABLES
	 *****************************/
	private Commande command;

	/*****************************
	 * CONSTRUCTEUR
	 * @param command Commande
	 *****************************/
	public CommandeDecorator(Commande command) {
		this.command = command;
	}
	
	/***************************************************************************
	 * La commande qui recoit le decorateur va encore avoir la methode faire()
	 ***************************************************************************/
	@Override
	public void faire() {
		command.faire();
	}
	
}
