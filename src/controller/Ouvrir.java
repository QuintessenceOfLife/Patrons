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
* Nom du fichier: Ouvrir.java
* Date cree: 2017-03-23
*******************************************************/

package controller;

import java.io.File;
import javax.swing.ImageIcon;

/*****************************************************************************
 * Ouverture d'un fichier
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public class Ouvrir extends Commande {
	
	/*****************************
	 * VARIABLES
	 *****************************/
	private File file;
	
	/*****************************
	 * CONSTRUCTEUR
	 * @param file fichier Image
	 *****************************/
	public Ouvrir(File file) {
		this.file = file;
	}
	
	/**
	 * Ouvre une photo dans la résolution de départ
	 */
	@Override
	public void faire() {
		photo.setFichierPhoto(file);
			
		ImageIcon image = new ImageIcon(file.getAbsolutePath());
		
		//dans cette ordre pour contourner le problème de always draw on top du tabbedPane
		perspective2.setCoordinates(0, 0, image.getIconWidth(), image.getIconHeight());
		perspective1.setCoordinates(0, 0, image.getIconWidth(), image.getIconHeight());		
	}

}