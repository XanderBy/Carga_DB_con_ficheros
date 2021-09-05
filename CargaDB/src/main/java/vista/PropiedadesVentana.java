package vista;


import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import componentes.BotonPersonalizado;
import componentes.ComboBoxPersonalizado;

public class PropiedadesVentana {

	public PropiedadesVentana(Ventana vista) {

	}

	public static void PropiedadesBotones(Tab tab) {
		for (BotonPersonalizado boton : tab.getListaBotones()) {
			if (boton.getDependeComponente() != null && boton.getDependeComponente().length() > 0) {
				boton.setEnabled(false);
			}
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
		for (ComboBoxPersonalizado comboBox : tab.getListaTComboBox()) {
			tab.add(comboBox);
			comboBox.addActionListener(tab);
		}
	}

	public static void DependienteComboBox() {

	}

	public static void PropiedadesTablas(Tab tab) {
		//for (TablaPersonalizado tabla : tab.getListaTablas()) {
			JScrollPane scroll=new JScrollPane(tab.getListaTablas().get(0));
			tab.getListaTablas().get(0).setScroll(scroll);
			tab.add(tab.getListaTablas().get(0));
			tab.add(scroll);
		//}
	}

	public static void DependienteTablas() {

	}
}
