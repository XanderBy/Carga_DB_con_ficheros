package vista;

import javax.swing.JScrollPane;
import componentes.BotonPersonalizado;
import componentes.ComboBoxPersonalizado;
import componentes.TablaPersonalizado;
import configuracion.Configuracion;
import net.miginfocom.swing.MigLayout;

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
		tab.add(tab.getBotonConectarDB(), "cell 2 1");
		tab.getBotonConectarDB().addActionListener(tab);
		
		tab.setBotonImportarFichero(new BotonPersonalizado());
		tab.getBotonImportarFichero().setText("Importar Fichero");
		tab.getBotonImportarFichero().setName("IMPORTARFICHERO");
		tab.getBotonImportarFichero().setId("IMPORTARFICHERO");
		tab.getBotonImportarFichero().setDependeComponente("CONECTAR");
		tab.getBotonImportarFichero().setEnabled(false);
		tab.add(tab.getBotonImportarFichero(), "cell 4 1");
		tab.getBotonImportarFichero().addActionListener(tab);
		
		
		tab.setBotonCargarDatos(new BotonPersonalizado());
		tab.getBotonCargarDatos().setText("Cargar Datos");
		tab.getBotonCargarDatos().setName("CARGADATOS");
		tab.getBotonCargarDatos().setId("CARGADATOS");
		tab.getBotonCargarDatos().setDependeComponente("IMPORTARFICHERO");
		tab.getBotonCargarDatos().setEnabled(false);
		tab.add(tab.getBotonCargarDatos(), "cell 4 2");
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
		tab.add(tab.getComboBaseDeDatos(),"cell 2 2");
		tab.getComboBaseDeDatos().addActionListener(tab);
		
		
	}

	public static void DependienteComboBox() {

	}

	public static void PropiedadesTablas(Tab tab) {
		// for (TablaPersonalizado tabla : tab.getListaTablas()) {
		tab.setTablaDatos(new TablaPersonalizado());
		tab.getTablaDatos().setId("DATOSACARGAR");
		tab.getTablaDatos().setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(tab.getTablaDatos());
		tab.getTablaDatos().setScroll(scroll);
		tab.add(tab.getTablaDatos().getScroll(), "cell 0 4 6 2,grow");
		// }
	}

	public static void DependienteTablas() {

	}
}
