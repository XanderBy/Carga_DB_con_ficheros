package vista;

import java.awt.Component;
import javax.swing.JButton;

public class BotonCerrar extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
