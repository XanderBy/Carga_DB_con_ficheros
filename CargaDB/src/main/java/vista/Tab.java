package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import componentes.BotonPersonalizado;
import componentes.ComboBoxPersonalizado;
import componentes.TabbedPanePersonalizado;
import componentes.TablaPersonalizado;
import conexion.Conexion;
import configuracion.Configuracion;
import estructura.datos.EstructuraDatosImportacionTabla;
import importacion.Importacion;
import net.miginfocom.swing.MigLayout;

public class Tab extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String baseDeDatosElegida;
	private Conexion conexion;
	private ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla;
	private Importacion importacion;

	private BotonPersonalizado botonConectarDB;
	private BotonPersonalizado botonImportarFichero;
	private BotonPersonalizado botonCargarDatos;

	private ComboBoxPersonalizado ComboBaseDeDatos;
	private ComboBoxPersonalizado ComboVersionesBaseDatos;

	private TablaPersonalizado tablaDatos;

	private JPanel panelConexion;
	private BotonPersonalizado BotonConectarse;
	private JTextField textFields[];

	public Tab(TabbedPanePersonalizado panel) {
		this.setLayout(new MigLayout("fill", // Layout Constraints
				"[][][][][][]", // columnas
				"[][][][][]")); // filas

		this.conexion = new Conexion();

		this.listaTipoDatosTabla = new ArrayList<>();
		this.importacion = new Importacion();

		Configuracion.CargarConfiguracion(this);
	}

	public BotonPersonalizado getBotonConectarse() {
		return BotonConectarse;
	}

	public void setBotonConectarse(BotonPersonalizado botonConectarse) {
		BotonConectarse = botonConectarse;
	}

	public BotonPersonalizado getBotonConectarDB() {
		return botonConectarDB;
	}

	public void setBotonConectarDB(BotonPersonalizado botonConectarDB) {
		this.botonConectarDB = botonConectarDB;
	}

	public BotonPersonalizado getBotonImportarFichero() {
		return botonImportarFichero;
	}

	public void setBotonImportarFichero(BotonPersonalizado botonImportarFichero) {
		this.botonImportarFichero = botonImportarFichero;
	}

	public BotonPersonalizado getBotonCargarDatos() {
		return botonCargarDatos;
	}

	public void setBotonCargarDatos(BotonPersonalizado botonCargarDatos) {
		this.botonCargarDatos = botonCargarDatos;
	}

	public ComboBoxPersonalizado getComboBaseDeDatos() {
		return ComboBaseDeDatos;
	}

	public void setComboBaseDeDatos(ComboBoxPersonalizado comboBaseDeDatos) {
		ComboBaseDeDatos = comboBaseDeDatos;
	}

	public TablaPersonalizado getTablaDatos() {
		return tablaDatos;
	}

	public void setTablaDatos(TablaPersonalizado tablaDatos) {
		this.tablaDatos = tablaDatos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			System.out.println(BotonConectarse);
			if (e.getSource() == this.BotonConectarse & this.BotonConectarse.getName().contains("ESTABLECERCONEXION")) {
				System.out.println("Entro");
				if (this.conexion.ConectarConDb(this.getBaseDeDatosElegida(), textFields[3].getText(),
						textFields[4].getText(), textFields[1].getText(), textFields[0].getText(),
						textFields[2].getText())) {
					Configuracion.ActivarComponentes(this.BotonConectarse.getId(), true, false,
							new ArrayList<>(Arrays.asList(botonCargarDatos, botonConectarDB, botonImportarFichero,BotonConectarse)), null,
							null, null, null);
				} else {
					JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Ha dado error el establecer conexión");
		}
		
		if (e.getSource() == botonConectarDB & botonConectarDB.getName().contains("CONECTAR")) {
			if (this.panelConexion != null) {
				this.remove(this.panelConexion);
				this.panelConexion = null;
			} else {
				String messages[] = { "Endpoint", "Base de Datos", "Puerto", "Usuario", "Contraseña" };
				String textoDefault[] = { "localhost/", "prueba", "3306", "root", "admin" };
				textFields = new JTextField[messages.length];

				this.panelConexion = new JPanel();
				String input[] = new String[messages.length];
				int cancelar = 0;

				this.panelConexion.setLayout(new GridLayout(messages.length + 1, 2, 0, 0));

				for (int i = 0; i < messages.length; i++) {
					this.panelConexion.add(new JLabel(messages[i]));

					if (i == (messages.length - 1)) {
						JPasswordField pass = new JPasswordField(15);
						textFields[i] = pass;
						this.panelConexion.add(pass);
					} else {
						textFields[i] = new JTextField();
						this.panelConexion.add(textFields[i]);
					}

				}
				
				this.panelConexion.add(this.BotonConectarse);
				this.BotonConectarse.addActionListener(this);
				this.add(this.panelConexion, "cell 0 0");
				System.out.println("se ha declarado no se k");
			}

		}
		if (e.getSource() == botonImportarFichero & botonImportarFichero.getName().contains("IMPORTARFICHERO")) {
			this.getListaTipoDatosTabla().clear();
			this.setListaTipoDatosTabla(
					this.importacion.ImportarFichero(Configuracion.CargarLista("FORMATOSPERMITIDOS", false),
							this.getConexion(), this.getListaTipoDatosTabla()));
			Configuracion.ActivarComponentes(botonImportarFichero.getId(), true, false,
					new ArrayList<>(Arrays.asList(botonCargarDatos, botonConectarDB, botonImportarFichero)), null, null,
					null, null);

			if (tablaDatos.getId().contains("DATOSACARGAR")) {
				
				tablaDatos.setModel(this.importacion.CargarDatosJTable(listaTipoDatosTabla));

			}

			System.out.println(this.getListaTipoDatosTabla().get(0).getListadoDatos().get(0));
		}
		if (e.getSource() == botonCargarDatos & botonCargarDatos.getName().contains("CARGADATOS")) {
			String mnesajeError = this.getConexion().RealizarCarga(baseDeDatosElegida,
					this.importacion.getNombreTabla(), this.getListaTipoDatosTabla());
			if (mnesajeError.length() == 0) {
				JOptionPane.showMessageDialog(null, "Se ha realizado con exito la carga", "Proceso Completado",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, mnesajeError, "Error al realizar la carga",
						JOptionPane.ERROR_MESSAGE);
			}
			Configuracion.ActivarComponentes(botonCargarDatos.getId(), false, true,
					new ArrayList<>(Arrays.asList(botonCargarDatos, botonConectarDB, botonImportarFichero)), null, null,
					null, null);

		}

		if (e.getSource() == ComboBaseDeDatos & ComboBaseDeDatos.getId().contains("BASESDEDATOS")) {
			String valor = (String) ((ComboBoxPersonalizado) e.getSource()).getSelectedItem();
			if (valor != null && valor.length() > 0) {
				Configuracion.ActivarComponentes(ComboBaseDeDatos.getId(), true, false,
						null, null,
						null, new ArrayList<>(Arrays.asList(ComboBaseDeDatos, ComboVersionesBaseDatos)), null);
				this.setBaseDeDatosElegida(valor);
				Configuracion.CargarComboBox(this.ComboVersionesBaseDatos, "VERSIONES" + valor);
			} else {
				Configuracion.ActivarComponentes(ComboBaseDeDatos.getId(), false, false,
						null, null,
						null, new ArrayList<>(Arrays.asList(ComboBaseDeDatos, ComboVersionesBaseDatos)), null);
			}

		}

		if (e.getSource() == ComboVersionesBaseDatos & ComboVersionesBaseDatos.getId().contains("VERSIONESDEDATOS")) {
			System.out.println("Entré");
			String valor = (String) ((ComboBoxPersonalizado) e.getSource()).getSelectedItem();
			if (valor != null && valor.length() > 0) {
				Configuracion.ActivarComponentes(ComboVersionesBaseDatos.getId(), true, false,
						new ArrayList<>(Arrays.asList(botonCargarDatos, botonConectarDB, botonImportarFichero)), null,
						null, new ArrayList<>(Arrays.asList(ComboBaseDeDatos, ComboVersionesBaseDatos)), null);
			} else {
				Configuracion.ActivarComponentes(ComboVersionesBaseDatos.getId(), false, false,
						new ArrayList<>(Arrays.asList(botonCargarDatos, botonConectarDB, botonImportarFichero)), null,
						null, new ArrayList<>(Arrays.asList(ComboBaseDeDatos, ComboVersionesBaseDatos)), null);
			}

		}

		invalidate();
		validate();
		repaint();
		System.out.println("repintar");
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

	public ComboBoxPersonalizado getComboVersionesBaseDatos() {
		return ComboVersionesBaseDatos;
	}

	public void setComboVersionesBaseDatos(ComboBoxPersonalizado comboVersionesBaseDatos) {
		ComboVersionesBaseDatos = comboVersionesBaseDatos;
	}

}
