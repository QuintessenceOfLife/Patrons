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
* Nom du fichier: GestionnaireCmd.java
* Date cree: 2017-03-23
*******************************************************/

package controller;
import java.util.LinkedList;

/*****************************************************************************
 * Gestion des commandes. Ajoute ou enlève les commandes dans les listes appropriées.
 * Permet aussi d'effacer les listes.
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public class GestionnaireCmd {

	/*****************************
	 * VARIABLES
	 *****************************/
	private static GestionnaireCmd gestionnaire = new GestionnaireCmd();
	// Deux listes pour la perspective1
	private LinkedList<CommandeDecorator> doneList1 = new LinkedList<CommandeDecorator>();
	private LinkedList<CommandeDecorator> undoneList1 = new LinkedList<CommandeDecorator>();
	// Deux listes pour la perspective2
	private LinkedList<CommandeDecorator> doneList2 = new LinkedList<CommandeDecorator>();
	private LinkedList<CommandeDecorator> undoneList2 = new LinkedList<CommandeDecorator>();
	private static final int MAX_LIST_LENGTH = 20;

	private GestionnaireCmd() { }

	public static GestionnaireCmd getGestionnaireCmd() {
		return gestionnaire;
	}

	/**
	 * Ajoute la commande à la liste des commandes faites.
	 * La liste ne peut contenir plus que MAX_LIST_LENGTH commandes.
	 * @param cmd la commande à ajouter.
	 */
	public void addToDone(CommandeDecorator cmd, int numPerspective) {
		if (numPerspective == 1) {
			doneList1.addFirst(cmd);        
			if (doneList1.size() > MAX_LIST_LENGTH)
				doneList1.removeLast();
		} else if(numPerspective == 2) {
			doneList2.addFirst(cmd);        
			if (doneList2.size() > MAX_LIST_LENGTH)
				doneList2.removeLast();
		}
	}

	/**
	 * Défaire la dernière commande.
	 */
	public void defaire(int numPerspective) {
		if (numPerspective == 1) {
			if (doneList1.size() > 0) { 
				CommandeDecorator cmd = doneList1.removeFirst();
				cmd.defaire();
				undoneList1.addFirst(cmd);
			}
		} else if(numPerspective == 2) {
			if (doneList2.size() > 0) { 
				CommandeDecorator cmd = doneList2.removeFirst();
				cmd.defaire();
				undoneList2.addFirst(cmd);
			}
		}
	}

	/**
	 * Refaire la dernière commande défaite.
	 */
	public void refaire(int numPerspective) {
		if (numPerspective == 1) {
			if (undoneList1.size() > 0) { 
				CommandeDecorator cmd = undoneList1.removeFirst();
				cmd.faire();
				doneList1.addFirst(cmd);			
			} 
		} else if (numPerspective == 2) {
			if (undoneList2.size() > 0) { 
				CommandeDecorator cmd = undoneList2.removeFirst();
				cmd.faire();
				doneList2.addFirst(cmd);			
			}
		}
	}
	
	/**
	 * Efface la liste des commandes complétées selon la fenêtre
	 * @param numPerspective Numéro de fenêtre.
	 */
	public void clearDoneList(int numPerspective) {
		if (numPerspective == 1) 
			doneList1.clear();
		else if (numPerspective == 2) 
			doneList2.clear();				
	}
	
	/**
	 * Efface la liste des commandes qui ont été refait selon la fenêtre
	 * @param numPerspective Numéro de fenêtre.
	 */
	public void clearUndoneList(int numPerspective) {
		if (numPerspective == 1) 
			undoneList1.clear();
		else if (numPerspective == 2) 
			undoneList2.clear();	
	}
}
