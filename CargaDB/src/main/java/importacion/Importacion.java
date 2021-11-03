package importacion;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import conexion.Conexion;
import estructura.datos.EstructuraDatosImportacionTabla;
import tipo.ficheros.Excel;

public class Importacion {

	private String nombreTabla;

	public DefaultTableModel CargarDatosJTable(ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla) {

		// DefaultTableModel modelo= new DefaultTableModel();
		Object[] Cabecera = new Object[listaTipoDatosTabla.size()];
		int contadorCabecera = 0;
		int contadorDatos = 0;
		int maxDatos = 0;

		for (EstructuraDatosImportacionTabla estructuraDatosImportacionTabla : listaTipoDatosTabla) {
			if (maxDatos < estructuraDatosImportacionTabla.getListadoDatos().size()) {
				maxDatos = estructuraDatosImportacionTabla.getListadoDatos().size();
			}
		}

		Object[][] datos = new Object[maxDatos][listaTipoDatosTabla.size()];

		for (EstructuraDatosImportacionTabla estructuraDatosImportacionTabla : listaTipoDatosTabla) {
			System.out.println(estructuraDatosImportacionTabla.getNombreCampo());

			Cabecera[contadorCabecera] = estructuraDatosImportacionTabla.getNombreCampo();

			for (String dato : estructuraDatosImportacionTabla.getListadoDatos()) {
				datos[contadorDatos][contadorCabecera] = dato;
				contadorDatos++;
			}
			contadorDatos = 0;
			contadorCabecera++;
		}
		DefaultTableModel modelo = new DefaultTableModel(datos, Cabecera) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		return modelo;
	}

	public ArrayList<EstructuraDatosImportacionTabla> ImportarFichero(String[] listadoExtensionesPermitidas,
			Conexion conexionDB, ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla) {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter(null, listadoExtensionesPermitidas);
		fileChooser.setFileFilter(filtroExtension);
		int resultado = fileChooser.showOpenDialog(fileChooser);
		String ruta = new String();

		if (resultado == JFileChooser.APPROVE_OPTION) {
			String extensionElegida = new String(), nombreFichero = new String();
			try {
				File fichero = fileChooser.getSelectedFile();
				nombreFichero = fichero.getName();

				String[] listaAuxiliarExtension = nombreFichero.split("\\.");
				extensionElegida = listaAuxiliarExtension[listaAuxiliarExtension.length - 1];
				this.nombreTabla = fichero.getName().replace(("." + extensionElegida), "");

				ruta = fichero.getAbsolutePath();

			} catch (Exception e) {
				e.getStackTrace();

			}
			listaTipoDatosTabla = ImportarPorTipo(extensionElegida, nombreTabla, conexionDB, listaTipoDatosTabla, ruta);
		}

		return listaTipoDatosTabla;
	}

	public ArrayList<EstructuraDatosImportacionTabla> ImportarPorTipo(String tipo, String nombreTabla,
			Conexion conexionDB, ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla, String ruta) {
		System.out.println("El nombre de la tabla es: " + nombreTabla);
		String[][] datosExcel = null;
		switch (tipo) {
			case "xlsx": {
				listaTipoDatosTabla = conexionDB.mysql.ObtenerDatosBasicosTabla(nombreTabla, listaTipoDatosTabla);
				datosExcel = Excel.ObtenerDatosExcel(new File(ruta));
				listaTipoDatosTabla = ValidarDatos(datosExcel, listaTipoDatosTabla);
				break;
			}
			case "txt":
				
				break;
		}

		return listaTipoDatosTabla;

	}

	public ArrayList<EstructuraDatosImportacionTabla> ValidarDatos(String[][] datosExcel,
			ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla) {
		int contadorColumna = 0;

		for (EstructuraDatosImportacionTabla estructuraDatosImportacionTabla : listaTipoDatosTabla) {

			if (datosExcel[contadorColumna][0].equalsIgnoreCase(estructuraDatosImportacionTabla.getNombreCampo())) {
				for (int y = 1; y < datosExcel[contadorColumna].length; y++) {
					// Comprobar si se puede convertir el dato al tipo de la columna
					estructuraDatosImportacionTabla.getListadoDatos().add(datosExcel[contadorColumna][y]);

				}
			}

			contadorColumna++;
		}
		return listaTipoDatosTabla;
	}

	public boolean ComprobarTipoDato(String tipoDato, String dato) {
		/*
		 * ArrayList<String> tipoValorInt = new ArrayList<>(Arrays.asList("INT",
		 * "NUMBER")); ArrayList<String> tipoValorDecimal = new
		 * ArrayList<>(Arrays.asList("DECIMAL")); ArrayList<String> tipoValorBool = new
		 * ArrayList<>(Arrays.asList("BINARY"));
		 */
		boolean res = true;
		try {

		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	public String getNombreTabla() {
		return nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
}
