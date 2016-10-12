package ar.edu.uade.tpapi.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;

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
public class PantallaReclamoZona extends javax.swing.JFrame {
	
	private static PantallaReclamoZona instancia;
	private JLabel jLabel1;
	private JButton aceptar;
	private JButton cancelar;
	private JTextArea descripcion;
	private JTextField dniCliente;
	private JLabel jLabel2;

	/**
	* Auto-generated main method to display this JFrame
	*/

	public static PantallaReclamoZona getInstance(){
		if (instancia==null){
				instancia=new PantallaReclamoZona();
			}
		return instancia;
	}
	
	public PantallaReclamoZona() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Alta reclamo zona");
			getContentPane().setLayout(null);
			this.setLocationRelativeTo(null);
			{
				descripcion = new JTextArea();
				getContentPane().add(descripcion);
				descripcion.setBounds(18, 86, 452, 97);
				descripcion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
				descripcion.setLineWrap(true);
				descripcion.setWrapStyleWord(true);				
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Dni cliente:");
				jLabel1.setBounds(218, 12, 65, 21);
			}
			{
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Aceptar");
				aceptar.setBounds(131, 194, 82, 21);
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						Controlador.getInstance().altaReclamoZona(Long.parseLong(dniCliente.getText()), descripcion.getText());
						limpiarPantalla();
					}
				});
			}
			{
				cancelar = new JButton();
				getContentPane().add(cancelar);
				cancelar.setText("Cancelar");
				cancelar.setBounds(292, 194, 91, 21);
				cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) { 
						setVisible(false);
						limpiarPantalla();
						dispose();
					}
				});
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Descripcion:");
				jLabel2.setBounds(213, 66, 79, 14);
			}
			{
				dniCliente = new JTextField();
				getContentPane().add(dniCliente);
				dniCliente.setBounds(192, 39, 99, 21);
				dniCliente.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			pack();
			this.setSize(502, 261);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void limpiarPantalla(){	
		dniCliente.setText("");
		descripcion.setText("");
	}
}
