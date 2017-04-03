package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import model.Perspective;
import vue.FenetrePerspective;
import controller.Zoom;
import controller.Translater;

public class CtrlPerspective {
	
	protected final static GestionnaireCmd gestionnaire = GestionnaireCmd.getGestionnaireCmd();
	private FenetrePerspective fenPerspective;
	private int numFenetre;
	private Perspective perspective;
	private int initialDragOriginX, initialDragOriginY;
	private int subsequentDragOriginX, subsequentDragOriginY;
	private double initialSX1, initialSY1, initialSX2, initialSY2;
	private Timer timer;
	private static final int DELAI = 200; 
		
	public CtrlPerspective(FenetrePerspective fenPerspective, Perspective perspective) {		
		this.fenPerspective = fenPerspective;
		numFenetre = fenPerspective.getNumFenetre();		
		fenPerspective.setZoomListener(new IncrementalZoomListener());
		fenPerspective.setTranslateListener(new TranslateListener());
		fenPerspective.setMousePressedListener(new MousePressedListener());
		fenPerspective.setMouseReleasedListener(new MouseReleasedListener());
		timer = new Timer(DELAI, new TotalZoomListener());
		timer.setRepeats(false);
	}	
	
//	public void zoom(int curseurX, int curseurY, int notches) {		
//		if (curseurY < y2 && curseurY > y1 && curseurX > x1 && curseurX < x2) {
//			x1 -= (curseurX - x1) * notches * FACTEUR_ZOOM;
//			y1 -= (curseurY - y1) * notches * FACTEUR_ZOOM;
//			x2 += (x2 - curseurX) * notches * FACTEUR_ZOOM;
//			y2 += (y2 - curseurY) * notches * FACTEUR_ZOOM;
//		}		
//	}
	
	private class IncrementalZoomListener extends MouseAdapter {
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			if (numFenetre == 1)
				perspective = Perspective.getPerspective1();
			else
				perspective = Perspective.getPerspective2();
			if (initialSY2 == 0) {
				initialSX1 = perspective.getX1();
				initialSY1 = perspective.getY1();
				initialSX2 = perspective.getX2();
				initialSY2 = perspective.getY2();
			}
			int notches;
			if (e.getWheelRotation() < 0) {
				notches = 1;
			} else {
				notches = -1;
			}
			double dx1 = perspective.getX1() - (e.getX() - perspective.getX1()) * notches * Perspective.FACTEUR_ZOOM;
			double dy1 = perspective.getY1() - (e.getY() - perspective.getY1()) * notches * Perspective.FACTEUR_ZOOM;
			double dx2 = perspective.getX2() + (perspective.getX2() - e.getX()) * notches * Perspective.FACTEUR_ZOOM;
			double dy2 = perspective.getY2() + (perspective.getY2() - e.getY()) * notches * Perspective.FACTEUR_ZOOM;
			(new Zoom(numFenetre, perspective.getX1(), perspective.getY1(), perspective.getX2(), perspective.getY2(), dx1, dy1, dx2, dy2)).faire();
			timer.restart();
		}		
	}
	
	private class TotalZoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { 
        	gestionnaire.addToDone(new Zoom(numFenetre, initialSX1, initialSY1, initialSX2, initialSY2, perspective.getX1(), perspective.getY1(), perspective.getX2(), perspective.getY2()),
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
