package componentes;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TablaPersonalizado extends JTable {

	private double posicionX;
	private double posicionY;
	private double ancho;
	private double alto;
	private String id;

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

}
