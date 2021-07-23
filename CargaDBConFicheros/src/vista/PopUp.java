package vista;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PopUp extends JOptionPane {

	public String[] showInputDialog(Component parentComponent, String messages[], String textoDefault[]) {
		JTextField textFields[] = new JTextField[messages.length];
		boolean vacio = true;
		String valorAux = new String();
		JPanel panel = new JPanel();
		String input[] = new String[messages.length];
		int cancelar = 0;
		panel.setLayout(new GridLayout(messages.length, 2, 0, 0));

		for (int i = 0; i < messages.length; i++) {
			panel.add(new JLabel(messages[i]));
			textFields[i] = new JTextField();
			panel.add(textFields[i]);
		}

		cancelar = JOptionPane.showConfirmDialog(parentComponent, panel, "Datos Conexión",
				JOptionPane.OK_CANCEL_OPTION);
		if (cancelar != 2) {

			for (int i = 0; i < messages.length; i++) {
				input[i] = textFields[i].getText();
				if (input[i].length() > 0) {
					vacio = false;
				}
			}

		}
		if (vacio)
			input = new String[0];

		return input;
	}

}
