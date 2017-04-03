package controller;

import java.util.LinkedList;

public class GestionnaireCmd {

	private static GestionnaireCmd gestionnaire = new GestionnaireCmd();
	//deux listes pour la perspective1
	private LinkedList<Commande> doneList1 = new LinkedList<Commande>();
	private LinkedList<Commande> undoneList1 = new LinkedList<Commande>();
	//deux listes pour la perspective2
	private LinkedList<Commande> doneList2 = new LinkedList<Commande>();
	private LinkedList<Commande> undoneList2 = new LinkedList<Commande>();
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
	public void addToDone(Commande cmd, int numPerspective) {
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
				Commande cmd = doneList1.removeFirst();
				cmd.defaire();
				undoneList1.addFirst(cmd);
			}
		} else if(numPerspective == 2) {
			if (doneList2.size() > 0) { 
				Commande cmd = doneList2.removeFirst();
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
				Commande cmd = undoneList1.removeFirst();
				cmd.faire();
				doneList1.addFirst(cmd);			
			} 
		} else if (numPerspective == 2) {
			if (undoneList2.size() > 0) { 
				Commande cmd = undoneList2.removeFirst();
				cmd.faire();
				doneList2.addFirst(cmd);			
			}
		}
	}
	
	public void clearDoneList(int numPerspective) {
		if (numPerspective == 1) 
			doneList1.clear();
		else if (numPerspective == 2) 
			doneList2.clear();				
	}
	
	public void clearUndoneList(int numPerspective) {
		if (numPerspective == 1) 
			undoneList1.clear();
		else if (numPerspective == 2) 
			undoneList2.clear();	
	}
}
