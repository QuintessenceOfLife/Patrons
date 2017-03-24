package vue;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
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
		
		// ACTIONS OF MENU ITEMS
		mItemOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: Test
//				JFileChooser fc = new JFileChooser();
//				int result = fc.showOpenDialog(null);
//				if (result == JFileChooser.APPROVE_OPTION) {
//					File file = fc.getSelectedFile();
//					String fileName = file.getAbsolutePath(); 
//					
//					JLabel image = new JLabel("", new ImageIcon(fileName), JLabel.CENTER);
//					image.setIcon(new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT)));
//
//					panel.getPerspective().add(image, BorderLayout.CENTER);
//					panel.getPerspective().revalidate(); 
//					panel.getPerspective().repaint(); 
//				}
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
