package vista;

import javax.swing.JButton;

public class PropiedadesVentana {

	public static void PropiedadesVentana(Ventana vista) {

	}

	public static void PropiedadesBotones(Ventana vista) {
		for (JButton boton : vista.getListaBotones()) {
			vista.add(boton);
			boton.addActionListener(vista);
		}
		
	}

	public static void PropiedadesText(Ventana vista) {

	}

	public static void PropiedadesTabla(Ventana vista) {

	}

}
