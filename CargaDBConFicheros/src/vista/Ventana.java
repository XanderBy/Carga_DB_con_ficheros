package vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ventana extends JFrame implements ActionListener {

	
	private String nombre;
	private Dimension tamano;
	private JTabbedPane panelTabs;
	private int numeroMaxTabs;

	public Ventana(String nombre, Dimension tamano, int numeroMaxTabs)
			throws HeadlessException {
		super();
		this.setNombre(nombre);
		this.setTamano(tamano);
		this.setNumeroMaxTabs(numeroMaxTabs);
		
		this.setLayout(null);

		this.panelTabs=new JTabbedPane(JTabbedPane.TOP);
		
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		NewTab nuevo=new NewTab(this.getPanelTabs(), this.getNumeroMaxTabs());
		
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


	public JTabbedPane getPanelTabs() {
		return panelTabs;
	}


	public void setPanelTabs(JTabbedPane panelTabs) {
		this.panelTabs = panelTabs;
	}
	public int getNumeroMaxTabs() {
		return numeroMaxTabs;
	}
	public void setNumeroMaxTabs(int numeroMaxTabs) {
		this.numeroMaxTabs = numeroMaxTabs;
	}

}
