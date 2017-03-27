package vue;

import java.io.Serializable;

import model.Observateur;
import model.Perspective;

public class ObservateurPerspective implements Observateur, Serializable {

	private static final long serialVersionUID = -4681890695676047778L;
	
	private Perspective perspective; //modèle
	
	public ObservateurPerspective(Perspective perspective) {
		this.perspective = perspective;
		perspective.setObservateur(this);
	}

	@Override
	public void update() {
		System.out.println("----------dans ObservateurPerspective.update()------------");
		System.out.println(perspective.getX1());
		System.out.println(perspective.getY1());
		System.out.println(perspective.getX2());
		System.out.println(perspective.getY2());
		System.out.println("-----------------------------------------------------------");
	}

}
