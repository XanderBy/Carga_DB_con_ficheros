package tipo.ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Txt {

	public static boolean ObtenerDatosTxt(String Fichero) {
		
		String[] cabecera; 
        FileReader f = null;
        int contadorLineas=0;
		try {
			f = new FileReader(Fichero);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
        BufferedReader b = new BufferedReader(f); 
        try {
        	String cadena= new String();
			while((cadena = b.readLine())!=null) { 
				System.out.println(cadena); 
				if(contadorLineas==0) {
					
				}
				contadorLineas++;
			}
			b.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
		return true;
	}
	
	
}
