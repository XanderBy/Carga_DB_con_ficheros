package configuracion;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
		
		Ventana ventana=new Ventana("Prueba", new Dimension(500, 500),listaBotones);
		
	}
	public void CargarBotonesConfigurados(Properties properties) {

		JButton boton;
		String nombre= new String();
		int numeroBotones, posicionX, posicionY,ancho,alto;
		
		numeroBotones= Integer.parseInt((String) properties.get("NUMEROBOTONESVENTANAPRINCIPAL")) ;
		listaBotones= new ArrayList<>();
		for (int i = 0; i < numeroBotones; i++) {
			nombre=(String) properties.get(("NOMBREBOTON"+Integer.toString(i)));
			
			boton=new JButton(nombre);
			
			posicionX=Integer.parseInt((String) properties.get("POSICIONXBOTON"+Integer.toString(i))) ;
			posicionY=Integer.parseInt((String) properties.get("POSICIONYBOTON"+Integer.toString(i))) ;
			ancho=Integer.parseInt((String) properties.get("TAMANOANCHOBOTON"+Integer.toString(i))) ;
			alto=Integer.parseInt((String) properties.get("TAMANOALTOBOTON"+Integer.toString(i))) ;
			boton.setBounds(posicionX,posicionY,ancho,alto);
			
			System.out.println(boton.getBounds());
			listaBotones.add(boton);
		}
		
	}
	
}
