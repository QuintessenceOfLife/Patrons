package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Perspective;
import model.Photo;
import vue.FenetrePrincipale;
import vue.MenuEditer;
import vue.MenuFichier;

public class CtrlMenu implements ActionListener {
	
	protected final static GestionnaireCmd gestionnaire = GestionnaireCmd.getGestionnaireCmd();
	private MenuFichier menuFichier;
	private MenuEditer menuEditer;
	private Photo image;
	private Perspective perspective1;
	private Perspective perspective2;
	private FenetrePrincipale fenPrincipale;
	
	/**
	 * Set the menus
	 * @param mf Menu fichier
	 * @param me Menu Editer
	 */
	public void setMenus(MenuFichier mf, MenuEditer me) {
		menuFichier = mf;
		menuEditer = me;
	}
	
	// TODO: Relook at this, maybe create other methods if during created there's no vignette or perspectives yet
	public CtrlMenu(Photo image, Perspective perspective1, Perspective perspective2, FenetrePrincipale fenPrincipale) {
//		this.image = image;
		this.perspective1 = perspective1;
		this.perspective2 = perspective2;
		this.fenPrincipale = fenPrincipale;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Ouvrir" : {
				(new Ouvrir(openFile())).faire();
				gestionnaire.clearDoneList(1);
				gestionnaire.clearDoneList(2);
				gestionnaire.clearUndoneList(1);
				gestionnaire.clearUndoneList(2);
				break;
			}
			case "Récupérer" : {
				(new Recuperer(restoreFile())).faire();
				gestionnaire.clearDoneList(1);
				gestionnaire.clearDoneList(2);
				gestionnaire.clearUndoneList(1);
				gestionnaire.clearUndoneList(2);
				break;
			}
			case "Sauvegarder": {
				(new Sauvegarder(saveFile())).faire();				
				break;
			}
			case "Defaire" : {				
				gestionnaire.defaire(fenPrincipale.getSelectedPerspectiveNumber()+1);
				break;
			}
			case "Refaire" : {
				gestionnaire.refaire(fenPrincipale.getSelectedPerspectiveNumber()+1);				
				break;
			}
			case "Quitter" : {
				System.exit(0);
				break;
			}
		}
	}
	
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
	
	private File saveFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Sauvegarde", "ser"));
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		
		return null;
	}
}
