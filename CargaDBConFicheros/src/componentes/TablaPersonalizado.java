package componentes;

import javax.swing.JTable;

public class TablaPersonalizado extends JTable {

	private double posicionX;
	private double posicionY;

	public TablaPersonalizado() {
		super();
	}

	public TablaPersonalizado(double posicionX, double posicionY) {
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
