package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import java.awt.GridLayout;

public class FenetrePrincipale extends JFrame {
	
	private JMenuBar menuBar;
	private JPanel mainPanel;
	private JPanel topLeft;
	private JPanel bottomLeft;
	private JPanel topRight;
	
	public FenetrePrincipale() {
		super("Application Image");
		
		// Frame specifications
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		// MenuBar
		menuBar = new JMenuBar();
		
		// Menus
		MenuFichier menuFichier = new MenuFichier();
		MenuEditer menuEditer = new MenuEditer();
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
		mainPanel = new JPanel();
		topLeft = new FenetrePerspective("Perspective 1");
		bottomLeft = new FenetrePerspective("Perspective 2");
		topRight = new Vignette("Vignette");
		
		
		// Set borders and layouts of the frame
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(new GridBagLayout());

		// GridBagContraints
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;	// Fill in both x and y
        gbc.gridx = 0;						// Start at (0,0)
        gbc.gridy = 0;
        gbc.weightx = 0.65;					// Perspectives takes 65% of width			
        gbc.weighty = 0.5;
        mainPanel.add(topLeft, gbc);		// Add Perspective1
        
        gbc.gridx = 0;						// (0,1)	
        gbc.gridy = 1;
        mainPanel.add(bottomLeft, gbc);		// Add Perspective2

        gbc.gridx = 1;						// (1,0)
        gbc.gridy = 0;
        gbc.weightx = 0.35;					// Vignette takes 35% of width
        mainPanel.add(topRight, gbc);		// Add Vignette
        
        setContentPane(mainPanel);
	}
}