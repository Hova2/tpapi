package ar.edu.uade.tpapi.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

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
public class PantallaAltaAccion extends javax.swing.JFrame {
	
	private static PantallaAltaAccion instancia;
	private JLabel lNroReclamo;
	private JButton aceptar;
	private JButton cancelar;
	private JTextArea detalle;
	private JTextField nroReclamo;
	private JLabel lDetalle;

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public static PantallaAltaAccion getInstance(){
		if (instancia==null){
				instancia=new PantallaAltaAccion();
			}
		return instancia;
	}
	
	private PantallaAltaAccion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			this.setTitle("Alta de accion");
			{
				detalle = new JTextArea();
				getContentPane().add(detalle);
				detalle.setBounds(18, 86, 452, 97);
				detalle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
				detalle.setLineWrap(true);
				detalle.setWrapStyleWord(true);				
			}
			{
				lNroReclamo = new JLabel();
				getContentPane().add(lNroReclamo);
				lNroReclamo.setText("Nro de reclamo:");
				lNroReclamo.setBounds(198, 12, 99, 21);
			}
			{
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Aceptar");
				aceptar.setBounds(131, 194, 82, 21);
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						Controlador.getInstance().altaAccion(detalle.getText(), Long.parseLong(nroReclamo.getText()));
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
				lDetalle = new JLabel();
				getContentPane().add(lDetalle);
				lDetalle.setText("Detalle:");
				lDetalle.setBounds(18, 66, 62, 14);
			}
			{
				nroReclamo = new JTextField();
				getContentPane().add(nroReclamo);
				nroReclamo.setBounds(193, 39, 99, 21);
				nroReclamo.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			pack();
			this.setSize(502, 261);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void limpiarPantalla(){	
		nroReclamo.setText("");
		detalle.setText("");
	}
}
