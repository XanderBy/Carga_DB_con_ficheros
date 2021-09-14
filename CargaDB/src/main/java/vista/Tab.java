package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;

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
import net.miginfocom.swing.MigLayout;

public class Tab extends JPanel implements ActionListener {

	
	private String baseDeDatosElegida;
	private TabbedPanePersonalizado panel;
	private Conexion conexion;
	private ArrayList<EstructuraDatosImportacionTabla> listaTipoDatosTabla;
	private Importacion importacion;
	
	private BotonPersonalizado botonConectarDB;
	private BotonPersonalizado botonImportarFichero;
	private BotonPersonalizado botonCargarDatos;
	
	private ComboBoxPersonalizado ComboBaseDeDatos;
	
	private TablaPersonalizado tablaDatos;

	public Tab(TabbedPanePersonalizado panel) {
		this.setLayout(new MigLayout());

		this.conexion = new Conexion();
		
		this.listaTipoDatosTabla = new ArrayList<>();
		this.importacion = new Importacion();

		Configuracion.CargarConfiguracion(this);

		
		//JScrollPane scrollPane = new JScrollPane(this.getListaTablas().get(0));

		// Force the scrollbars to always be displayed
		// scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		/*scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout layout = new GroupLayout(this);

		//horizontal
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().addComponent(scrollPane));
		layout.setHorizontalGroup(hGroup);
		//vertical
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(scrollPane));
		layout.setVerticalGroup(vGroup);

		this.getListaTablas().get(0).setLayout(layout);*/
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


			if (e.getSource() == botonConectarDB & botonConectarDB.getName().contains("CONECTAR")) {
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
								System.out.println(botonConectarDB.getId());
								Configuracion.ActivarComponentes(botonConectarDB.getId(), true,false,new ArrayList<>(Arrays.asList(botonCargarDatos,botonConectarDB,botonImportarFichero)), null, null,
										null, null);
							} else {
								JOptionPane.showMessageDialog(null, "No se ha podido establecer conexion", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}

				}

			}
			if (e.getSource() == botonImportarFichero & botonImportarFichero.getName().contains("IMPORTARFICHERO")) {
				this.getListaTipoDatosTabla().clear();
				this.setListaTipoDatosTabla(
						this.importacion.ImportarFichero(Configuracion.CargarLista("FORMATOSPERMITIDOS", false),
								this.getConexion(), this.getListaTipoDatosTabla()));
				Configuracion.ActivarComponentes(botonImportarFichero.getId(), true,false, new ArrayList<>(Arrays.asList(botonCargarDatos,botonConectarDB,botonImportarFichero)), null, null, null, null);
				

					if (tablaDatos.getId().contains("DATOSACARGAR")) {
						System.out.println("Entró");
						tablaDatos.setModel(this.importacion.CargarDatosJTable(listaTipoDatosTabla));

					}


				System.out.println(this.getListaTipoDatosTabla().get(0).getListadoDatos().get(0));
			}
			if (e.getSource() == botonCargarDatos & botonCargarDatos.getName().contains("CARGADATOS")) {
				if(this.getConexion().RealizarCarga(baseDeDatosElegida, this.importacion.getNombreTabla(),
						this.getListaTipoDatosTabla())) {
					
				}else {
					
				}
				Configuracion.ActivarComponentes(botonCargarDatos.getId(), false,true, new ArrayList<>(Arrays.asList(botonCargarDatos,botonConectarDB,botonImportarFichero)), null, null, null, null);

			}


		
			if (e.getSource() == ComboBaseDeDatos & ComboBaseDeDatos.getId().contains("BASESDEDATOS")) {
				String valor = (String) ((ComboBoxPersonalizado) e.getSource()).getSelectedItem();
				if (valor != null && valor.length() > 0) {
					Configuracion.ActivarComponentes(ComboBaseDeDatos.getId(), true,false, new ArrayList<>(Arrays.asList(botonCargarDatos,botonConectarDB,botonImportarFichero)), null, null, null, null);
					this.setBaseDeDatosElegida(valor);
				} else {
					Configuracion.ActivarComponentes(ComboBaseDeDatos.getId(), false,false, new ArrayList<>(Arrays.asList(botonCargarDatos,botonConectarDB,botonImportarFichero)), null, null, null, null);
				}

			}

		repaint();
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
