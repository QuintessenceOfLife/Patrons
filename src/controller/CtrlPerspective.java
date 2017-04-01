package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import model.Perspective;
import vue.FenetrePerspective;
import controller.Zoom;
import controller.Translater;

public class CtrlPerspective {
	
	protected final static GestionnaireCmd gestionnaire = GestionnaireCmd.getGestionnaireCmd();
	private FenetrePerspective fenPerspective;
	private int initialDragOriginX, initialDragOriginY;
	private int subsequentDragOriginX, subsequentDragOriginY;
	
	public CtrlPerspective(FenetrePerspective fenPerspective, Perspective perspective) {
		this.fenPerspective = fenPerspective;
		fenPerspective.setZoomListener(new ZoomListener());
		fenPerspective.setTranslateListener(new TranslateListener());
		fenPerspective.setMousePressedListener(new MousePressedListener());
		fenPerspective.setMouseReleasedListener(new MouseReleasedListener());
	}	
	
	private class ZoomListener extends MouseAdapter {
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {			 
			(new Zoom(fenPerspective.getNumFenetre(), e.getX(), e.getY(), e.getWheelRotation())).faire();
		}		
	}
	
	private class TranslateListener extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			(new Translater(fenPerspective.getNumFenetre(), e.getX(), e.getY(), subsequentDragOriginX, subsequentDragOriginY)).faire();
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
			gestionnaire.addToDone(new Translater(fenPerspective.getNumFenetre(), e.getX(), e.getY(), initialDragOriginX, initialDragOriginY));
			gestionnaire.clearUndoneList();
		}
	}
}
