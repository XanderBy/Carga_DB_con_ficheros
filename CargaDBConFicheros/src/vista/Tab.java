package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import componentes.ComboBoxPersonalizado;
import componentes.TextFieldPersonalizado;
import configuracion.Configuracion;

public class Tab extends JPanel implements ActionListener {

	private ArrayList<JButton> listaBotones;
	private ArrayList<JTable> listaTablas;
	private ArrayList<TextFieldPersonalizado> listaCajaTexto;
	private ArrayList<JLabel> listaTitulos;
	private ArrayList<ComboBoxPersonalizado> listaTComboBox;
	private JTabbedPane panel;

	public Tab(JTabbedPane panel) {
		this.setLayout(null);

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

		if (this.getListaCajaTexto() != null) {
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
			}

		});

	}

	public ArrayList<JButton> getListaBotones() {
		return listaBotones;
	}

	public void setListaBotones(ArrayList<JButton> listaBotones) {
		this.listaBotones = listaBotones;
	}

	public ArrayList<JTable> getListaTablas() {
		return listaTablas;
	}

	public void setListaTablas(ArrayList<JTable> listaTablas) {
		this.listaTablas = listaTablas;
	}

	public ArrayList<TextFieldPersonalizado> getListaCajaTexto() {
		return listaCajaTexto;
	}

	public void setListaCajaTexto(ArrayList<TextFieldPersonalizado> listaCajaTexto) {
		this.listaCajaTexto = listaCajaTexto;
	}

	public ArrayList<JLabel> getListaTitulos() {
		return listaTitulos;
	}

	public void setListaTitulos(ArrayList<JLabel> listaTitulos) {
		this.listaTitulos = listaTitulos;
	}

	public ArrayList<ComboBoxPersonalizado> getListaTComboBox() {
		return listaTComboBox;
	}

	public void setListaTComboBox(ArrayList<ComboBoxPersonalizado> listaTComboBox) {
		this.listaTComboBox = listaTComboBox;
	}
}
