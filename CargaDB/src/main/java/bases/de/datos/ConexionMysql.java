package bases.de.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import estructura.datos.EstructuraDatosImportacionTabla;

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

	public ArrayList<EstructuraDatosImportacionTabla> ObtenerDatosBasicosTabla(String tabla,
			ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla) {

		// describe [db_name.]table_name;

		String query = "describe " + this.getBaseDeDatos() + "." + tabla;
		System.out.println(query);
		Conectar();
		Statement st;
		try {
			st = this.getConexion().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				/*
				 * System.out.println(rs.getString("Field"));
				 * System.out.println(rs.getString("Type"));
				 * System.out.println(rs.getString("Null"));
				 * System.out.println(rs.getString("Key"));
				 * System.out.println(rs.getString("Default"));
				 * System.out.println(rs.getString("Extra"));
				 */
				EstructuraDatosImportacionTabla estructura = new EstructuraDatosImportacionTabla(rs.getString("Field"),
						rs.getString("Type"));
				System.out.println(estructura.getTipo());
				listaTipoDatosTabla.add(estructura);
			}

			Desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaTipoDatosTabla;
	}

	public String Insert(String tabla, ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla) {
		String insert = new String();
		String campos = new String();
		String valores = new String();
		ArrayList<EstructuraDatosImportacionTabla> temporal = listaTipoDatosTabla;
		String res = new String();
		PreparedStatement st;
		int maxDatos = 0;

		for (EstructuraDatosImportacionTabla estructuraDatosImportacionTabla : listaTipoDatosTabla) {
			if (maxDatos < estructuraDatosImportacionTabla.getListadoDatos().size()) {
				maxDatos = estructuraDatosImportacionTabla.getListadoDatos().size();
			}
		}

		try {
			Conectar();

			for (int i = 0; i < maxDatos; i++) {

				for (EstructuraDatosImportacionTabla estructuraDatosImportacionTabla : temporal) {
					campos += estructuraDatosImportacionTabla.getNombreCampo() + ",";
					for (String dato : estructuraDatosImportacionTabla.getListadoDatos()) {
						if (estructuraDatosImportacionTabla.getTipo().contains("varchar")) {
							valores += "'" + dato + "',";
						} else {
							valores += dato + ",";
						}

						estructuraDatosImportacionTabla.getListadoDatos().remove(dato);
						break;
					}
				}

				campos = campos.substring(0, campos.length() - 1);
				valores = valores.substring(0, valores.length() - 1);

				insert = "INSERT INTO " + this.baseDeDatos + "." + tabla + " (" + campos + ") VALUES (" + valores + ")";
				System.out.println(insert);
				st = this.getConexion().prepareStatement(insert);

				st.execute();
				valores="";
				campos="";
			}

		} catch (SQLException e) {
			res = e.getMessage();
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Desconectar();
		}

		return res;
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
