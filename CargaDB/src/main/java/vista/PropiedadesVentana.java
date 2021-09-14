package vista;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import componentes.BotonPersonalizado;
import componentes.ComboBoxPersonalizado;
import componentes.TablaPersonalizado;
import configuracion.Configuracion;

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
		ComboBoxPersonalizado comboBox1 = new ComboBoxPersonalizado();
		comboBox1.setId("BASESDEDATOS");
		Configuracion.CargarComboBox(comboBox1,"BASESDEDATOSPERMITIDAS");
		tab.add(comboBox1);
		comboBox1.addActionListener(tab);
		
		
	}

	public static void DependienteComboBox() {

	}

	public static void PropiedadesTablas(Tab tab) {
		// for (TablaPersonalizado tabla : tab.getListaTablas()) {
		tab.setTablaDatos(new TablaPersonalizado());
		tab.getTablaDatos().setId("DATOSACARGAR");
		
		JScrollPane scroll = new JScrollPane(tab.getTablaDatos());
		tab.getTablaDatos().setScroll(scroll);
		tab.add(tab.getTablaDatos(), "cell 0 1 4 1");
		tab.add(scroll, "cell 0 1 4 1");
		// }
	}

	public static void DependienteTablas() {

	}
}
