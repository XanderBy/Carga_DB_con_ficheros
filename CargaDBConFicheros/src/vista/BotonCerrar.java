package vista;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

public class BotonCerrar extends JButton {

	private Component panel;
	
	public BotonCerrar(Component panel) {
		this.panel=panel;
	}

	public Component getPanel() {
		return panel;
	}

	public void setPanel(Component panel) {
		this.panel = panel;
	}
	
}
