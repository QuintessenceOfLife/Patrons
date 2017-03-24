package vue;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vignette extends JPanel{
	
	// Attributs
	JLabel titre;
	JPanel vignette;
	
	public Vignette(String label){
		// Borders and Layout
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		setLayout(new BoxLayout(this,1));
		
		// Titre
		titre = new JLabel(label);
		
		// Specifications de la vignette
		vignette = new JPanel(new GridLayout(0,1));
		vignette.setOpaque(true);
		vignette.setBackground(Color.BLUE);
		
		// Ajout
		add(titre);
		add(vignette);
	}
}
