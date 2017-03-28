package vue;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import controller.CtrlMenu;

@SuppressWarnings("serial")
public class MenuFichier extends JMenu{
	
	// Menu Items de Fichier
	private JMenuItem mItemOuvrir;
	private JMenuItem mItemSauvegarder;
	private JMenuItem mItemQuitter;
	
	// Separateur de Fichier
	private JSeparator separateur;
	private JSeparator separateur1;
	
	public MenuFichier(){
		super("Fichier");
		
		// Creation des Menu Items de Fichier
		mItemOuvrir = new JMenuItem("Ouvrir");
		mItemSauvegarder = new JMenuItem("Sauvegarder");
		mItemQuitter = new JMenuItem("Quitter");
		
		// Creation des separateurs
		separateur = new JSeparator();
		separateur1 = new JSeparator();
		
		// Ajouter les menuItems dans le menu
		addMenuFichier();
	}
	
	private void addMenuFichier() {
		// Icons
		mItemOuvrir.setIcon(new ImageIcon("icons"+File.separator+"ouvrir_16.png"));
		mItemSauvegarder.setIcon(new ImageIcon("icons"+File.separator+"save_16.png"));
		mItemQuitter.setIcon(new ImageIcon("icons"+File.separator+"close_16.png"));
		
		// Ajout
		this.add(mItemOuvrir);
		this.add(separateur);
		this.add(mItemSauvegarder);
		this.add(separateur1);
		this.add(mItemQuitter);
	}
	
	public void addController(CtrlMenu ctrlMenu) {
		mItemOuvrir.addActionListener(ctrlMenu);
		mItemSauvegarder.addActionListener(ctrlMenu);
		mItemQuitter.addActionListener(ctrlMenu);
	}
}
