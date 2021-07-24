package importacion;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Importacion {

	public static boolean ImportarFichero(String[] listadoExtensionesPermitidas) {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter(null, listadoExtensionesPermitidas);
		fileChooser.setFileFilter(filtroExtension);
		int resultado = fileChooser.showOpenDialog(fileChooser);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			String extensionElegida, nombreTabla = new String();
			try {
				System.out.println(fileChooser.getSelectedFile().getName());

				String[] listaAuxiliarExtension = fileChooser.getSelectedFile().getName().split(".");
				extensionElegida = listaAuxiliarExtension[listaAuxiliarExtension.length - 1];
				System.out.println(extensionElegida);
				nombreTabla=fileChooser.getSelectedFile().getName();
				nombreTabla=nombreTabla.replace(("."+extensionElegida), "");
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
			ImportarPorTipo(extensionElegida,nombreTabla);
		}

		return false;
	}

	public static void ImportarPorTipo(String tipo, String nombreTabla) {
		System.out.println(nombreTabla);
		switch (tipo) {
			case "xlsx": {
				
				break;
			}
		}

	}

}
