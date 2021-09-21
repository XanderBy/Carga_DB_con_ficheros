package configuracion;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
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

		for (String eleccion : listado) {
			if (comboBox.getItemCount() == 0) {
				comboBox.addItem("");
			}

			comboBox.addItem(eleccion);
		}
	}

	// Sobre 100 que llega por parametro lo trataremos para ponerlo en la ventana de
	// una manera que dependa del ancho y alto de la ventana
	public static void OtorgarPosicion() {
		/*
		int anchoVentana = ventana.getWidth();
		int altoVentana = ventana.getHeight();

		double anchoComponente = 0, altoComponente = 0;
		double valorX = 0, valorY = 0;
		
		for (Tab tab : ventana.getPanelTabs().getListaTabs()) {
			valorX = anchoVentana * (tab.getTablaDatos().getPosicionX() / 100);
			valorY = altoVentana * (tab.getTablaDatos().getPosicionY() / 100);
			anchoComponente = anchoVentana * (tab.getTablaDatos().getAncho() / 100);
			altoComponente = altoVentana * (tab.getTablaDatos().getAlto() / 100);

			tab.getTablaDatos().setBounds((int) valorX, (int) valorY, (int) anchoComponente,
					(int) altoComponente);
			tab.remove(tab.getTablaDatos().getScroll());
			tab.getTablaDatos().getScroll().setViewportView(tab.getTablaDatos());
			tab.add(tab.getTablaDatos().getScroll());
		}
		*/
/*
		int anchoVentana = ventana.getWidth();
		int altoVentana = ventana.getHeight();

		double anchoComponente = 0, altoComponente = 0;
		double valorX = 0, valorY = 0;
		for (Tab tab : ventana.getPanelTabs().getListaTabs()) {

			for (BotonPersonalizado boton : tab.getListaBotones()) {
				valorX = anchoVentana * (boton.getPosicionX() / 100);
				valorY = altoVentana * (boton.getPosicionY() / 100);
				anchoComponente = anchoVentana * (boton.getAncho() / 100);
				altoComponente = altoVentana * (boton.getAlto() / 100);
				boton.setBounds((int) valorX, (int) valorY, boton.getWidth(), boton.getHeight());
			}

			for (ComboBoxPersonalizado comboBox : tab.getListaTComboBox()) {

				valorX = anchoVentana * (comboBox.getPosicionX() / 100);
				valorY = altoVentana * (comboBox.getPosicionY() / 100);
				comboBox.setBounds((int) valorX, (int) valorY, comboBox.getWidth(), comboBox.getHeight());
			}

			for (TextFieldPersonalizado textField : tab.getListaCajaTexto()) {

				valorX = anchoVentana * (textField.getPosicionX() / 100);
				valorY = altoVentana * (textField.getPosicionY() / 100);
				textField.setBounds((int) valorX, (int) valorY, textField.getWidth(), textField.getHeight());
			}

			// for (TablaPersonalizado tabla : tab.getListaTablas()) {

			valorX = anchoVentana * (tab.getListaTablas().get(0).getPosicionX() / 100);
			valorY = altoVentana * (tab.getListaTablas().get(0).getPosicionY() / 100);
			anchoComponente = anchoVentana * (tab.getListaTablas().get(0).getAncho() / 100);
			altoComponente = altoVentana * (tab.getListaTablas().get(0).getAlto() / 100);

			tab.getListaTablas().get(0).setBounds((int) valorX, (int) valorY, (int) anchoComponente,
					(int) altoComponente);
			tab.remove(tab.getListaTablas().get(0).getScroll());
			tab.getListaTablas().get(0).getScroll().setViewportView(tab.getListaTablas().get(0));
			tab.add(tab.getListaTablas().get(0).getScroll());

			// }

			for (LabelPersonalizado label : tab.getListaTitulos()) {

				valorX = anchoVentana * (label.getPosicionX() / 100);
				valorY = altoVentana * (label.getPosicionY() / 100);
				label.setBounds((int) valorX, (int) valorY, label.getWidth(), label.getHeight());
			}

			tab.repaint();
		}
*/
	}

	public static void ActivarComponentes(String IdComponente, boolean activar, boolean noDepende,
			ArrayList<BotonPersonalizado> listaBotones, ArrayList<LabelPersonalizado> listaLabels,
			ArrayList<TextFieldPersonalizado> listaCajaTexto, ArrayList<ComboBoxPersonalizado> listaTComboBox,
			ArrayList<TablaPersonalizado> listaTablas) {

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
}
