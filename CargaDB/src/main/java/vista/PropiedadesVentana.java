package vista;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import componentes.BotonPersonalizado;
import componentes.ComboBoxPersonalizado;
import componentes.TablaPersonalizado;

public class PropiedadesVentana {

	public static void PropiedadesVentana(Ventana vista) {

	}

	public static void PropiedadesBotones(Tab tab) {
		for (BotonPersonalizado boton : tab.getListaBotones()) {
			if (boton.getDependeComponente() != null && boton.getDependeComponente().length() > 0) {
				boton.setEnabled(false);
			}
			tab.add(boton);
			boton.addActionListener(tab);
		}

	}

	public static void DependienteBotones() {

	}

	public static void PropiedadesTitulos(Tab tab) {
		for (JLabel titulo : tab.getListaTitulos()) {
			tab.add(titulo);
		}

	}

	public static void DependienteTitulos() {

	}

	public static void PropiedadesCajaText(Tab tab) {
		for (JTextField textField : tab.getListaCajaTexto()) {
			tab.add(textField);
		}
	}

	public static void DependienteCajaText() {

	}

	public static void PropiedadesComboBox(Tab tab) {
		for (ComboBoxPersonalizado comboBox : tab.getListaTComboBox()) {
			tab.add(comboBox);
			comboBox.addActionListener(tab);
		}
	}

	public static void DependienteComboBox() {

	}

	public static void PropiedadesTablas(Tab tab) {
		for (TablaPersonalizado tabla : tab.getListaTablas()) {

			tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JScrollPane scrollPane = null;
			tabla.setPreferredSize(null);
			// jTable.setBounds(new Rectangle(17, 250, 500, 100));
			// jTable.enable(false);
			tabla.setEnabled(false);
			// jTable.getAutoscrolls();
			// jTable.getRowHeight(10);
			scrollPane = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			tabla.setFillsViewportHeight(true);

			tab.add(tabla);
			// tab.add(scrollPane);
			// tab.getListaScroll().add(scrollPane);

		}
	}

	public static void DependienteTablas() {

	}
}
