package conexion;

import bases.de.datos.ConexionMysql;

public class Conexion {

	private static ConexionMysql mysql;

	public static void ConectarConDb(String db) {

		switch (db) {
		case "MYSQL": {

			mysql = new ConexionMysql();

			break;
		}
		default:
			System.out.println("No se ha elegido ninguna conexi�n");
		}

	}

	public static boolean RealizarCarga(String db) {

		boolean res = false;

		switch (db) {
		case "MYSQL": {

			res = mysql.Insert();

			break;
		}
		default:
			System.out.println("No se ha elegido ninguna conexi�n");
		}

		return res;

	}

}
