package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

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
		mItemOuvrir.setIcon(new ImageIcon("icons"+File.separator+"ouvrir_16.png"));
		mItemSauvegarder.setIcon(new ImageIcon("icons"+File.separator+"save_16.png"));
		mItemQuitter.setIcon(new ImageIcon("icons"+File.separator+"close_16.png"));
		
		this.add(mItemOuvrir);
		this.add(separateur);
		this.add(mItemSauvegarder);
		this.add(separateur1);
		this.add(mItemQuitter);
		
		mItemOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		mItemSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		mItemQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
}
