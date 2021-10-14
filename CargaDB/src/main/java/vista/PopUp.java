package vista;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PopUp extends JOptionPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String[] showInputDialog(Component parentComponent, String messages[], String textoDefault[]) {
		JTextField textFields[] = new JTextField[messages.length];
		JPanel panel = new JPanel();
		String input[] = new String[messages.length];
		int cancelar = 0;
		
		panel.setLayout(new GridLayout(messages.length, 2, 0, 0));
		
		for (int i = 0; i < messages.length; i++) {
			panel.add(new JLabel(messages[i]));
			
			if(i==(messages.length-1)) {
				JPasswordField pass = new JPasswordField(15);
				textFields[i]=pass;
				panel.add(pass);
			}else {
				textFields[i] = new JTextField();
				panel.add(textFields[i]);
			}
			 
		}
		String[] options = new String[]{"OK", "Cancel"};
		
		cancelar = JOptionPane.showOptionDialog(parentComponent, panel, "Datos Conexión",
				JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,null);
		int contadorTextoIntroducido=0;
		System.out.println(cancelar);
		if (cancelar != 1) {
			
			for (int i = 0; i < messages.length; i++) {
				if(textFields[i]==null) {
					contadorTextoIntroducido ++;
				}else {
					input[i] = textFields[i].getText();
				}
				
			}

		}else {
			input[0]="Ha pulsado cancelar";
			contadorTextoIntroducido++;
		}
		if (contadorTextoIntroducido==messages.length)
			input = new String[0];

		return input;
	}

}
