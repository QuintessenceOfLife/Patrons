package vue;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import controller.CtrlMenu;

import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import java.awt.GridLayout;

import model.Perspective;
import model.Image;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame {
	
	private JMenuBar menuBar;
	private MenuFichier menuFichier;
	private MenuEditer menuEditer;
	private CtrlMenu ctrlMenu;
	private JDesktopPane desktopPane;
	private int width;
	private int height;
	private FenetrePerspective topLeft;
	private FenetrePerspective bottomLeft;
	private FenetreVignette topRight;
	
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
		Dimension desktopSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = desktopSize.width - 20;
		height = desktopSize.height - 20;

		// MenuBar
		menuBar = new JMenuBar();
		
		// Menus
		ctrlMenu = new CtrlMenu(Image.getInstance(), Perspective.getPerspective1(), Perspective.getPerspective2());
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
		// TODO
	    
//		// Create the panels
//		topLeft = new FenetrePerspective("Perspective 1", (int) (width * 0.7), (int) (height * 0.4), 0, 0, Perspective.getPerspective1());
//		bottomLeft = new FenetrePerspective("Perspective 2", (int) (width*0.7),(int) (height*0.4), 0, (int) (height*0.4), Perspective.getPerspective2());
//		topRight = new FenetreVignette("Vignette", (int) (width * 0.3), (int) (height * 0.4), (int) (width * 0.7), 0, Image.getInstance());
//
//		// set the menu controller
//		ctrlMenu.setMenus(menuFichier, menuEditer);
//		ctrlMenu.setPerspectives(Perspective.getVignette(), Perspective.getPerspective1(), Perspective.getPerspective2());
//		menuFichier.addController(ctrlMenu);
//		menuEditer.addController(ctrlMenu);
//		
//		// Ajout des InternalFrames
//        desktopPane.add(topLeft);		// Add Perspective1
//        desktopPane.add(bottomLeft);
//        desktopPane.add(topRight);
//   
//        setContentPane(desktopPane);
	}
}