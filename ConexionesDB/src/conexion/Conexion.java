package conexion;

import bases.de.datos.ConexionMysql;

public class Conexion {

	private static ConexionMysql mysql;

	public static void ConectarConDb(String db) {

		switch (db) {
		case "MYSQL": {

			mysql = new ConexionMysql();
			mysql.setDriver("com.mysql.cj.jdbc.Driver");
			mysql.setContrasena("admin");
			mysql.setUsuario("root");
			mysql.setBaseDeDatos("prueba");
			mysql.setUrl("jdbc:mysql://localhost/");
			mysql.setPuerto("3306");
			
			mysql.Conectar();
			mysql.Desconectar();
			break;
		}
		default:
			System.out.println("No se ha elegido ninguna conexión");
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
			System.out.println("No se ha elegido ninguna conexión");
		}

		return res;

	}

}
