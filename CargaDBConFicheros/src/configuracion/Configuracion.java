package configuracion;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JLabel;

import componentes.BotonPersonalizado;
import componentes.ComboBoxPersonalizado;
import componentes.LabelPersonalizado;
import componentes.TablaPersonalizado;
import componentes.TextFieldPersonalizado;
import vista.Tab;
import vista.Ventana;

public class Configuracion {

	static Properties properties = new Properties();
	public static Ventana ventana;

	public void CreacionVentana() {

		try {
			properties.load(new FileInputStream(new File("resources/config.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ventana = new Ventana("Prueba", new Dimension(500, 500),
				Integer.parseInt((String) properties.get("NUMEROMAXTABS")));
	}

	public static void CargarConfiguracion(ArrayList<BotonPersonalizado> listaBotones, ArrayList<LabelPersonalizado> listaLabels,
			ArrayList<TextFieldPersonalizado> listaCajaTexto, ArrayList<ComboBoxPersonalizado> listaTComboBox,
			ArrayList<TablaPersonalizado> listaTablas) {

		CargarObjetosConfigurados(properties, "NUMEROBOTONESVENTANAPRINCIPAL", "BOTON", false, listaBotones,
				listaLabels, listaCajaTexto, listaTComboBox, listaTablas);
		CargarObjetosConfigurados(properties, "NUMEROLABELSVENTANAPRINCIPAL", "LABELS", false, listaBotones,
				listaLabels, listaCajaTexto, listaTComboBox, listaTablas);
		CargarObjetosConfigurados(properties, "NUMEROTEXTFIELDSVENTANAPRINCIPAL", "TEXTFIELD", false, listaBotones,
				listaLabels, listaCajaTexto, listaTComboBox, listaTablas);
		CargarObjetosConfigurados(properties, "NUMEROCOMBOBOXVENTANAPRINCIPAL", "COMBOBOX", false, listaBotones,
				listaLabels, listaCajaTexto, listaTComboBox, listaTablas);
		CargarObjetosConfigurados(properties, "NUMEROTABLASVENTANAPRINCIPAL", "TABLA", false, listaBotones, listaLabels,
				listaCajaTexto, listaTComboBox, listaTablas);
	}

	public static void CargarObjetosConfigurados(Properties properties, String numero, String objeto,
			boolean tieneDatos, ArrayList<BotonPersonalizado> listaBotones, ArrayList<LabelPersonalizado> listaLabels,
			ArrayList<TextFieldPersonalizado> listaCajaTexto, ArrayList<ComboBoxPersonalizado> listaTComboBox,
			ArrayList<TablaPersonalizado> listaTablas) {
		BotonPersonalizado boton = null;
		TablaPersonalizado tabla = null;
		ComboBoxPersonalizado comboBox = null;
		LabelPersonalizado label = null;
		TextFieldPersonalizado textField = null;

		String nombre, id = new String();
		int numeroBotones, posicionX, posicionY, ancho, alto;

		numeroBotones = Integer.parseInt((String) properties.get(numero));

		for (int i = 0; i < numeroBotones; i++) {
			nombre = (String) properties.get(("NOMBRE" + objeto + Integer.toString(i)));
			id = (String) properties.get(("ID" + objeto + Integer.toString(i)));
			switch (objeto) {
			case "BOTON": {
				boton = new BotonPersonalizado();
				boton.setText(nombre);
				break;
			}
			case "LABELS": {
				label = new LabelPersonalizado();
				label.setText(nombre);
				break;
			}
			case "TEXTFIELD": {
				textField = new TextFieldPersonalizado();
				break;
			}
			case "COMBOBOX": {
				comboBox = new ComboBoxPersonalizado();
				CargarComboBox(comboBox, objeto, i);
				break;
			}
			case "TABLA": {
				tabla = new TablaPersonalizado();
				break;
			}
			}

			posicionX = Integer.parseInt((String) properties.get("POSICIONX" + objeto + Integer.toString(i)));
			posicionY = Integer.parseInt((String) properties.get("POSICIONY" + objeto + Integer.toString(i)));
			ancho = Integer.parseInt((String) properties.get("TAMANOANCHO" + objeto + Integer.toString(i)));
			alto = Integer.parseInt((String) properties.get("TAMANOALTO" + objeto + Integer.toString(i)));

			switch (objeto) {
			case "BOTON": {
				boton.setBounds(posicionX, posicionY, ancho, alto);
				boton.setPosicionX(posicionX);
				boton.setPosicionY(posicionY);
				boton.setName(id);
				break;
			}
			case "LABELS": {
				label.setBounds(posicionX, posicionY, ancho, alto);
				label.setPosicionX(posicionX);
				label.setPosicionY(posicionY);
				break;
			}
			case "TEXTFIELD": {
				textField.setBounds(posicionX, posicionY, ancho, alto);
				textField.setPosicionX(posicionX);
				textField.setPosicionY(posicionY);
				break;
			}
			case "COMBOBOX": {
				comboBox.setBounds(posicionX, posicionY, ancho, alto);
				comboBox.setPosicionX(posicionX);
				comboBox.setPosicionY(posicionY);
				break;
			}
			case "TABLA": {
				tabla.setBounds(posicionX, posicionY, ancho, alto);
				tabla.setPosicionX(posicionX);
				tabla.setPosicionY(posicionY);
				break;
			}
			}

			SwitchAddListas(objeto, boton, tabla, comboBox, label, textField, listaBotones, listaLabels, listaCajaTexto,
					listaTComboBox, listaTablas);

		}
	}

	public static void SwitchAddListas(String objeto, BotonPersonalizado boton, TablaPersonalizado tabla, ComboBoxPersonalizado comboBox,
			LabelPersonalizado label, TextFieldPersonalizado textField, ArrayList<BotonPersonalizado> listaBotones, ArrayList<LabelPersonalizado> listaLabels,
			ArrayList<TextFieldPersonalizado> listaCajaTexto, ArrayList<ComboBoxPersonalizado> listaTComboBox,
			ArrayList<TablaPersonalizado> listaTablas) {
		switch (objeto) {
		case "BOTON": {
			listaBotones.add(boton);
			break;
		}
		case "LABELS": {
			listaLabels.add(label);
			break;
		}
		case "TEXTFIELD": {
			listaCajaTexto.add(textField);
			break;
		}
		case "COMBOBOX": {

			listaTComboBox.add(comboBox);
			break;
		}
		case "TABLA": {
			listaTablas.add(tabla);
			break;
		}
		}
	}

	public static void CargarComboBox(ComboBoxPersonalizado comboBox, String objeto, int numero) {
		String nombreLista = (String) properties.get("DATOCARGADO" + objeto + numero);
		String[] listado = ((String) properties.get(nombreLista)).split(",");

		for (String eleccion : listado) {
			comboBox.addItem(eleccion);
		}
	}

	// Sobre 100 que llega por parametro lo trataremos para ponerlo en la ventana de
	// una manera que dependa del ancho y alto de la ventana
	public static void OtorgarPosicion(Ventana vista) {
		
		int anchoVentana=vista.getWidth();
		int altoVentana=vista.getHeight();
		
		double valorX=0;
		System.out.println("Ancho: "+anchoVentana);
		for (Tab tab : vista.getPanelTabs().getListaTabs()) {
			for (BotonPersonalizado boton : tab.getListaBotones()) {
				valorX=anchoVentana*(boton.getPosicionX()/100);
				System.out.println("Nueva Posicion"+ boton.getPosicionX());
				System.out.println("Nuevo valor"+ (boton.getPosicionX()/100));
				boton.setBounds((int)  valorX,(int) (altoVentana*(boton.getPosicionY()/100)),100,100);
				System.out.println("PosicionX "+(anchoVentana*(boton.getPosicionX()/100)));
			}
			
			System.out.println(tab.getListaBotones().get(0).getPosicionX());
			System.out.println(tab.getListaBotones().get(0).getBounds());
			tab.repaint();
		}
		
	}
}
