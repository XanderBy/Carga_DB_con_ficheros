package vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import configuracion.Configuracion;

public class Tab extends JPanel implements ActionListener {

	private ArrayList<JButton> listaBotones;
	private ArrayList<JTable> listaTablas;
	private ArrayList<JTextField> listaCajaTexto;
	private ArrayList<JLabel> listaTitulos;
	private JTabbedPane panel;
	
	
	public Tab(JTabbedPane panel) {
		
		setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
		this.listaBotones=new ArrayList<>();
		this.listaTablas=new ArrayList<>();
		this.listaCajaTexto=new ArrayList<>();
		this.listaTitulos=new ArrayList<>();
		
		Configuracion.CargarConfiguracion(this.getListaBotones(),this.getListaTitulos());
		
		if (this.getListaBotones() != null) {
			PropiedadesVentana.PropiedadesBotones(this);

		}
		
		if (this.getListaTitulos() != null) {
			PropiedadesVentana.PropiedadesTitulos(this);
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
