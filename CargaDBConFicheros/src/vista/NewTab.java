package vista;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import configuracion.Configuracion;

@SuppressWarnings("serial")
public class NewTab extends JPanel implements MouseListener {

	private JButton nuevaTab;
	private JTabbedPane panel;
	private int numeroMaxTabs;

	public NewTab(JTabbedPane panel, int numeroMaxTabs) {

		this.panel = panel;
		this.numeroMaxTabs = numeroMaxTabs;

		this.panel.insertTab("Nuevo", null, null, "Nueva Pesta�a", 0);

		this.panel.getModel().clearSelection();
		this.panel.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			JTabbedPane panel1 = (JTabbedPane) e.getSource();
			if (panel1.getSelectedIndex() == 0 & this.getNumeroMaxTabs() >= panel1.getTabCount()) {
				
				Tab tab = new Tab(this.panel);
				this.getPanel().addTab("Tab", tab);
				JButton boton = null;
				
				boton = new JButton();
				this.getPanel().getComponents()[(this.getPanel().getComponentCount() - 1)]
						.setName(String.valueOf((this.getPanel().getComponentCount() - 1)));
				boton.setName(String.valueOf((this.getPanel().getComponentCount() - 1)));
				
				boton.setText("X");
				boton.addMouseListener(this);

				if (this.getPanel().getComponentCount() == 1) {
					panel1.setTabComponentAt(this.getPanel().getComponentCount(), boton);
				} else {
					panel1.setTabComponentAt(this.getPanel().getComponentCount() - 1, boton);
				}

			}
		} catch (Exception e2) {
			
			JButton botonCerrar = (JButton) e.getSource();

			if (botonCerrar != null) {
				int numeroComponentes = this.panel.getComponents().length;
				for (int i = 0; i < numeroComponentes; i++) {
					if (this.panel.getComponents()[i].getName() != null) {
						if (Integer.parseInt(this.panel.getComponents()[i].getName()) == Integer
								.parseInt(botonCerrar.getName())) {
							this.panel.remove(this.panel.getComponents()[i]);
							break;
						}
					}

				}

			}

		} finally {
			this.getPanel().repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public JButton getNuevaTab() {
		return nuevaTab;
	}

	public void setNuevaTab(JButton nuevaTab) {
		this.nuevaTab = nuevaTab;
	}

	public JTabbedPane getPanel() {
		return panel;
	}

	public void setPanel(JTabbedPane panel) {
		this.panel = panel;
	}

	public int getNumeroMaxTabs() {
		return numeroMaxTabs;
	}

	public void setNumeroMaxTabs(int numeroMaxTabs) {
		this.numeroMaxTabs = numeroMaxTabs;
	}

}
