package componentes;

import javax.swing.JButton;

public class BotonPersonalizado extends JButton {

	private double posicionX;
	private double posicionY;
	private double ancho;
	private double alto;
	private String dependeComponente;
	private String Id;

	public BotonPersonalizado() {
		super();
	}

	public BotonPersonalizado(double posicionX, double posicionY, double ancho, double alto) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.ancho = ancho;
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

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public String getDependeComponente() {
		return dependeComponente;
	}

	public void setDependeComponente(String dependeComponente) {
		this.dependeComponente = dependeComponente;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

}
