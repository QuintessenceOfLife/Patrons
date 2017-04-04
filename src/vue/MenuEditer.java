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
* Nom du fichier: MenuEditer.java
* Date cree: 2017-03-23
*******************************************************/

package vue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import controller.CtrlMenu;

/*****************************************************************************
 * Initialise les boutons pour défaire et refaire.
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
@SuppressWarnings("serial")
public class MenuEditer extends JMenu{
		
	/*****************************
	 * VARIABLES
	 *****************************/
	private JMenuItem mItemDefaire;
	private JMenuItem mItemRefaire;
	
	/*****************************
	 * CONSTRUCTEUR
	 *****************************/
	public MenuEditer(){
		super("Editer");
		
		mItemDefaire = new JMenuItem("Defaire");
		mItemRefaire = new JMenuItem("Refaire");
		
		addMenuEditer();
	}
	
	/*****************************
	 * Ajout des menu et des shortcuts
	 *****************************/
	private void addMenuEditer() {
		// Icons
		mItemDefaire.setIcon(new ImageIcon("icons"+File.separator+"undo_16.png"));
		mItemRefaire.setIcon(new ImageIcon("icons"+File.separator+"redo_16.png"));
		
		mItemDefaire.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 
				Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mItemRefaire.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, 
				Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		
		// Ajout des Menu Items
		this.add(mItemDefaire);
		this.add(mItemRefaire);
	}
	
	/*****************************
	 * Ajout du controleur
	 * @param ctrlMenu Le controleur Menu
	 *****************************/
	public void addController(CtrlMenu ctrlMenu) {
		mItemDefaire.addActionListener(ctrlMenu);
		mItemRefaire.addActionListener(ctrlMenu);
	}
}
