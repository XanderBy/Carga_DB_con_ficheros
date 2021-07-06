package componentes;

import javax.swing.JLabel;

public class LabelPersonalizado extends JLabel {

	private double posicionX;
	private double posicionY;

	public LabelPersonalizado() {
		super();
	}

	public LabelPersonalizado(double posicionX, double posicionY) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public double getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(double posicionX) {
		this.posicionX = posicionX;
	}

	public double getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(double posicionY) {
		this.posicionY = posicionY;
	}

}
