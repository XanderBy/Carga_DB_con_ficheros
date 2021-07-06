package componentes;

import javax.swing.JComboBox;

public class ComboBoxPersonalizado extends JComboBox<String> {

	private double posicionX;
	private double posicionY;

	public ComboBoxPersonalizado() {
		super();
	}

	public ComboBoxPersonalizado(double posicionX, double posicionY) {
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
