package ar.edu.uade.tpapi.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

import ar.edu.uade.tpapi.controlador.Controlador;


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
public class ClienteAlta extends javax.swing.JFrame {

	private static ClienteAlta instancia;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton jButton2;
	private JButton jButton1;
	private JTextField mail;
	private JTextField telefono;
	private JTextField domicilio;
	private JLabel jLabel4;
	private JTextField nombre;
	private JLabel jLabel1;

	private ClienteAlta() {
		super();
		initGUI();
	}
	
	public static ClienteAlta getInstance(){
		return (instancia!=null) ? instancia : new ClienteAlta();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta de cliente");
			getContentPane().setLayout(null);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setVisible(false);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre");
				jLabel1.setBounds(12, 12, 55, 22);
			}
			{
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(91, 13, 197, 22);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Domicilio");
				jLabel2.setBounds(12, 40, 68, 22);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Telefono");
				jLabel3.setBounds(12, 68, 67, 22);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Mail");
				jLabel4.setBounds(12, 96, 30, 22);
			}
			{
				domicilio = new JTextField();
				getContentPane().add(domicilio);
				domicilio.setBounds(91, 41, 197, 22);
			}
			{
				telefono = new JTextField();
				getContentPane().add(telefono);
				telefono.setBounds(91, 69, 197, 22);
			}
			{
				mail = new JTextField();
				getContentPane().add(mail);
				mail.setBounds(91, 97, 197, 22);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Aceptar");
				jButton1.setBounds(30, 136, 103, 22);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						Controlador.getInstance().altaCliente(nombre.getText(), domicilio.getText(), telefono.getText(), mail.getText());
						limpiarPantalla();
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Cancelar");
				jButton2.setBounds(153, 136, 103, 22);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {						
						limpiarPantalla();
					}
				});
			}
			pack();
			this.setSize(305, 194);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void limpiarPantalla(){	
		nombre.setText("");
		domicilio.setText("");
		telefono.setText("");
		mail.setText("");
	}	

}
