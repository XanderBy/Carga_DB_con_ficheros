package componentes;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablaPersonalizado extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double posicionX;
	private double posicionY;
	private double ancho;
	private double alto;
	private String id;
	private JScrollPane scroll;

	public TablaPersonalizado() {
		super();
		
		//this.setModel(new AbstractTableModel());
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




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public JScrollPane getScroll() {
		return scroll;
	}




	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

}
