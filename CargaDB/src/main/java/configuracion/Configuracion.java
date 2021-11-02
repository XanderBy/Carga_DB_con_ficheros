package configuracion;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ComboBoxEditor;

import componentes.BotonPersonalizado;
import componentes.ComboBoxPersonalizado;
import componentes.LabelPersonalizado;
import componentes.TablaPersonalizado;
import componentes.TextFieldPersonalizado;
import vista.PropiedadesVentana;
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
				Integer.parseInt((String) properties.get("NUMEROMAXTABS")), new Point(0, 0));
	}

	public static void CargarConfiguracion(Tab tab) {

		PropiedadesVentana.PropiedadesBotones(tab);
		PropiedadesVentana.PropiedadesTitulos(tab);
		PropiedadesVentana.PropiedadesCajaText(tab);
		PropiedadesVentana.PropiedadesComboBox(tab);
		PropiedadesVentana.PropiedadesTablas(tab);

	}

	public static String[] CargarLista(String nombre, boolean comboBox) {
		String[] listado = null;

		if (comboBox) {
			String nombreLista = (String) properties.get(nombre);
			listado = nombreLista.split(",");
		} else {
			listado = ((String) properties.get(nombre)).split(",");
		}

		return listado;
	}

	public static void CargarComboBox(ComboBoxPersonalizado comboBox, String objeto) {
		String[] listado = CargarLista(objeto, true);
		comboBox.removeAllItems();
		for (String eleccion : listado) {
			if (comboBox.getItemCount() == 0) {
				comboBox.addItem("");
			}

			comboBox.addItem(eleccion);
		}
	}

	
	public static void ActivarComponentes(String IdComponente, boolean activar, boolean noDepende,
			ArrayList<BotonPersonalizado> listaBotones, ArrayList<LabelPersonalizado> listaLabels,
			ArrayList<TextFieldPersonalizado> listaCajaTexto, ArrayList<ComboBoxPersonalizado> listaTComboBox,
			ArrayList<TablaPersonalizado> listaTablas) {
		if(listaBotones!=null) {
			for (BotonPersonalizado boton : listaBotones) {
				if (noDepende) {
					if (boton.getId().equalsIgnoreCase(IdComponente)) {
						boton.setEnabled(activar);
					}
				} else {
					if (boton.getDependeComponente() != null
							&& boton.getDependeComponente().equalsIgnoreCase(IdComponente)) {
						boton.setEnabled(activar);
					}
				}

			}
		}
		
		if(listaTComboBox!=null) {
			for (ComboBoxPersonalizado combo : listaTComboBox) {
				if (noDepende) {
					if (combo.getId().equalsIgnoreCase(IdComponente)) {
						combo.setEnabled(activar);
					}
				} else {
					if (combo.getDependeComponente() != null
							&& combo.getDependeComponente().equalsIgnoreCase(IdComponente)) {
						combo.setEnabled(activar);
					}
				}

			}
		}
		

	}
}
