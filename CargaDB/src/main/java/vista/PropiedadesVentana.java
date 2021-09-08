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

		BotonPersonalizado boton1 = new BotonPersonalizado();
		boton1.setText("Conexión");
		boton1.setId("CONECTAR");
		boton1.setDependeComponente("BASESDEDATOS");
		boton1.setEnabled(false);
		tab.add(boton1, "cell 2 0");
		boton1.addActionListener(tab);
		
		BotonPersonalizado boton2 = new BotonPersonalizado();
		boton2.setText("Importar Fichero");
		boton2.setId("IMPORTARFICHERO");
		boton2.setDependeComponente("CONECTAR");
		boton2.setEnabled(false);
		tab.add(boton2, "cell 2 0");
		boton2.addActionListener(tab);
		
		
		BotonPersonalizado boton3 = new BotonPersonalizado();
		boton3.setText("Cargar Datos");
		boton3.setId("CARGADATOS");
		boton3.setDependeComponente("IMPORTARFICHERO");
		boton3.setEnabled(false);
		tab.add(boton3, "cell 2 0");
		boton3.addActionListener(tab);
		

	}

	public static void DependienteBotones() {

	}

	public static void PropiedadesTitulos(Tab tab) {
		

	}

	public static void DependienteTitulos() {

	}

	public static void PropiedadesCajaText(Tab tab) {
		
	}

	public static void DependienteCajaText() {

	}

	public static void PropiedadesComboBox(Tab tab) {
		ComboBoxPersonalizado comboBox = new ComboBoxPersonalizado();
		comboBox.setId("BASESDEDATOS");
		CargarComboBox(comboBox, objeto, i);
		tab.add(comboBox);
		comboBox.addActionListener(tab);
		
		
	}

	public static void DependienteComboBox() {

	}

	public static void PropiedadesTablas(Tab tab) {
		// for (TablaPersonalizado tabla : tab.getListaTablas()) {
		JScrollPane scroll = new JScrollPane(tab.getListaTablas().get(0));
		tab.getListaTablas().get(0).setScroll(scroll);
		tab.add(tab.getListaTablas().get(0), "cell 0 1 4 1");
		tab.add(scroll, "cell 0 1 4 1");
		// }
	}

	public static void DependienteTablas() {

	}
}
