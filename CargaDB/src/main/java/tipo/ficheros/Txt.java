package tipo.ficheros;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import configuracion.Configuracion;

public class Txt {

	public static String[][] ObtenerDatosTxt(String Fichero) {

		String[][] datosTxt = null;
		String[] linea;
		String separador = (String) Configuracion.properties.get("SEPARADORTXT");
		FileInputStream f = null;
		int contadorLineas = 0;
		int contadorColumnas = 0;
		try {
			f = new FileInputStream(Fichero);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader b = new BufferedReader(new InputStreamReader(f));
		int x = (int) b.lines().count();
		System.out.println("Numero de filas " + x);
		try {
			f.getChannel().position(0);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		b = new BufferedReader(new InputStreamReader(f));
		try {
			String cadena = new String();
			do {
				cadena = b.readLine();
				if (cadena != null) {
					System.out.println(cadena);
					if (contadorLineas == 0) {
						datosTxt = new String[x][cadena.split(separador).length];

					}
					linea = new String[cadena.split(separador).length];
					linea = cadena.split(separador);
					System.out.println("Numero de columnas " + linea.length);
					contadorColumnas = 0;
					for (String componente : linea) {
						System.out.println(componente);
						datosTxt[contadorLineas][contadorColumnas] = componente;
						contadorColumnas++;
					}
					

				}
				contadorLineas++;
			} while (cadena != null);
			b.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datosTxt;
	}

}
