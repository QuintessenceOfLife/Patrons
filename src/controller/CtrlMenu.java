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
* Nom du fichier: CtrlMenu.java
* Date cree: 2017-03-23
*******************************************************/

package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/*****************************************************************************
 * Classe qui gère les actions:
 * - Ouverture d'un fichier
 * - Récupération d'un fichier
 * - Sauvegarder un fichier
 * - Défaire une action
 * - Refaire une action
 * - Quitter
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public class CtrlMenu implements ActionListener {
	
	/*****************************
	 * VARIABLES
	 *****************************/
	private static final GestionnaireCmd GESTIONNAIRE = GestionnaireCmd.getGestionnaireCmd();
	private JTabbedPane tabbedPane;
	
	/*****************************
	 * CONSTRUCTEUR
	 * @param tabbedPane Panneau de perspectives
	 *****************************/
	public CtrlMenu(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	/**
	 * Faire une commande dépendamment du bouton pesé
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Ouvrir" : {
				/*
				 * Ouvrir fichier et effacer les listes de commandes
				 */
				File file = openFile();
				if (file == null)
					return;
				(new Ouvrir(file)).faire();
				tabbedPane.setSelectedIndex(0);
				GESTIONNAIRE.clearDoneList(1);
				GESTIONNAIRE.clearDoneList(2);
				GESTIONNAIRE.clearUndoneList(1);
				GESTIONNAIRE.clearUndoneList(2);
				break;
			}
			case "Récupérer" : {
				/*
				 * Récupérer fichier et effacer les listes de commandes
				 */
				File file = restoreFile();
				if (file == null)
					return;
				(new Recuperer(file)).faire();
				tabbedPane.setSelectedIndex(0);
				GESTIONNAIRE.clearDoneList(1);
				GESTIONNAIRE.clearDoneList(2);
				GESTIONNAIRE.clearUndoneList(1);
				GESTIONNAIRE.clearUndoneList(2);
				break;
			}
			case "Sauvegarder": {
				/*
				 * Sauvegarder fichier s'il existe
				 */
				File file = saveFile();
				if (file == null)
					return;
				(new Sauvegarder(file)).faire();				
				break;
			}
			case "Defaire" : {	
				/*
				 * Défaire une commande
				 */
				GESTIONNAIRE.defaire(tabbedPane.getSelectedIndex()+1);
				break;
			}
			case "Refaire" : {
				/*
				 * Refaire une commande
				 */
				GESTIONNAIRE.refaire(tabbedPane.getSelectedIndex()+1);				
				break;
			}
			case "Quitter" : {
				/*
				 * Quitter
				 */
				System.exit(0);
				break;
			}
		}
	}
	
	/**
	 * Ouverture d'un fichier, permet seulement l'ouverture de fichier de type Image
	 * @return file Fichier photo
	 */
	private File openFile() {		
		JFileChooser fileChooser = new JFileChooser();
		
		FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(imageFilter);
		
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}
	
	/**
	 * Récupération d'un fichier, permet seulement l'ouverture de fichier de type .ser
	 * @return file Fichier ser
	 */
	private File restoreFile() {		
		JFileChooser fileChooser = new JFileChooser();
		
		FileFilter savedFileFilter = new FileNameExtensionFilter("Fichier ser", "ser");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(savedFileFilter);
		
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}
	
	/**
	 * Sauvegarde d'un fichier, sauvegarde automatiquement de type .ser
	 * @return file Fichier ser
	 */
	private File saveFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Sauvegarde", "ser"));
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = new File(fileChooser.getSelectedFile() + ".ser");
			return file;
		}
		return null;
	}
}
