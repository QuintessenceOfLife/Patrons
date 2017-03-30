package vue;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import java.awt.GridLayout;

import model.Perspective;
import model.Photo;
import controller.CtrlMenu;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame {
	
	private JMenuBar menuBar;
	private MenuFichier menuFichier;
	private MenuEditer menuEditer;
	private CtrlMenu ctrlMenu;
	private JDesktopPane desktopPane;
	private JTabbedPane tabbedPanel;
	private FenetrePerspective fenetrePerspective1;
	private FenetrePerspective fenetrePerspective2;
	private FenetreVignette fenetreVignette;
	
	// TODO
	private int width;
	private int height;
	
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
		ctrlMenu = new CtrlMenu(Photo.getInstance(), Perspective.getPerspective1(), Perspective.getPerspective2());
		menuFichier = new MenuFichier();
		menuEditer = new MenuEditer();
		menuFichier.addController(ctrlMenu);
		menuEditer.addController(ctrlMenu);
		ctrlMenu.setMenus(menuFichier, menuEditer);
		menuBar.add(menuFichier);
		menuBar.add(menuEditer);

		// Add everything into frame and pack
		setJMenuBar(menuBar);
		addJPanels();
	    setContentPane(desktopPane);
		pack();
		
		setVisible(true);
	}
	
	private void addJPanels(){
		// Tabbed Panel qui prend 70% du width de l'ecran et 85% de l'hauteur
		tabbedPanel = new JTabbedPane();
		tabbedPanel.setSize((int) (width * 0.7), (int) (height * 0.85));
		
		// Creation des fenetres
		fenetrePerspective1 = new FenetrePerspective(1, Perspective.getPerspective1(), Photo.getInstance());
		fenetrePerspective2 = new FenetrePerspective(2, Perspective.getPerspective2(), Photo.getInstance());
		fenetreVignette = new FenetreVignette(Photo.getInstance(), (int) (width * 0.20), (int) (height * 0.20), width);
		
		// Ajout des perspectives dans le tabbed panned
		tabbedPanel.add("Perspective 1", fenetrePerspective1);
		tabbedPanel.add("Perspective 2", fenetrePerspective2);
	    
		// Ajout dans le desktop Pane
        desktopPane.add(tabbedPanel);
        desktopPane.add(fenetreVignette);
	}
}