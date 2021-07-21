package bases.de.datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionMysql {

	private String driver;
	private String baseDeDatos;
	private String hostName;
	private String puerto;
	private String url;
	private String usuario;
	private String contrasena;
	private Connection conexion;

	public ConexionMysql() {
		super();
	}

	public boolean Conectar() {
		boolean res = false;
		try {
			Class.forName(driver);
			System.out.println();
			this.setConexion(DriverManager.getConnection(this.getUrl()+":"+this.getPuerto()+"/"+this.getBaseDeDatos(), this.getUsuario(), this.getContrasena()));
			res = true;
			System.out.println("Ha conectado");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error al conectar");
		}

		return res;
	}

	public boolean Desconectar() {

		return false;
	}

	public boolean Insert() {

		return false;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getBaseDeDatos() {
		return baseDeDatos;
	}

	public void setBaseDeDatos(String baseDeDatos) {
		this.baseDeDatos = baseDeDatos;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

}
