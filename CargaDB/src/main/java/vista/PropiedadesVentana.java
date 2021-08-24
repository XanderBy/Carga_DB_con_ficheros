package vista;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import configuracion.Configuracion;

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
		//for (TablaPersonalizado tabla : tab.getListaTablas()) {

			JScrollPane scrollPane = new JScrollPane(tab.getListaTablas().get(0));
			// Force the scrollbars to always be displayed
			//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

			GroupLayout groupLayout = new GroupLayout(tab);
			groupLayout
					.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
							groupLayout.createSequentialGroup().addContainerGap().addGroup(
									groupLayout.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
											GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))));
			
			groupLayout
			.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
					groupLayout.createSequentialGroup().addContainerGap().addGroup(
							groupLayout.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
									GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))));
	

			//tab.setLayout(groupLayout);
			tab.getListaTablas().get(0).setLayout(groupLayout);
			tab.add(new JScrollPane(tab.getListaTablas().get(0)));
			tab.add(tab.getListaTablas().get(0));
			// tab.add(scrollPane);
			// tab.getListaScroll().add(scrollPane);

		//}
	}

	public static void DependienteTablas() {

	}
}
