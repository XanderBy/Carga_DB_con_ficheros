package componentes;

import java.util.ArrayList;

import javax.swing.JTabbedPane;

import vista.Tab;

public class TabbedPanePersonalizado extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Tab> listaTabs;

	public TabbedPanePersonalizado() {
		super();
		this.listaTabs = new ArrayList<>();
	}

	public ArrayList<Tab> getListaTabs() {
		return listaTabs;
	}

	public void setListaTabs(ArrayList<Tab> listaTabs) {
		this.listaTabs = listaTabs;
	}

}
