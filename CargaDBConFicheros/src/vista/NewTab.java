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

		this.panel.insertTab("Nuevo", null, null, "Nueva Pestaña", 0);
		
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
				System.out.println("holaaaaa"+this.getPanel().getTabCount());
				if((this.getPanel().getComponentCount() - 1000)==0) {
					System.out.println(this.getPanel().getComponentCount());
					boton=new JButton();
					System.out.println("sssa"+this.getPanel().getComponentCount());

					this.getPanel().getComponents()[(this.getPanel().getComponentCount()-1)].setName(String.valueOf((this.getPanel().getComponentCount()-1)));
					boton.setName(String.valueOf((this.getPanel().getComponentCount()-1)));
				}else {
					System.out.println("Es una tonteria"+this.getPanel().getComponentCount());
					boton=new JButton();
					
					this.getPanel().getComponents()[(this.getPanel().getComponentCount()-1)].setName(String.valueOf((this.getPanel().getComponentCount()-1)));
					
					boton.setName(String.valueOf((this.getPanel().getComponentCount()-1)));
				}
				
				boton.setText("X");
				boton.addMouseListener(this);
				//System.out.println(panel1.getTabCount());
				System.out.println("sss"+this.getPanel().getComponentCount());
				panel1.setTabComponentAt(this.getPanel().getComponentCount(), boton);
				
			}
		} catch (Exception e2) {
			System.out.println(e2);
			JButton botonCerrar = (JButton) e.getSource();
			System.out.println(botonCerrar);
			if(botonCerrar != null) {
				//System.out.println(botonCerrar.getPanel());
				System.out.println("tab"+this.panel.getComponents()[0]);
				System.out.println("tab"+this.panel.getComponents()[1]);
				System.out.println("tab"+this.panel.getComponents()[2]);
				System.out.println("tab"+this.panel.getComponents()[3]);
				System.out.println("tab"+this.panel.getComponents()[4]);
				System.out.println("boton"+botonCerrar.getName());
				int numeroComponentes=this.panel.getComponents().length;
				for (int i=0; i<numeroComponentes; i++) {
					if(this.panel.getComponents()[i].getName()!=null) {
						System.out.println("Aun no entro"+this.panel.getComponents()[i].getName());
						if(Integer.parseInt(this.panel.getComponents()[i].getName())==Integer.parseInt(botonCerrar.getName())) {
							System.out.println("Entó"+ this.panel.getComponents()[i]);
							this.panel.remove(this.panel.getComponents()[i]);
							break;
						}
					}
					
					
					
				}
				
			}
			

		}finally {
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
