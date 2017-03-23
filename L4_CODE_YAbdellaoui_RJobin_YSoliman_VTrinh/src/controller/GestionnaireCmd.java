package controller;

import java.util.List;
import java.util.LinkedList;

public class GestionnaireCmd {
	
	private static GestionnaireCmd gestionnaire = new GestionnaireCmd();
	private List doneList= new LinkedList<Commande>();
	private List redoList = new LinkedList<Commande>();
	
	private GestionnaireCmd() { }
	
	public static GestionnaireCmd getGestionnaireCmd() {
		return gestionnaire;
	}
	
	public void executerCommande(Commande cmd) {
		/* 
		 * Exécute la commande
		 * Sauvegarde la commande dans la liste
		*/
		if (cmd.faire()) { 
			addToDone(cmd); 
		}
	}
	
	public void addToDone(Commande cmd) {
		doneList.add(cmd);
	}
	
	private void refaire() {
		
	}
	
	private void defaire() {
		
	}
}
