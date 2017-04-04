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
* Nom du fichier: Recuperer.java
* Date cree: 2017-03-23
*******************************************************/

package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*****************************************************************************
 * Récupère un fichier .ser
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public class Recuperer extends Commande {

	/*****************************
	 * VARIABLES
	 *****************************/
	private File sauvegarde;
	
	/**
	 * Constructeur	
	 * @param sauvegarde Fichier contenant les données à récupérer.
	 */
	public Recuperer(File sauvegarde) {
		this.sauvegarde = sauvegarde;
	}
		
	/**
	 * Récupérer l'image et les deux perspectives à partir de la sauvegarde.
	 */
	@Override
	public void faire() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sauvegarde));) {			
			Object[] objects = (Object[]) ois.readObject();				
			photo.setFichierPhoto( ((File) objects[0]) );
			//dans cette ordre pour contourner le problème de always draw on top du tabbedPane
			perspective2.setCoordinates( 
					((double) objects[5]), 
					((double) objects[6]), 
					((double) objects[7]), 
					((double) objects[8]));
			perspective1.setCoordinates( 
					((double) objects[1]),
					((double) objects[2]),
					((double) objects[3]), 
					((double) objects[4]));												
		} catch (ClassNotFoundException | IOException e) {		
			e.printStackTrace();
		}				
	}

}
