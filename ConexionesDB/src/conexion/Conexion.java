package conexion;

import bases.de.datos.ConexionMysql;

public class Conexion {

	private ConexionMysql mysql;

	public boolean ConectarConDb(String db, String usuario, String contrasena, String baseDeDatos, String url, String puerto) {
		boolean res=false;
		switch (db) {
		case "MYSQL": {
			
			mysql = new ConexionMysql(db,puerto, url, usuario,contrasena);

			
			res=mysql.Conectar();
			mysql.Desconectar();
			break;
		}
		default:
			System.out.println("No se ha elegido ninguna conexión");
		}
		return res;
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
