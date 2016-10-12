package ar.edu.uade.tpapi.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class PantallaLogin extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JPasswordField password;
	private JButton cancelar;
	private JButton aceptar;
	private JTextField login;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PantallaLogin inst = new PantallaLogin();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PantallaLogin() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Pantalla login");
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				jLabel1.setLayout(null);
				getContentPane().add(jLabel1);
				jLabel1.setText("Login:");
				jLabel1.setBounds(107, 12, 38, 20);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Password:");
				jLabel2.setBounds(100, 77, 67, 14);
			}
			{
				login = new JTextField();
				getContentPane().add(login);
				login.setBounds(12, 44, 223, 21);
			}
			{
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Aceptar");
				aceptar.setBounds(7, 144, 100, 21);
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if(login.getText().equals("pepe") && String.valueOf(password.getPassword()).equals("pepe")){
							PantallaResponsableZona pRZ = new PantallaResponsableZona();
							pRZ.setVisible(true);
						}
						setVisible(false);
						limpiarPantalla();
						dispose();
					}
				});
			}
			{
				cancelar = new JButton();
				getContentPane().add(cancelar);
				cancelar.setText("Cancelar");
				cancelar.setBounds(136, 144, 100, 21);
				cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.exit(0); 
					}
				});
			}
			{
				password = new JPasswordField();
				getContentPane().add(password);
				password.setBounds(12, 98, 223, 21);
			}
			pack();
			this.setSize(255, 204);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void limpiarPantalla(){	
		login.setText("");
		password.setText("");
	}
}
