package controller;

import java.util.LinkedList;

public class GestionnaireCmd {

	private static GestionnaireCmd gestionnaire = new GestionnaireCmd();
	private LinkedList<Commande> doneList = new LinkedList<Commande>();
	private LinkedList<Commande> undoneList = new LinkedList<Commande>();
	private static final int MAX_LIST_LENGTH = 10;

	private GestionnaireCmd() { }

	public static GestionnaireCmd getGestionnaireCmd() {
		return gestionnaire;
	}

	/* CODE EMPRUNTÉ :
	   Les lignes suivantes sont basées sur l'exemple de la section Command du chapitre 8 de Grand 2002.	   		
	 */

	/** 
	 * Exécute la commande et la sauvegarde dans la liste au besoin.
	 * @param cmd la commande à exécuter.
	 */
	public void executerCommande(Commande cmd) {	
		cmd.faire();
//		if (undoneList.size() > 0)
//			undoneList.clear();
//		if (cmd.faire()) 
//			addToDone(cmd);
//		else //on ne peut défaire cette commande	
//			doneList.clear();                       
	}
	
	public void checkIfDone(Commande cmd){
		if (undoneList.size() > 0)
			undoneList.clear();
		if (cmd.done()) 
			addToDone(cmd);
		else //on ne peut défaire cette commande	
			doneList.clear();    
	}

	/**
	 * Ajoute la commande à la liste des commandes faites.
	 * La liste ne peut contenir plus que MAX_LIST_LENGTH commandes.
	 * @param cmd la commande à ajouter.
	 */
	private void addToDone(Commande cmd) {
		doneList.addFirst(cmd);        
		if (doneList.size() > MAX_LIST_LENGTH)
			doneList.removeLast();
	}

	/**
	 * Défaire la dernière commande.
	 */
	public void defaire() {
		if (doneList.size() > 0) { 
			Commande cmd = doneList.removeFirst();
			cmd.defaire();
			undoneList.addFirst(cmd);
		}
	}

	/**
	 * Refaire la dernière commande défaite.
	 */
	public void refaire() {
		if (undoneList.size() > 0) { 
			Commande cmd = undoneList.removeFirst();
			cmd.faire();
			doneList.addFirst(cmd);			
		} 
	}
	/* FIN DU CODE EMPRUNTÉ */
}
