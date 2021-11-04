package tipo.ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import configuracion.Configuracion;

public class Txt {

	public static String[][] ObtenerDatosTxt(String Fichero) {
		
		String [][] datosTxt = null;
		String [] linea;
		String separador= (String) Configuracion.properties.get("SEPARADORTXT");
        FileReader f = null;
        int contadorLineas=0;
        int contadorColumnas=0;
		try {
			f = new FileReader(Fichero);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
        BufferedReader b = new BufferedReader(f); 
        int x=(int) b.lines().count();
        try {
        	String cadena= new String();
			while((cadena = b.readLine())!=null) { 
				System.out.println(cadena); 
				if(contadorLineas==0) {
					datosTxt=new String[x][cadena.split(separador).length];
					
				}
				linea=new String[cadena.split(separador).length];
				linea=cadena.split(separador);
				contadorColumnas=0;
				for (String componente : linea) {
					datosTxt[contadorLineas][contadorColumnas]=componente;
					contadorColumnas++;
				}
				contadorLineas++;
			}
			b.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
		return datosTxt;
	}
	
	
}
