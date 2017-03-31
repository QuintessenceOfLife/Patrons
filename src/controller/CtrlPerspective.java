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
	private int mouseStartX, mouseStartY;
	private int dragStartX, dragStartY;
	
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
			new Zoom(fenPerspective.getNumFenetre(), e.getX(), e.getY(), e.getWheelRotation());
		}		
	}
	
	private class TranslateListener extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			Translater translater = new Translater(fenPerspective.getNumFenetre(), e.getX(), e.getY(), dragStartX, dragStartY);
			dragStartX = e.getX();
			dragStartY = e.getY();
			translater.faire();
		}
	}
	
	private class MousePressedListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			dragStartX = e.getX();
			dragStartY = e.getY();
			mouseStartX = e.getX();
			mouseStartY = e.getY();
		}
	}
	
	private class MouseReleasedListener extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("Released");
			Translater translater = new Translater(fenPerspective.getNumFenetre(), e.getX(), e.getY(), mouseStartX, mouseStartY);
			translater.done();
			gestionnaire.checkIfDone(translater);
		}
	}
}
