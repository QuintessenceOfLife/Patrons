package vue;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetrePerspective extends JPanel {
	JLabel titre;
	JPanel perspective;
	
	public FenetrePerspective(String label){
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		setLayout(new BoxLayout(this,1));
		titre = new JLabel(label);
		perspective = new JPanel(new GridLayout(0,1));
		perspective.setOpaque(true);
		perspective.setBackground(Color.LIGHT_GRAY);
		add(titre);
		add(perspective);
	}
}
