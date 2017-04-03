package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Perspective;
import vue.MenuEditer;
import vue.MenuFichier;

public class CtrlMenu implements ActionListener {
	
	protected final static GestionnaireCmd gestionnaire = GestionnaireCmd.getGestionnaireCmd();
	private MenuFichier menuFichier;
	private MenuEditer menuEditer;
	private Perspective perspective1;
	private Perspective perspective2;
	private JTabbedPane tabbedPane;
	
	/**
	 * Set the menus
	 * @param mf Menu fichier
	 * @param me Menu Editer
	 */
	public void setMenus(MenuFichier mf, MenuEditer me) {
		menuFichier = mf;
		menuEditer = me;
	}
	
	public CtrlMenu(Perspective perspective1, Perspective perspective2, JTabbedPane tabbedPane) {
		this.perspective1 = perspective1;
		this.perspective2 = perspective2;
		this.tabbedPane = tabbedPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Ouvrir" : {
				File file = openFile();
				if (file == null)
					return;
				(new Ouvrir(file)).faire();
				tabbedPane.setSelectedIndex(0);
				gestionnaire.clearDoneList(1);
				gestionnaire.clearDoneList(2);
				gestionnaire.clearUndoneList(1);
				gestionnaire.clearUndoneList(2);
				break;
			}
			case "Récupérer" : {
				File file = restoreFile();
				if (file == null)
					return;
				(new Recuperer(file)).faire();
				tabbedPane.setSelectedIndex(0);
				gestionnaire.clearDoneList(1);
				gestionnaire.clearDoneList(2);
				gestionnaire.clearUndoneList(1);
				gestionnaire.clearUndoneList(2);
				break;
			}
			case "Sauvegarder": {
				File file = saveFile();
				if (file == null)
					return;
				(new Sauvegarder(file)).faire();				
				break;
			}
			case "Defaire" : {				
				gestionnaire.defaire(tabbedPane.getSelectedIndex()+1);
				break;
			}
			case "Refaire" : {
				gestionnaire.refaire(tabbedPane.getSelectedIndex()+1);				
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
