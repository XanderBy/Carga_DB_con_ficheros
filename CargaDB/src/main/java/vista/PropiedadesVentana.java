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

		tab.setBotonConectarDB(new BotonPersonalizado());
		tab.getBotonConectarDB().setText("Conexión");
		tab.getBotonConectarDB().setId("CONECTAR");
		tab.getBotonConectarDB().setName("CONECTAR");
		tab.getBotonConectarDB().setDependeComponente("BASESDEDATOS");
		tab.getBotonConectarDB().setEnabled(false);
		tab.add(tab.getBotonConectarDB(), "cell 2 0");
		tab.getBotonConectarDB().addActionListener(tab);
		
		tab.setBotonImportarFichero(new BotonPersonalizado());
		tab.getBotonImportarFichero().setText("Importar Fichero");
		tab.getBotonImportarFichero().setName("IMPORTARFICHERO");
		tab.getBotonImportarFichero().setId("IMPORTARFICHERO");
		tab.getBotonImportarFichero().setDependeComponente("CONECTAR");
		tab.getBotonImportarFichero().setEnabled(false);
		tab.add(tab.getBotonImportarFichero(), "cell 2 0");
		tab.getBotonImportarFichero().addActionListener(tab);
		
		
		tab.setBotonCargarDatos(new BotonPersonalizado());
		tab.getBotonCargarDatos().setText("Cargar Datos");
		tab.getBotonCargarDatos().setName("CARGADATOS");
		tab.getBotonCargarDatos().setId("CARGADATOS");
		tab.getBotonCargarDatos().setDependeComponente("IMPORTARFICHERO");
		tab.getBotonCargarDatos().setEnabled(false);
		tab.add(tab.getBotonCargarDatos(), "cell 2 0");
		tab.getBotonCargarDatos().addActionListener(tab);
		

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
		tab.setComboBaseDeDatos(new ComboBoxPersonalizado());
		tab.getComboBaseDeDatos().setId("BASESDEDATOS");
		Configuracion.CargarComboBox(tab.getComboBaseDeDatos(),"BASESDEDATOSPERMITIDAS");
		tab.add(tab.getComboBaseDeDatos());
		tab.getComboBaseDeDatos().addActionListener(tab);
		
		
	}

	public static void DependienteComboBox() {

	}

	public static void PropiedadesTablas(Tab tab) {
		// for (TablaPersonalizado tabla : tab.getListaTablas()) {
		tab.setTablaDatos(new TablaPersonalizado());
		tab.getTablaDatos().setId("DATOSACARGAR");
		
		JScrollPane scroll = new JScrollPane(tab.getTablaDatos());
		tab.getTablaDatos().setScroll(scroll);
		tab.getTablaDatos().getScroll().setViewportView(tab.getTablaDatos());
		tab.add(tab.getTablaDatos(), "cell 0 1 4 1");
		tab.add(tab.getTablaDatos().getScroll(), "cell 0 1 4 1");
		// }
	}

	public static void DependienteTablas() {

	}
}
