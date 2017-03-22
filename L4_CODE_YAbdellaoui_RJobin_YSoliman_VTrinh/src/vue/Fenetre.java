package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.SystemColor;

public class Fenetre extends JFrame {
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	private JPanel jp4;
	private JPanel jp5;
	private JPanel jp6;
	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenuItem mntmOuvrir;
	private JSeparator separateur;
	private JSeparator separateur1;
	private JMenuItem mntmSauvegarder;
	private JMenuItem mntmQuitter;
	private JMenu mnEditer;
	private JMenuItem mntmUndo;
	private JMenuItem mntmRedo;
	
	public Fenetre() {
		super("Application Image");
		
		getContentPane().setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1024,720));
		
		menuBar = new JMenuBar();
		mnFichier = new JMenu("Fichier");
		mntmOuvrir = new JMenuItem("Ouvrir");
		separateur = new JSeparator();
		separateur1 = new JSeparator();
		mntmSauvegarder = new JMenuItem("Sauvegarder");
		mntmQuitter = new JMenuItem("Quitter");
		mnEditer = new JMenu("Editer");
		mntmUndo = new JMenuItem("Undo");
		mntmRedo = new JMenuItem("Redo");
		
		addMenuFichier(); 
		addMenuEditer();
		setJMenuBar(menuBar);
		addJPanels();
		pack();
		
		setVisible(true);
		
	}
	
	private void addMenuFichier() {
		mntmOuvrir.setIcon(new ImageIcon("icones\\ouvrir_16.png"));
		mntmSauvegarder.setIcon(new ImageIcon("icones\\save_16.png"));
		mntmQuitter.setIcon(new ImageIcon("icones\\close_16.png"));
		menuBar.add(mnFichier);
		mnFichier.add(mntmOuvrir);
		mnFichier.add(separateur);
		mnFichier.add(mntmSauvegarder);
		mnFichier.add(separateur1);
		mnFichier.add(mntmQuitter);
		
		mntmOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mntmSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
	}
	private void addMenuEditer() {
		mntmUndo.setIcon(new ImageIcon("icones\\undo_16.png"));
		mntmRedo.setIcon(new ImageIcon("icones\\redo_16.png"));
		menuBar.add(mnEditer);
		mnEditer.add(mntmUndo);
		mnEditer.add(mntmRedo);
	}
	private void addJPanels() {
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		
		jp1.setLayout(new GridLayout(1,2));
		jp2.setLayout(new GridLayout(2,1));
		jp3.setLayout(new GridLayout(2,1));
		jp4.setLayout(new GridLayout(1, 1));
		jp5.setLayout(new GridLayout(1, 1));
		jp6.setLayout(new GridLayout(1, 1));
		
		
		jp4.setBackground(Color.BLACK);
		jp5.setBackground(Color.BLUE);
		jp6.setBackground(Color.CYAN);
		
		getContentPane().add(jp1);
		jp1.add(jp2);
		jp1.add(jp3);
		jp2.add(jp4);
		jp2.add(jp5);
		jp3.add(jp6);
	}

}
