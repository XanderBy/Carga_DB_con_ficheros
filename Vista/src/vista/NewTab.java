package vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class NewTab extends JPanel implements MouseListener {

	private JButton nuevaTab;
	private JTabbedPane panel;

	public NewTab(JTabbedPane panel) {

		this.panel = panel;

		this.panel.insertTab("Nuevo", null, null, "Nueva Pestaña", 0);
		this.panel.getModel().clearSelection();
		this.panel.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click");
		JTabbedPane panel = (JTabbedPane) e.getSource();
		if (panel.getSelectedIndex() == 0) {
			JPanel tab = new JPanel();
			this.panel.addTab("Tab", tab);
			this.panel.repaint();
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

}
