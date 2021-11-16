package tipo.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Json {

	public static String[][] ObtenerDatosJson(String Fichero, String[] cabecera) {
		String[][] datosJson = null;
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(Fichero))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray listaDatos = (JSONArray) obj;
            System.out.println(listaDatos);
             
            //Iterate over employee array
            //listaDatos.forEach( dato -> ObtenerDatoJson( (JSONObject) dato ) );
            for (JSONArray dato : listaDatos) {
            	datosJson=ObtenerDatoJson((JSONObject) dato,cabecera);
			}
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datosJson;
	}
	private static String[][] ObtenerDatoJson(JSONObject dato, String[] cabecera) {
		
		return null;
	}
	
}
