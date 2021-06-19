package configuracion;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;

import vista.Ventana;

public class Configuracion {

	ArrayList<JButton> listaBotones;
	
	public void CargarConfiguracion() {
		
		Ventana ventana=new Ventana("Prueba", new Dimension(100, 100),listaBotones);
		
	}
	public void CargarBotonesConfigurados() {
		
	}
	
}
