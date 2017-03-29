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
	private Perspective perspective;
	private int dragStartX, dragStartY;
	
	public CtrlPerspective(FenetrePerspective fenPerspective, Perspective perspective) {
		this.fenPerspective = fenPerspective;
		this.perspective = perspective;
		fenPerspective.setZoomListener(new ZoomListener());
		fenPerspective.setTranslateListener(new TranslateListener());
		fenPerspective.setMousePressedListener(new MousePressedListener());
	}	
	
	private class ZoomListener extends MouseAdapter {
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			int notches = e.getWheelRotation();
//			 double temp = zoom - (notches * 0.1);
//			 // minimum zoom factor is 1.0
//			 temp = Math.max(temp, 1.0);
//			 if (temp != zoom) {
//			 zoom = temp;
//			 resizeImage();
		}		
	}
	
	private class TranslateListener extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			int deltaX, deltaY;
			deltaX = e.getX() - dragStartX;
			deltaY = e.getY() - dragStartY;
			dragStartX = e.getX();
			dragStartY = e.getY();
			System.out.println("dX: " + Integer.toString(deltaX));
			System.out.println("dY: " + Integer.toString(deltaY));
			System.out.println();
			new Translater(fenPerspective.getNumFenetre(), deltaX, deltaY);
		}
	}
	
	private class MousePressedListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			dragStartX = e.getX();
			dragStartY = e.getY();
		}
	}
	
	//private void calculerDeltas() {
		//TODO implement 
	//}
}
