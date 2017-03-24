package vue;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vignette extends JPanel{
	JLabel titre;
	JPanel vignette;
	
	public Vignette(String label){
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		setLayout(new BoxLayout(this,1));
		titre = new JLabel(label);
		vignette = new JPanel(new GridLayout(0,1));
		vignette.setOpaque(true);
		vignette.setBackground(Color.BLUE);
		add(titre);
		add(vignette);
	}
}
