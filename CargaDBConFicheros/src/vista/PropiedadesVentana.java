package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PropiedadesVentana {

	public static void PropiedadesVentana(Ventana vista) {

	}

	public static void PropiedadesBotones(Tab tab) {
		for (JButton boton : tab.getListaBotones()) {
			tab.add(boton);
			boton.addActionListener(tab);
		}

	}

	public static void DependienteBotones() {

	}

	public static void PropiedadesTitulos(Tab tab) {
		for (JLabel titulo : tab.getListaTitulos()) {
			tab.add(titulo);
		}

	}

	public static void DependienteTitulos() {

	}

	public static void PropiedadesCajaText(Tab tab) {
		for (JTextField textField : tab.getListaCajaTexto()) {
			tab.add(textField);
		}
	}

	public static void DependienteCajaText() {

	}

	public static void PropiedadesComboBox(Tab tab) {
		for (JComboBox<String> comboBox : tab.getListaTComboBox()) {
			tab.add(comboBox);
		}
	}

	public static void DependienteComboBox() {

	}

	public static void PropiedadesTablas(Tab tab) {
		for (JTable tabla : tab.getListaTablas()) {
			tab.add(tabla);
		}
	}

	public static void DependienteTablas() {

	}
}
