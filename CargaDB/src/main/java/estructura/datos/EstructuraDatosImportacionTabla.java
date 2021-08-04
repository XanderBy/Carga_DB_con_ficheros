package estructura.datos;

import java.util.ArrayList;

public class EstructuraDatosImportacionTabla {
	
	private String nombreCampo;
	private String tipo;
	private ArrayList<String> listadoDatos;
	
	
	
	public EstructuraDatosImportacionTabla(String nombreCampo, String tipo) {
		super();
		this.nombreCampo = nombreCampo;
		this.tipo = tipo;
		this.setListadoDatos(new ArrayList<>());
	}



	public String getNombreCampo() {
		return nombreCampo;
	}



	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public ArrayList<String> getListadoDatos() {
		return listadoDatos;
	}



	public void setListadoDatos(ArrayList<String> listadoDatos) {
		this.listadoDatos = listadoDatos;
	}
	
	
	

}
