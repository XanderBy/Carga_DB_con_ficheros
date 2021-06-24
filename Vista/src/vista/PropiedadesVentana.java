package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PropiedadesVentana {

	public static void PropiedadesVentana(Ventana vista) {

	}

	public static void PropiedadesBotones(Ventana vista, JPanel panel) {
		for (JButton boton : vista.getListaBotones()) {
			panel.add(boton);
			boton.addActionListener(vista);
		}

	}

	public static void PropiedadesTitulos(Ventana vista, JPanel panel) {
		for (JLabel titulo : vista.getListaTitulos()) {
			panel.add(titulo);
		}

	}

	public static void PropiedadesText(Ventana vista) {

	}

	public static void PropiedadesTabla(Ventana vista) {

	}

}
