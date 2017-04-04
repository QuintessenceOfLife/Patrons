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
* Nom du fichier: Photo.java
* Date cree: 2017-03-23
*******************************************************/

package model;
import java.io.File;
import java.io.Serializable;

/*****************************************************************************
 * Modèle de la Photo.
 * Contient le fichier de la photo et l'observateur.
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
@SuppressWarnings("serial")
public class Photo implements Observable, Serializable {
	
	/*****************************
	 * VARIABLES
	 *****************************/
	private static Photo instance = new Photo();
	private File fichierPhoto;
	private Observateur observateur;
	
	/*****************************
	 * CONSTRUCTEUR
	 *****************************/
	private Photo() {}
	
	/*****************************
	 * ACCESSEURS
	 *****************************/
	/**
	 * @return instance La Photo
	 */
	public static Photo getInstance() {
		return instance; 
	}

	/**
	 * @return fichierPhoto Le fichier Photo
	 */
	public File getFichierPhoto() {
		return fichierPhoto;
	}

	/*****************************
	 * SETTERS
	 *****************************/
	/**
	 * Changement du fichierPhoto et notifier l'observateur
	 * @param fichierPhoto Fichier photo
	 */
	public void setFichierPhoto(File fichierPhoto) {
		this.fichierPhoto = fichierPhoto;
		notifier();
	}
	
	/**
	 * Changement de l'observateur
	 * @param observateur Observateur
	 */
	public void setObservateur(Observateur observateur) {
		this.observateur = observateur;		
	}
	
	/**
	 * Notifier les observateurs
	 */
	@Override
	public void notifier() {
		observateur.update();		
	}
	
}
