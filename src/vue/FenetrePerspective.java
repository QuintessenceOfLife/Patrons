package vue;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetrePerspective extends JPanel {
	
	// Attributs
	JLabel titre;
	JPanel perspective;
	
	public FenetrePerspective(String label){
		// Borders and Layout
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		setLayout(new BoxLayout(this,1));
		
		// Titre
		titre = new JLabel(label);
		
		// Specifications de la perspective
		perspective = new JPanel(new GridLayout(0,1));
		perspective.setOpaque(true);
		perspective.setBackground(Color.LIGHT_GRAY);
		
		// Ajout
		add(titre);
		add(perspective);
	}
}
