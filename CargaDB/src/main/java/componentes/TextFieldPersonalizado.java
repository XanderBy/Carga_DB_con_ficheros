package componentes;

import javax.swing.JTextField;

public class TextFieldPersonalizado extends JTextField {

	private double posicionX;
	private double posicionY;
	
	
	public TextFieldPersonalizado() {
		super();
	}

	public TextFieldPersonalizado(double posicionX, double posicionY) {
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
