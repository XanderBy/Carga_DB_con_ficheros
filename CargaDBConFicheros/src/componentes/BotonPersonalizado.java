package componentes;

import javax.swing.JButton;

public class BotonPersonalizado extends JButton {

	private double posicionX;
	private double posicionY;
	
	
	
	public BotonPersonalizado() {
		super();
	}
	
	public BotonPersonalizado(double posicionX, double posicionY) {
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
