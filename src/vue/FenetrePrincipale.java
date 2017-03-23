package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;

public class FenetrePrincipale extends JFrame {
	
	private JMenuBar menuBar;
	private JPanel jp;
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jpPerspective1;
	private JPanel jpPerspective2;
	private JPanel jpThumbnail;
	
	public FenetrePrincipale() {
		super("Application Image");
		
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1024,720));
		
		menuBar = new JMenuBar();
		MenuFichier menuFichier = new MenuFichier();
		MenuEditer menuEditer = new MenuEditer();
		
		menuBar.add(menuFichier);
		menuBar.add(menuEditer);

		setJMenuBar(menuBar);
		addJPanels();
		pack();
		
		setVisible(true);
	}
	
	
	
	private void addJPanels() {
		jp = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jpThumbnail = new JPanel();
		jpPerspective1 = new JPanel();
		jpPerspective2 = new JPanel();
		
		jp.setOpaque(false);
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jpPerspective1.setBackground(new Color(0, 0, 0));
		jpPerspective2.setBackground(new Color(0, 0, 0));
		getContentPane().add(jp);
		
		
		
		
		GroupLayout glJp = new GroupLayout(jp);
		glJp.setHorizontalGroup(
			glJp.createParallelGroup(Alignment.LEADING)
				.addGroup(glJp.createSequentialGroup()
					.addComponent(jp1, GroupLayout.PREFERRED_SIZE, 768, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jp2, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
		);
		glJp.setVerticalGroup(
			glJp.createParallelGroup(Alignment.LEADING)
				.addComponent(jp1, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
				.addComponent(jp2, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
		);
		
		
		jpThumbnail.setBackground(new Color(0, 0, 0));
		GroupLayout glThumbnail = new GroupLayout(jp2);
		glThumbnail.setHorizontalGroup(
			glThumbnail.createParallelGroup(Alignment.LEADING)
				.addGroup(glThumbnail.createSequentialGroup()
					.addComponent(jpThumbnail, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
					.addContainerGap())
		);
		glThumbnail.setVerticalGroup(
			glThumbnail.createParallelGroup(Alignment.LEADING)
				.addGroup(glThumbnail.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpThumbnail, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(330, Short.MAX_VALUE))
		);
		jp2.setLayout(glThumbnail);
		
		
		
		GroupLayout glPerspectives = new GroupLayout(jp1);
		glPerspectives.setHorizontalGroup(
			glPerspectives.createParallelGroup(Alignment.LEADING)
				.addGroup(glPerspectives.createSequentialGroup()
					.addContainerGap()
					.addGroup(glPerspectives.createParallelGroup(Alignment.LEADING)
						.addComponent(jpPerspective2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
						.addComponent(jpPerspective1, GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)))
		);
		glPerspectives.setVerticalGroup(
			glPerspectives.createParallelGroup(Alignment.LEADING)
				.addGroup(glPerspectives.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpPerspective1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpPerspective2, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addContainerGap())
		);
		jp1.setLayout(glPerspectives);
		jp.setLayout(glJp);
	}
}