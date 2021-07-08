package componentes;

import javax.swing.JTable;

public class TablaPersonalizado extends JTable {

	private double posicionX;
	private double posicionY;
	private double ancho;
	private double alto;

	public TablaPersonalizado() {
		super();
	}

	
	

	public TablaPersonalizado(double posicionX, double posicionY, double ancho, double alto) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.ancho = ancho;
		this.alto = alto;
	}




	public double getAncho() {
		return ancho;
	}



	public void setAncho(double ancho) {
		this.ancho = ancho;
	}



	public double getAlto() {
		return alto;
	}



	public void setAlto(double alto) {
		this.alto = alto;
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
