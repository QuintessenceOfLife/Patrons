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
	private FenetrePerspective fenPerspective;
	private int numFenetre;
	private int initialDragOriginX, initialDragOriginY;
	private int subsequentDragOriginX, subsequentDragOriginY;
	private int initialWheelX, initialWheelY = -1;
	private int notchCount;
	private Timer timer;
	private static final int DELAI = 100; 
	
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
	
	private class IncrementalZoomListener extends MouseAdapter {
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			if (initialWheelY == -1) {
				initialWheelX = e.getX();
				initialWheelY = e.getY();
			}
			int notches;
			if (e.getWheelRotation() < 0) {
				notches = 1;
				notchCount++;
			} else {
				notches = -1;
				notchCount--;
			}
			(new Zoom(numFenetre, e.getX(), e.getY(), notches)).faire();
			timer.restart();
		}		
	}
	
	private class TotalZoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { 
        	if (notchCount == 0)
        		return;
            gestionnaire.addToDone(new Zoom(numFenetre, initialWheelX, initialWheelY, notchCount));
            System.out.println("created a total zoom command and added it to done list");
            System.out.println("numFenetre: " + numFenetre);
            System.out.println("initialWheelX: " + initialWheelX);
            System.out.println("initialWheelY: " + initialWheelY);
            System.out.println("notchCount: " + notchCount);
            System.out.println("---------------------------------------------------");
            gestionnaire.clearUndoneList();
            initialWheelY = -1;
            notchCount = 0;            
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
			gestionnaire.addToDone(new Translater(numFenetre, e.getX(), e.getY(), initialDragOriginX, initialDragOriginY));
			gestionnaire.clearUndoneList();
		}
	}
		
}
