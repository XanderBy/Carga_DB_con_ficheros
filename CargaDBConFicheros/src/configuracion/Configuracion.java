package configuracion;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import vista.Ventana;

public class Configuracion {

	Properties properties = new Properties();
	ArrayList<JButton> listaBotones=new ArrayList<>();
	ArrayList<JTable> listaTablas=new ArrayList<>();
	ArrayList<JComboBox<String>> listaComboBox=new ArrayList<>();
	ArrayList<JLabel> listaLabels=new ArrayList<>();
	ArrayList<JTextField> listaTextFields=new ArrayList<>();

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

		CargarObjetosConfigurados(properties, "NUMEROBOTONESVENTANAPRINCIPAL","BOTON", false);
		CargarObjetosConfigurados(properties, "NUMEROLABELSVENTANAPRINCIPAL","LABELS", false);
		//CargarBotonesConfigurados(properties);

		Ventana ventana = new Ventana("Prueba", new Dimension(500, 500), listaBotones,listaLabels);

	}

	public void CargarObjetosConfigurados(Properties properties, String numero, String objeto, boolean tieneDatos) {
		JButton boton=null;
		JTable tabla=null;
		JComboBox<String> comboBox=null;
		JLabel label=null;
		JTextField textField=null;
		
		
		String nombre,id = new String();
		int numeroBotones, posicionX, posicionY, ancho, alto;

		numeroBotones = Integer.parseInt((String) properties.get(numero));
		
		for (int i = 0; i < numeroBotones; i++) {
			nombre = (String) properties.get(("NOMBRE" + objeto + Integer.toString(i)));
			id=(String) properties.get(("ID"+objeto+ Integer.toString(i)));
			
			switch (objeto) {
			case "BOTON": {
				boton = new JButton(nombre);
			}
			case "LABELS":{
				label = new JLabel(nombre);
			}
			case "TEXTFIELD":{
				textField = new JTextField();
			}
			case "COMBOBOX":{
				comboBox = new JComboBox<>();
			}
			case "TABLA":{
				tabla = new JTable();
			}
			default:
				System.out.println("Default");
			}

			posicionX = Integer.parseInt((String) properties.get("POSICIONX" + objeto + Integer.toString(i)));
			posicionY = Integer.parseInt((String) properties.get("POSICIONY" + objeto + Integer.toString(i)));
			ancho = Integer.parseInt((String) properties.get("TAMANOANCHO" + objeto + Integer.toString(i)));
			alto = Integer.parseInt((String) properties.get("TAMANOALTO" + objeto + Integer.toString(i)));
			
			switch (objeto) {
			case "BOTON": {
				boton.setBounds(posicionX, posicionY, ancho, alto);
				boton.setName(id);
			}
			case "LABELS":{
				label.setBounds(posicionX, posicionY, ancho, alto);
			}
			case "TEXTFIELD":{
				textField.setBounds(posicionX, posicionY, ancho, alto);
			}
			case "COMBOBOX":{
				comboBox.setBounds(posicionX, posicionY, ancho, alto);
			}
			case "TABLA":{
				tabla.setBounds(posicionX, posicionY, ancho, alto);
			}
			default:
				System.out.println("Default");
			}
			
			
			SwitchAddListas(objeto, boton,tabla,comboBox,label,textField);
			
		}
	}
	public void SwitchAddListas(String objeto,JButton boton,JTable tabla,JComboBox<String> comboBox,JLabel label,JTextField textField) {
		switch (objeto) {
		case "BOTON": {
			listaBotones.add(boton);
		}
		case "LABELS":{
			listaLabels.add(label);
			System.out.println("lABEL");
		}
		case "TEXTFIELD":{
			listaTextFields.add(textField);
		}
		case "COMBOBOX":{
			listaComboBox.add(comboBox);
		}
		case "TABLA":{
			listaTablas.add(tabla);
		}
		default:
			System.out.println("Default");
		}
	}
	

}
