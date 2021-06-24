package vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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
	private JTabbedPane panelTabs;

	public Ventana(String nombre, Dimension tamano, ArrayList<JButton> listaBotones, ArrayList<JLabel> listaTitulos)
			throws HeadlessException {
		super();
		this.setNombre(nombre);
		this.setTamano(tamano);
		this.setListaBotones(listaBotones);
		this.setListaTitulos(listaTitulos);
		
		this.setLayout(null);

		this.panelTabs=new JTabbedPane(JTabbedPane.TOP);
		
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		
		JPanel panel=new JPanel();
		if (this.listaBotones != null) {
			//PropiedadesVentana.PropiedadesBotones(this,panel);

		}
		
		if (this.listaTitulos != null) {
			//PropiedadesVentana.PropiedadesTitulos(this,panel);
		}
		NewTab nuevo=new NewTab(this.panelTabs);
		
		
		
		add(this.panelTabs);
		
		setTitle(this.getNombre());
		setSize(tamano);
		setVisible(true);
		setLayout(new GridLayout(1, 1));
		
	}
	public void añadirBoton(JTabbedPane paneltab) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		this.listaBotones.forEach((b) -> {
			if (e.getSource() == b & b.getName().contains("1")) {
				System.out.println(b.getName());
			}
			if (e.getSource() == b & b.getName().contains("NuevaVentana")) {
				System.out.println(b.getName());
				AccionesBoton.NuevaTab(this);
			}
		});

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


	public JTabbedPane getPanelTabs() {
		return panelTabs;
	}


	public void setPanelTabs(JTabbedPane panelTabs) {
		this.panelTabs = panelTabs;
	}

}
