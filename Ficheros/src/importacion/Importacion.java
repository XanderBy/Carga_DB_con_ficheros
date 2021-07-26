package importacion;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Importacion {

	public static boolean ImportarFichero(String[] listadoExtensionesPermitidas) {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter(null, listadoExtensionesPermitidas);
		fileChooser.setFileFilter(filtroExtension);
		int resultado = fileChooser.showOpenDialog(fileChooser);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			String extensionElegida, nombreTabla, nombreFichero = new String();
			try {
				File fichero=fileChooser.getSelectedFile();
				nombreFichero=fichero.getName();
				
				String[] listaAuxiliarExtension = nombreFichero.split("\\.");
				extensionElegida = listaAuxiliarExtension[listaAuxiliarExtension.length - 1];
				nombreTabla=fichero.getName().replace(("."+extensionElegida), "");
				
			} catch (Exception e) {
				e.getStackTrace();
				return false;
			}
			ImportarPorTipo(extensionElegida,nombreTabla);
		}

		return false;
	}

	public static void ImportarPorTipo(String tipo, String nombreTabla) {
		System.out.println("El nombre de la tabla es: "+nombreTabla);
		switch (tipo) {
			case "xlsx": {
				
				break;
			}
		}

	}

}
