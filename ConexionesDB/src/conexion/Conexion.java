package conexion;

import bases.de.datos.ConexionMysql;

public class Conexion {

	private ConexionMysql mysql;

	public void ConectarConDb(String db) {

		switch (db) {
		case "MYSQL": {
			System.out.println("Entra?");
			mysql = new ConexionMysql();
			mysql.setDriver("com.mysql.cj.jdbc.Driver");
			mysql.setContrasena("");
			mysql.setUsuario("root");
			mysql.setBaseDeDatos("test");
			mysql.setUrl("jdbc:mysql://127.0.0.1/");
			mysql.setPuerto("3306");
			
			mysql.Conectar();
			mysql.Desconectar();
			break;
		}
		default:
			System.out.println("No se ha elegido ninguna conexión");
		}

	}
	public boolean EstaConectado() {
		boolean res=false;
		
		
		return res;
	}

	public boolean RealizarCarga(String db) {

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
