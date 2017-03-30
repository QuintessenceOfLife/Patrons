package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import model.Perspective;
import vue.FenetrePerspective;
import controller.Zoom;
import controller.Translater;

public class CtrlPerspective {
	
	private FenetrePerspective fenPerspective;
	private int dragStartX, dragStartY;
	
	public CtrlPerspective(FenetrePerspective fenPerspective, Perspective perspective) {
		this.fenPerspective = fenPerspective;
		fenPerspective.setZoomListener(new ZoomListener());
		fenPerspective.setTranslateListener(new TranslateListener());
		fenPerspective.setMousePressedListener(new MousePressedListener());
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
			new Translater(fenPerspective.getNumFenetre(), e.getX(), e.getY(), dragStartX, dragStartY);
			dragStartX = e.getX();
			dragStartY = e.getY();
		}
	}
	
	private class MousePressedListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			dragStartX = e.getX();
			dragStartY = e.getY();
		}
	}
}
