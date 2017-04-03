package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;

import model.Perspective;
import vue.FenetrePerspective;
import controller.Zoom;
import controller.Translater;

public class CtrlPerspective {
	
	protected final static GestionnaireCmd gestionnaire = GestionnaireCmd.getGestionnaireCmd();
	private int numFenetre;
	private Perspective perspective;
	private int initialDragOriginX, initialDragOriginY;
	private int subsequentDragOriginX, subsequentDragOriginY;
	private double initialSX1, initialSY1, initialSX2, initialSY2;
	private Timer timer;
	private static final int DELAI = 200; 
		
	public CtrlPerspective(FenetrePerspective fenPerspective, Perspective perspective) {		
		numFenetre = fenPerspective.getNumFenetre();		
		fenPerspective.setZoomListener(new IncrementalZoomListener());
		fenPerspective.setTranslateListener(new TranslateListener());
		fenPerspective.setMousePressedListener(new MousePressedListener());
		fenPerspective.setMouseReleasedListener(new MouseReleasedListener());
		timer = new Timer(DELAI, new TotalZoomListener());
		timer.setRepeats(false);
	}	
	
	private class IncrementalZoomListener extends MouseAdapter {
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			int wheelX = e.getX();
			int wheelY = e.getY();
			
			if (numFenetre == 1)
				perspective = Perspective.getPerspective1();
			else
				perspective = Perspective.getPerspective2();
			
			double x1 = perspective.getX1();
			double x2 = perspective.getX2();
			double y1 = perspective.getY1();
			double y2 = perspective.getY2();
			
			int notches;
			if (e.getWheelRotation() < 0) {
				notches = 1;
				if ( (x2-x1) >= 20000 || (y2-y1) >= 20000 )
					return; //on sort si la largeur ou la hauteur max est atteinte
			} else {
				notches = -1;
				if ( (x2-x1) <= 50 || (y2-y1) <= 50 )
					return; //on sort si la largeur ou la hauteur min est atteinte
			}
			if ( wheelX <= x1 || wheelX >= x2 || wheelY <= y1 || wheelY >= y2 )
				return; //on sort si le curseur est en dehors de l'image
			
			if (initialSY2 == 0) {
				initialSX1 = x1;
				initialSY1 = y1;
				initialSX2 = x2;
				initialSY2 = y2;
			}			
			double facteurZoom = Perspective.FACTEUR_ZOOM;
			double dx1 = x1 - (wheelX - x1) * notches * facteurZoom;
			double dy1 = y1 - (wheelY - y1) * notches * facteurZoom;
			double dx2 = x2 + (x2 - wheelX) * notches * facteurZoom;
			double dy2 = y2 + (y2 - wheelY) * notches * facteurZoom;
			
			(new Zoom(numFenetre, x1, y1, x2, y2, dx1, dy1, dx2, dy2)).faire();
			
			timer.restart();
		}		
	}
	
	private class TotalZoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { 
        	gestionnaire.addToDone(new Zoom(numFenetre, initialSX1, initialSY1, initialSX2, initialSY2, 
        			perspective.getX1(), perspective.getY1(), perspective.getX2(), perspective.getY2()),
        			numFenetre);
            System.out.println("created a total zoom command and added it to done list");
            System.out.println("numFenetre: " + numFenetre);
            System.out.println("---------------------------------------------------");
            gestionnaire.clearUndoneList(numFenetre);
            initialSY2 = 0;            
        }
    }
	
	private class TranslateListener extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			(new Translater(numFenetre, e.getX(), e.getY(), subsequentDragOriginX, subsequentDragOriginY)).faire();
			subsequentDragOriginX = e.getX();
			subsequentDragOriginY = e.getY();
		}
	}
	
	private class MousePressedListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			initialDragOriginX = e.getX();
			initialDragOriginY = e.getY();
			subsequentDragOriginX = e.getX();
			subsequentDragOriginY = e.getY();			
		}
	}
	
	private class MouseReleasedListener extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			if ((e.getX() == initialDragOriginX) && (e.getY() == initialDragOriginY))
				return;
			gestionnaire.addToDone(new Translater(numFenetre, e.getX(), e.getY(), initialDragOriginX, initialDragOriginY), numFenetre);
			gestionnaire.clearUndoneList(numFenetre);
		}
	}
		
}
