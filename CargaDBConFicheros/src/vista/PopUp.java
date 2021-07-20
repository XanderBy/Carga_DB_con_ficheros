package vista;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PopUp extends JOptionPane {


	public static String[] showInputDialog(Component parentComponent, String messages[]) {
		JTextField textFields[] = new JTextField[messages.length];
		JPanel panel = new JPanel();
		String input[] = new String[messages.length];

		panel.setLayout(new GridLayout(messages.length, 2, 0, 0));

		for (int i = 0; i < messages.length; i++) {
			panel.add(new JLabel(messages[i]));
			textFields[i] = new JTextField();
			panel.add(textFields[i]);
		}

		JOptionPane.showConfirmDialog(parentComponent, panel, "Datos Conexión", JOptionPane.OK_CANCEL_OPTION);

		for (int i = 0; i < messages.length; i++)
			input[i] = textFields[i].getText();

		return input;
	}

}
