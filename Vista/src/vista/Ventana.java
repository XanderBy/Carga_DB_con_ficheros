package vista;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ventana extends JFrame implements ActionListener {

	private ArrayList<JButton> listaBotones;
	private ArrayList<JTable> listaTablas;
	private ArrayList<JTextField> listaCajaTexto;
	private ArrayList<JLabel> listaTitulos;
	private String nombre;
	private Dimension tamano;

	public Ventana(String nombre, Dimension tamano, ArrayList<JButton> listaBotones) throws HeadlessException {
		super();
		this.setNombre(nombre);
		this.setTamano(tamano);
		this.setListaBotones(listaBotones);

		setTitle(this.getNombre());
		setSize(tamano);
		setVisible(true);

		
		if(listaBotones != null) {
			PropiedadesVentana.PropiedadesBotones(this);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Dimension getTamano() {
		return tamano;
	}

	public void setTamano(Dimension tamano) {
		this.tamano = tamano;
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

	public ArrayList<JTextField> getListaCajaTexto() {
		return listaCajaTexto;
	}

	public void setListaCajaTexto(ArrayList<JTextField> listaCajaTexto) {
		this.listaCajaTexto = listaCajaTexto;
	}

	public ArrayList<JLabel> getListaTitulos() {
		return listaTitulos;
	}

	public void setListaTitulos(ArrayList<JLabel> listaTitulos) {
		this.listaTitulos = listaTitulos;
	}

}
