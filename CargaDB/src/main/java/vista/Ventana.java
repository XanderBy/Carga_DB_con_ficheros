package vista;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import java.awt.Point;
import componentes.TabbedPanePersonalizado;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class Ventana extends JFrame implements ActionListener {

	
	private String nombre;
	private Dimension tamano;
	private TabbedPanePersonalizado panelTabs;
	private int numeroMaxTabs;

	public Ventana(String nombre, Dimension tamano, int numeroMaxTabs, Point posicion) throws HeadlessException {
		super();
		this.setNombre(nombre);
		this.setTamano(tamano);
		this.setNumeroMaxTabs(numeroMaxTabs);

		this.setLayout(new MigLayout("fill"));
		
		
		this.panelTabs = new TabbedPanePersonalizado();
		this.panelTabs.setTabPlacement(JTabbedPane.TOP);
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		
		new NewTab(this.getPanelTabs(), this.getNumeroMaxTabs());
 
		add(this.panelTabs,"grow");
		
		GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].setFullScreenWindow(this);
		//setLocation(posicion);
		setTitle(this.getNombre());
		//setSize(tamano);
		setVisible(true);
		//setLayout(new GridLayout(1, 1));
		
		

	}
	
	
	public void anadirBoton(JTabbedPane paneltab) {

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

	public TabbedPanePersonalizado getPanelTabs() {
		return panelTabs;
	}

	public void setPanelTabs(TabbedPanePersonalizado panelTabs) {
		this.panelTabs = panelTabs;
	}

	public int getNumeroMaxTabs() {
		return numeroMaxTabs;
	}

	public void setNumeroMaxTabs(int numeroMaxTabs) {
		this.numeroMaxTabs = numeroMaxTabs;
	}

	

}
