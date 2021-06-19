package configuracion;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.JButton;

import vista.Ventana;

public class Configuracion {

	Properties properties= new Properties();
	ArrayList<JButton> listaBotones;
	
	public void CargarConfiguracion() {
		try {
			properties.load(new FileInputStream(new File("resources/config.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CargarBotonesConfigurados(properties);
		
		Ventana ventana=new Ventana("Prueba", new Dimension(100, 100),listaBotones);
		
	}
	public void CargarBotonesConfigurados(Properties properties) {

		JButton boton;
		String nombre= new String();
		int numeroBotones= Integer.parseInt((String) properties.get("NUMEROBOTONESVENTANAPRINCIPAL")) ;
		listaBotones= new ArrayList<>();
		for (int i = 0; i < numeroBotones; i++) {
			nombre=(String) properties.get(("NOMBREBOTON"+Integer.toString(i)));
			boton=new JButton(nombre);
			listaBotones.add(boton);
		}
		
	}
	
}
