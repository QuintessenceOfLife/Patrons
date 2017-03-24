package vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;

import java.awt.GridLayout;

public class FenetrePrincipale extends JFrame {
	
	private JMenuBar menuBar;
	private MenuFichier menuFichier;
	private MenuEditer menuEditer;
	JDesktopPane desktopPane;
	private FenetrePerspective topLeft;
	private FenetrePerspective bottomLeft;
	private Vignette topRight;
	
	public FenetrePrincipale() {
		super("Application Image");
	
		
		// Frame specifications
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		// Desktop
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		
		// MenuBar
		menuBar = new JMenuBar();
		
		// Menus
		menuFichier = new MenuFichier();
		menuEditer = new MenuEditer();
		menuBar.add(menuFichier);
		menuBar.add(menuEditer);

		// Add everything into frame and pack
		setJMenuBar(menuBar);
		addJPanels();
		pack();
		
		setVisible(true);
	}
	
	private void addJPanels(){
	    
		// Create the panels
		topLeft = new FenetrePerspective("Perspective 1");
		topLeft.setLocation(0,0);
		bottomLeft = new FenetrePerspective("Perspective 2");
		bottomLeft.setLocation(0,400);
		topRight = new Vignette("Vignette");
		topRight.setLocation(500,0);

        desktopPane.add(topLeft);		// Add Perspective1
        desktopPane.add(bottomLeft);
        desktopPane.add(topRight);
   
        setContentPane(desktopPane);
	}
}