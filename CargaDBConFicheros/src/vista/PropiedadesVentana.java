package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PropiedadesVentana {

	public static void PropiedadesVentana(Ventana vista) {

	}

	public static void PropiedadesBotones(Tab tab) {
		for (JButton boton : tab.getListaBotones()) {
			tab.add(boton);
			boton.addActionListener(tab);
		}

	}

	public static void PropiedadesTitulos(Tab tab) {
		for (JLabel titulo : tab.getListaTitulos()) {
			tab.add(titulo);
		}

	}

	public static void PropiedadesText(Ventana vista) {

	}

	public static void PropiedadesTabla(Ventana vista) {

	}

}
