package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuEditer extends JMenu{
	
	private JMenuItem mItemDefaire;
	private JMenuItem mItemRefaire;
	
	public MenuEditer(){
		super("Editer");
		
		mItemDefaire = new JMenuItem("Defaire");
		mItemRefaire = new JMenuItem("Refaire");
		
		addMenuEditer();
	}
	
	private void addMenuEditer() {
		mItemDefaire.setIcon(new ImageIcon("icons"+File.separator+"undo_16.png"));
		mItemRefaire.setIcon(new ImageIcon("icons"+File.separator+"redo_16.png"));
		
		this.add(mItemDefaire);
		this.add(mItemRefaire);
		
		mItemDefaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		mItemRefaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}
}
