package vista;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import componentes.BotonPersonalizado;
import componentes.TabbedPanePersonalizado;
import componentes.TextFieldPersonalizado;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class NewTab extends JPanel implements MouseListener {

	private JButton nuevaTab;
	private TabbedPanePersonalizado panel;
	private int numeroMaxTabs;

	public NewTab(TabbedPanePersonalizado panel, int numeroMaxTabs) {
		
		this.panel = panel;
		this.numeroMaxTabs = numeroMaxTabs;
		this.setLayout(new MigLayout());
		this.setBounds(0, 0, 500, 500);
		this.panel.insertTab("Nuevo", null, null, "Nueva Pestaña", 0);
		
		this.panel.getModel().clearSelection();
		this.panel.addMouseListener(this);

	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			TabbedPanePersonalizado panel1 = (TabbedPanePersonalizado) e.getSource();
			if (panel1.getSelectedIndex() == 0 & this.getNumeroMaxTabs() >= panel1.getTabCount()) {
				
				Tab tab = new Tab(this.panel);
				this.getPanel().getListaTabs().add(tab);
				this.getPanel().addTab("Tab", tab);
				BotonPersonalizado boton = null;
				TextFieldPersonalizado nombreCabecera=null;
				boton = new BotonPersonalizado();
				nombreCabecera=new TextFieldPersonalizado(){ 
				    @Override public void setBorder(Border border) { 
				        // No! 
				       } 
				   }; 
				nombreCabecera.setOpaque(false);
				
				
				this.getPanel().getComponents()[(this.getPanel().getComponentCount() - 1)]
						.setName(String.valueOf((this.getPanel().getComponentCount() - 1)));
				boton.setName(String.valueOf((this.getPanel().getComponentCount() - 1)));
				
				boton.setText("X");
				boton.addMouseListener(this);
				JPanel componenteCabecera=new JPanel();
				componenteCabecera.add(nombreCabecera);
				componenteCabecera.add(boton);
				if (this.getPanel().getComponentCount() == 1) {
					nombreCabecera.setText("Nombre"+this.getPanel().getComponentCount());
					panel1.setTabComponentAt(this.getPanel().getComponentCount(), componenteCabecera);
				} else {
					nombreCabecera.setText("Nombre"+(this.getPanel().getComponentCount() - 1));
					panel1.setTabComponentAt(this.getPanel().getComponentCount() - 1, componenteCabecera);
				}

			}
		} catch (Exception e2) {
			System.out.println("Error");
			System.out.println(e2.getMessage());
			BotonPersonalizado botonCerrar = (BotonPersonalizado) e.getSource();

			if (botonCerrar != null) {
				int numeroComponentes = this.panel.getComponents().length;
				for (int i = 0; i < numeroComponentes; i++) {
					if (this.panel.getComponents()[i].getName() != null) {
						if (Integer.parseInt(this.panel.getComponents()[i].getName()) == Integer
								.parseInt(botonCerrar.getName())) {

							this.getPanel().getListaTabs().remove(this.panel.getComponents()[i]);

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

	public TabbedPanePersonalizado getPanel() {
		return panel;
	}

	public void setPanel(TabbedPanePersonalizado panel) {
		this.panel = panel;
	}

	public int getNumeroMaxTabs() {
		return numeroMaxTabs;
	}

	public void setNumeroMaxTabs(int numeroMaxTabs) {
		this.numeroMaxTabs = numeroMaxTabs;
	}

}
