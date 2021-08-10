package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import componentes.BotonPersonalizado;
import componentes.ComboBoxPersonalizado;
import componentes.LabelPersonalizado;
import componentes.TabbedPanePersonalizado;
import componentes.TablaPersonalizado;
import componentes.TextFieldPersonalizado;
import conexion.Conexion;
import configuracion.Configuracion;
import estructura.datos.EstructuraDatosImportacionTabla;
import importacion.Importacion;

public class Tab extends JPanel implements ActionListener {

	private ArrayList<BotonPersonalizado> listaBotones;
	private ArrayList<TablaPersonalizado> listaTablas;
	private ArrayList<TextFieldPersonalizado> listaCajaTexto;
	private ArrayList<LabelPersonalizado> listaTitulos;
	private ArrayList<ComboBoxPersonalizado> listaTComboBox;
	private String baseDeDatosElegida;
	private TabbedPanePersonalizado panel;
	private Conexion conexion;
	private ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla;
	private Importacion importacion;

	public Tab(TabbedPanePersonalizado panel) {
		this.setLayout(null);

		this.conexion = new Conexion();
		this.listaBotones = new ArrayList<>();
		this.listaTablas = new ArrayList<>();
		this.listaCajaTexto = new ArrayList<>();
		this.listaTitulos = new ArrayList<>();
		this.listaTComboBox = new ArrayList<>();
		this.listaTipoDatosTabla = new ArrayList<>();
		this.importacion = new Importacion();

		Configuracion.CargarConfiguracion(this.getListaBotones(), this.getListaTitulos(), this.getListaCajaTexto(),
				this.getListaTComboBox(), this.getListaTablas());

		if (this.getListaBotones() != null) {
			PropiedadesVentana.PropiedadesBotones(this);

		}

		if (this.getListaTitulos() != null) {
			PropiedadesVentana.PropiedadesTitulos(this);
		}

		if (this.getListaCajaTexto() != null) {
			PropiedadesVentana.PropiedadesCajaText(this);
		}

		if (this.getListaTComboBox() != null) {
			PropiedadesVentana.PropiedadesComboBox(this);
		}

		if (this.getListaTablas() != null) {
			PropiedadesVentana.PropiedadesTablas(this);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		this.listaBotones.forEach((b) -> {
			if (e.getSource() == b & b.getName().contains("CONECTAR")) {
				String messages[] = { "Endpoint", "Base de Datos", "Puerto", "Usuario", "Contrase�a" };
				String textoDefault[] = { "localhost/", "prueba", "3306", "root", "admin" };
				String[] datosConexion = new PopUp().showInputDialog(null, messages, textoDefault);
				System.out.println(datosConexion.length);
				System.out.println(datosConexion[0]);
				if (datosConexion.length == 0) {
					JOptionPane.showMessageDialog(null, "No has introducido los campos necesarios", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (!datosConexion[0].equals("Ha pulsado cancelar")) {
						if (datosConexion.length > 0) {
							if (this.conexion.ConectarConDb(this.getBaseDeDatosElegida(), datosConexion[3],
									datosConexion[4], datosConexion[1], datosConexion[0], datosConexion[2])) {
								System.out.println(b.getId());
								Configuracion.ActivarComponentes(b.getId(), true, this.getListaBotones(), null, null,
										null, null);
							} else {
								JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}

				}

			}
			if (e.getSource() == b & b.getName().contains("IMPORTARFICHERO")) {
				this.getListaTipoDatosTabla().clear();
				this.setListaTipoDatosTabla(
						this.importacion.ImportarFichero(Configuracion.CargarLista("FORMATOSPERMITIDOS", false),
								this.getConexion(), this.getListaTipoDatosTabla()));
				Configuracion.ActivarComponentes(b.getId(), true, this.getListaBotones(), null, null, null, null);
				this.listaTablas.forEach((t) -> {
					System.out.println(t.getId());
					
					if (t.getId().contains("DATOSACARGAR")) {
						System.out.println("Entró");
						t.setModel(this.importacion.CargarDatosJTable(listaTipoDatosTabla));
						
						
						
					}
				});

				System.out.println(this.getListaTipoDatosTabla().get(0).getListadoDatos().get(0));
			}
			if (e.getSource() == b & b.getName().contains("CARGADATOS")) {
				this.getConexion().RealizarCarga(baseDeDatosElegida, this.importacion.getNombreTabla(),
						this.getListaTipoDatosTabla());

			}

		});
		this.listaTComboBox.forEach((b) -> {
			System.out.println(b.getId());
			if (e.getSource() == b & b.getId().contains("BASESDEDATOS")) {
				String valor = (String) ((ComboBoxPersonalizado) e.getSource()).getSelectedItem();
				if (valor != null && valor.length() > 0) {
					Configuracion.ActivarComponentes(b.getId(), true, this.getListaBotones(), null, null, null, null);
					this.setBaseDeDatosElegida(valor);
				} else {
					Configuracion.ActivarComponentes(b.getId(), false, this.getListaBotones(), null, null, null, null);
				}

			}
		});

	}

	public ArrayList<BotonPersonalizado> getListaBotones() {
		return listaBotones;
	}

	public void setListaBotones(ArrayList<BotonPersonalizado> listaBotones) {
		this.listaBotones = listaBotones;
	}

	public ArrayList<TablaPersonalizado> getListaTablas() {
		return listaTablas;
	}

	public void setListaTablas(ArrayList<TablaPersonalizado> listaTablas) {
		this.listaTablas = listaTablas;
	}

	public ArrayList<TextFieldPersonalizado> getListaCajaTexto() {
		return listaCajaTexto;
	}

	public void setListaCajaTexto(ArrayList<TextFieldPersonalizado> listaCajaTexto) {
		this.listaCajaTexto = listaCajaTexto;
	}

	public ArrayList<LabelPersonalizado> getListaTitulos() {
		return listaTitulos;
	}

	public void setListaTitulos(ArrayList<LabelPersonalizado> listaTitulos) {
		this.listaTitulos = listaTitulos;
	}

	public ArrayList<ComboBoxPersonalizado> getListaTComboBox() {
		return listaTComboBox;
	}

	public void setListaTComboBox(ArrayList<ComboBoxPersonalizado> listaTComboBox) {
		this.listaTComboBox = listaTComboBox;
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public String getBaseDeDatosElegida() {
		return baseDeDatosElegida;
	}

	public void setBaseDeDatosElegida(String baseDeDatosElegida) {
		this.baseDeDatosElegida = baseDeDatosElegida;
	}

	public ArrayList<EstructuraDatosImportacionTabla> getListaTipoDatosTabla() {
		return listaTipoDatosTabla;
	}

	public void setListaTipoDatosTabla(ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla) {
		this.listaTipoDatosTabla = listaTipoDatosTabla;
	}
}
