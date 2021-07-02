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

	public static void CargarConfiguracion(ArrayList<JButton> listaBotones, ArrayList<JLabel> listaLabels,
			ArrayList<JTextField> listaCajaTexto, ArrayList<JComboBox<String>> listaTComboBox,
			ArrayList<JTable> listaTablas) {

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
			boolean tieneDatos, ArrayList<JButton> listaBotones, ArrayList<JLabel> listaLabels,
			ArrayList<JTextField> listaCajaTexto, ArrayList<JComboBox<String>> listaTComboBox,
			ArrayList<JTable> listaTablas) {
		JButton boton = null;
		JTable tabla = null;
		JComboBox<String> comboBox = null;
		JLabel label = null;
		JTextField textField = null;

		String nombre, id = new String();
		int numeroBotones, posicionX, posicionY, ancho, alto;

		numeroBotones = Integer.parseInt((String) properties.get(numero));

		for (int i = 0; i < numeroBotones; i++) {
			nombre = (String) properties.get(("NOMBRE" + objeto + Integer.toString(i)));
			id = (String) properties.get(("ID" + objeto + Integer.toString(i)));
			switch (objeto) {
			case "BOTON": {
				boton = new JButton(nombre);
				break;
			}
			case "LABELS": {
				label = new JLabel(nombre);
				break;
			}
			case "TEXTFIELD": {
				textField = new JTextField();
				break;
			}
			case "COMBOBOX": {
				comboBox = new JComboBox<String>();
				CargarComboBox(comboBox, objeto, i);
				break;
			}
			case "TABLA": {
				tabla = new JTable();
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
				boton.setName(id);
				break;
			}
			case "LABELS": {
				label.setBounds(posicionX, posicionY, ancho, alto);
				break;
			}
			case "TEXTFIELD": {
				textField.setBounds(posicionX, posicionY, ancho, alto);
				break;
			}
			case "COMBOBOX": {
				comboBox.setBounds(posicionX, posicionY, ancho, alto);
				break;
			}
			case "TABLA": {
				tabla.setBounds(posicionX, posicionY, ancho, alto);
				break;
			}
			}

			SwitchAddListas(objeto, boton, tabla, comboBox, label, textField, listaBotones, listaLabels, listaCajaTexto,
					listaTComboBox, listaTablas);

		}
	}

	public static void SwitchAddListas(String objeto, JButton boton, JTable tabla, JComboBox<String> comboBox,
			JLabel label, JTextField textField, ArrayList<JButton> listaBotones, ArrayList<JLabel> listaLabels,
			ArrayList<JTextField> listaCajaTexto, ArrayList<JComboBox<String>> listaTComboBox,
			ArrayList<JTable> listaTablas) {
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

	public static void CargarComboBox(JComboBox<String> comboBox, String objeto, int numero) {
		String nombreLista = (String) properties.get("DATOCARGADO" + objeto + numero);
		String[] listado = ((String) properties.get(nombreLista)).split(",");

		for (String eleccion : listado) {
			comboBox.addItem(eleccion);
		}
	}

}
