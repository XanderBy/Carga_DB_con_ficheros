package vista;

import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Ventana extends JFrame {


	private String nombre;
	private Dimension tamano;

	public Ventana(String nombre, Dimension tamano) throws HeadlessException {
		super();
		this.setNombre(nombre);
		this.setTamano(tamano);
		
		setTitle(this.getNombre());
		setSize(tamano);
		setVisible(true);
	}

	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Dimension getTamano() {
		return tamano;
	}

	public void setTamano(Dimension tamano) {
		this.tamano = tamano;
	}
	
	
}
