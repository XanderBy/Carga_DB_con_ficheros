package vista;

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
	

	public NewTab(JTabbedPane panel,int numeroMaxTabs) {

		this.panel = panel;
		this.numeroMaxTabs= numeroMaxTabs;
		
		this.panel.insertTab("Nuevo", null, null, "Nueva Pestaña", 0);
		this.panel.getModel().clearSelection();
		this.panel.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JTabbedPane panel1 = (JTabbedPane) e.getSource();
		if (panel1.getSelectedIndex() == 0 & this.getNumeroMaxTabs()>= panel1.getTabCount()) {
			
			Tab tab=new Tab(this.panel);
			this.getPanel().addTab("Tab", tab);
			this.getPanel().repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
