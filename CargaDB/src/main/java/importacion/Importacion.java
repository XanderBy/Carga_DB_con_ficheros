package importacion;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import conexion.Conexion;
import estructura.datos.EstructuraDatosImportacionTabla;
import tipo.ficheros.Excel;

public class Importacion {

	public static boolean ImportarFichero(String[] listadoExtensionesPermitidas, Conexion conexionDB, ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla) {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter(null, listadoExtensionesPermitidas);
		fileChooser.setFileFilter(filtroExtension);
		int resultado = fileChooser.showOpenDialog(fileChooser);
		String ruta=new String();

		if (resultado == JFileChooser.APPROVE_OPTION) {
			String extensionElegida, nombreTabla, nombreFichero = new String();
			try {
				File fichero=fileChooser.getSelectedFile();
				nombreFichero=fichero.getName();
				
				String[] listaAuxiliarExtension = nombreFichero.split("\\.");
				extensionElegida = listaAuxiliarExtension[listaAuxiliarExtension.length - 1];
				nombreTabla=fichero.getName().replace(("."+extensionElegida), "");
				
				ruta=fichero.getAbsolutePath();
				
			} catch (Exception e) {
				e.getStackTrace();
				return false;
			}
			ImportarPorTipo(extensionElegida,nombreTabla,conexionDB,listaTipoDatosTabla,ruta);
		}

		return false;
	}

	public static void ImportarPorTipo(String tipo, String nombreTabla, Conexion conexionDB, ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla,String ruta) {
		System.out.println("El nombre de la tabla es: "+nombreTabla);
		String[][] datosExcel = null;
		switch (tipo) {
			case "xlsx": {
				conexionDB.mysql.ObtenerDatosBasicosTabla(nombreTabla,listaTipoDatosTabla);
				datosExcel=Excel.ObtenerDatosExcel(new File(ruta));
				break;
			}
		}

	}
	public static void ValidarDatos(String[][] datosExcel,ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla) {
		int contadorColumna=0;
		
		for (EstructuraDatosImportacionTabla estructuraDatosImportacionTabla : listaTipoDatosTabla) {
			
			if(datosExcel[contadorColumna][0].equalsIgnoreCase(estructuraDatosImportacionTabla.getNombreCampo())) {
				for (int y = 0; y < datosExcel[contadorColumna].length; y++) {
					//Comprobar si se puede convertir el dato al tipo de la columna
					estructuraDatosImportacionTabla.getListadoDatos().add(datosExcel[contadorColumna][y]);
					
				}
			}
			
			contadorColumna++;
		}
	}

}
