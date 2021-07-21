package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import componentes.BotonPersonalizado;
import componentes.ComboBoxPersonalizado;
import componentes.LabelPersonalizado;
import componentes.TabbedPanePersonalizado;
import componentes.TablaPersonalizado;
import componentes.TextFieldPersonalizado;
import conexion.Conexion;
import configuracion.Configuracion;

public class Tab extends JPanel implements ActionListener {

	private ArrayList<BotonPersonalizado> listaBotones;
	private ArrayList<TablaPersonalizado> listaTablas;
	private ArrayList<TextFieldPersonalizado> listaCajaTexto;
	private ArrayList<LabelPersonalizado> listaTitulos;
	private ArrayList<ComboBoxPersonalizado> listaTComboBox;
	private TabbedPanePersonalizado panel;
	private Conexion conexion;

	public Tab(TabbedPanePersonalizado panel) {
		this.setLayout(null);
		
		this.conexion=new Conexion();
		this.listaBotones = new ArrayList<>();
		this.listaTablas = new ArrayList<>();
		this.listaCajaTexto = new ArrayList<>();
		this.listaTitulos = new ArrayList<>();
		this.listaTComboBox = new ArrayList<>();

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
			if (e.getSource() == b & b.getName().contains("1")) {
				System.out.println(b.getName());
				String messages[] = { "Endpoint", "Puerto", "Usuario", "Contraseña" };

				PopUp.showInputDialog(null, messages);
				
				this.conexion.ConectarConDb("MYSQL");
			}

		});
		this.listaTComboBox.forEach((b)->{
			System.out.println(b.getId());
			if (e.getSource() == b & b.getId().contains("BASESDEDATOS")) {
				String valor=(String)((ComboBoxPersonalizado) e.getSource()).getSelectedItem();
				if(valor != null && valor.length()>0) {
					Configuracion.ActivarComponentes(b.getId(),true,this.getListaBotones(),null,null,null,null);
				}else {
					Configuracion.ActivarComponentes(b.getId(),false,this.getListaBotones(),null,null,null,null);
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
}
