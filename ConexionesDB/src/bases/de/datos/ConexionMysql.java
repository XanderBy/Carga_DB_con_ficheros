package bases.de.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMysql {

	private String cabecera;
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
		this.setDriver("com.mysql.cj.jdbc.Driver");
		this.setCabecera("jdbc:mysql://");
	}

	public ConexionMysql(String baseDeDatos, String puerto, String url, String usuario, String contrasena) {
		super();
		this.baseDeDatos = baseDeDatos;
		this.puerto = puerto;
		this.url = url;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.setDriver("com.mysql.cj.jdbc.Driver");
		this.setCabecera("jdbc:mysql://");
	}

	public boolean Conectar() {
		boolean res = false;
		String urlTotal = new String();
		try {
			Class.forName(driver);
			urlTotal = this.getCabecera() + this.getUrl() + this.getBaseDeDatos()
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			System.out.println(urlTotal);
			this.setConexion(DriverManager.getConnection(urlTotal, this.getUsuario(), this.getContrasena()));
			res = true;
			System.out.println("Ha conectado");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error al conectar");
		}

		return res;
	}

	public boolean Desconectar() {
		try {

			this.getConexion().close();

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void ObtenerDatosBasicosTabla(String tabla) {

		// describe [db_name.]table_name;

		String query = "describe " + this.getBaseDeDatos() + "." + tabla;
		System.out.println(query);
		Conectar();
		Statement st;
		try {
			st = this.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
		      {
				System.out.println(rs.getString("Field"));
				System.out.println(rs.getString("Type"));
				System.out.println(rs.getString("Null"));
				System.out.println(rs.getString("Key"));
				System.out.println(rs.getString("Default"));
				System.out.println(rs.getString("Extra"));
		      }
			
			Desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public String getCabecera() {
		return cabecera;
	}

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

}
