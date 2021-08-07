package conexion;

import java.util.ArrayList;

import bases.de.datos.ConexionMysql;
import estructura.datos.EstructuraDatosImportacionTabla;

public class Conexion {

	public ConexionMysql mysql;

	public boolean ConectarConDb(String db, String usuario, String contrasena, String baseDeDatos, String url,
			String puerto) {
		boolean res = false;
		switch (db) {
		case "MYSQL": {

			mysql = new ConexionMysql(baseDeDatos, puerto, url, usuario, contrasena);

			res = mysql.Conectar();
			mysql.Desconectar();
			break;
		}
		default:
			System.out.println("No se ha elegido ninguna conexi�n");
		}
		return res;
	}

	public boolean EstaConectado() {
		boolean res = false;

		return res;
	}

	public boolean RealizarCarga(String db, String tabla,ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla) {

		boolean res = false;

		switch (db) {
		case "MYSQL": {

			res = mysql.Insert(tabla,listaTipoDatosTabla);

			break;
		}
		default:
			System.out.println("No se ha elegido ninguna conexi�n");
		}

		return res;

	}
}
