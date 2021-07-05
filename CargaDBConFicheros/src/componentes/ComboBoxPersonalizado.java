package componentes;

import javax.swing.JComboBox;

public class ComboBoxPersonalizado extends JComboBox<String> {

	private int posicionX;
	private int posicionY;

	public ComboBoxPersonalizado() {
		super();
	}

	public ComboBoxPersonalizado(int posicionX, int posicionY) {
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
