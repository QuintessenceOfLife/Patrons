package vue;

import java.io.Serializable;

import model.Observateur;
import model.Vignette;

public class ObservateurVignette implements Observateur, Serializable {
	
	private static final long serialVersionUID = -5146770680951693576L;
	
	private Vignette vignette;
	
	public ObservateurVignette(Vignette vignette) {
		this.vignette = vignette;
	}

	@Override
	public void update() {		
		System.out.println("----------dans ObservateurVignette.update()------------");
		System.out.println(vignette.getFichierImage().toString());
		System.out.println("-----------------------------------------------------------");
	}

}
