package componentes;

import javax.swing.JTextField;

public class TextFieldPersonalizado extends JTextField {

	private int posicionX;
	private int posicionY;
	
	
	public TextFieldPersonalizado() {
		super();
	}

	public TextFieldPersonalizado(int posicionX, int posicionY) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	
	public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	
	
	
}
