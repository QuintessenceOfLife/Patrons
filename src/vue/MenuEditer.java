package vue;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.CtrlMenu;

@SuppressWarnings("serial")
public class MenuEditer extends JMenu{
		
	// Menu Items de Editer
	private JMenuItem mItemDefaire;
	private JMenuItem mItemRefaire;
	
	public MenuEditer(){
		super("Editer");
		
		mItemDefaire = new JMenuItem("Defaire");
		mItemRefaire = new JMenuItem("Refaire");
		
		addMenuEditer();
	}
	
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
	
	public void addController(CtrlMenu ctrlMenu) {
		mItemDefaire.addActionListener(ctrlMenu);
		mItemRefaire.addActionListener(ctrlMenu);
	}
}
