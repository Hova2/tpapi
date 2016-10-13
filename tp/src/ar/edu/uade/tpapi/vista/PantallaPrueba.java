package ar.edu.uade.tpapi.vista;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
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
public class PantallaPrueba extends javax.swing.JFrame {
	private JPanel reclamo;
	private JTextArea descripcion;
	private JLabel nroReclamo;
	private JLabel lNombreCliente;
	private JLabel lDescripcion;
	private JLabel estado;
	private JLabel lEstado;
	private JLabel dniCliente;
	private JLabel lDniCLiente;
	private JLabel nombreCliente;
	private JLabel fechaAlta;
	private JLabel lFechaAlta;
	private JLabel lNroReclamo;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PantallaPrueba inst = new PantallaPrueba();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PantallaPrueba() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				reclamo = new JPanel();
				getContentPane().add(reclamo, BorderLayout.CENTER);
				reclamo.setLayout(null);
				reclamo.setPreferredSize(new java.awt.Dimension(597, 348));
				reclamo.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				{
					lNroReclamo = new JLabel();
					reclamo.add(lNroReclamo);
					lNroReclamo.setText("NroReclamo:");
					lNroReclamo.setBounds(278, 33, 75, 17);
					lNroReclamo.setFont(new java.awt.Font("Tahoma",1,11));
				}
				{
					nroReclamo = new JLabel();
					reclamo.add(nroReclamo);
					nroReclamo.setBounds(365, 33, 61, 16);
					nroReclamo.setText("nroReclamo");
				}
				{
					lFechaAlta = new JLabel();
					reclamo.add(lFechaAlta);
					lFechaAlta.setText("Fecha de alta:");
					lFechaAlta.setBounds(13, 34, 86, 14);
					lFechaAlta.setFont(new java.awt.Font("Tahoma",1,11));
				}
				{
					fechaAlta = new JLabel();
					reclamo.add(fechaAlta);
					fechaAlta.setText("fechaAlta");
					fechaAlta.setBounds(99, 34, 75, 14);
				}
				{
					lNombreCliente = new JLabel();
					reclamo.add(lNombreCliente);
					lNombreCliente.setText("Cliente:");
					lNombreCliente.setBounds(13, 79, 48, 14);
					lNombreCliente.setFont(new java.awt.Font("Tahoma",1,11));
				}
				{
					nombreCliente = new JLabel();
					reclamo.add(nombreCliente);
					nombreCliente.setText("nombreCLiente");
					nombreCliente.setBounds(67, 79, 72, 14);
				}
				{
					lDniCLiente = new JLabel();
					reclamo.add(lDniCLiente);
					lDniCLiente.setText("Dni del cliente:");
					lDniCLiente.setBounds(369, 79, 88, 14);
					lDniCLiente.setFont(new java.awt.Font("Tahoma",1,11));
				}
				{
					dniCliente = new JLabel();
					reclamo.add(dniCliente);
					dniCliente.setText("dniCliente");
					dniCliente.setBounds(463, 79, 47, 14);
				}
				{
					lEstado = new JLabel();
					reclamo.add(lEstado);
					lEstado.setText("Estado del reclamo:");
					lEstado.setBounds(282, 121, 112, 14);
					lEstado.setFont(new java.awt.Font("Tahoma",1,11));
				}
				{
					estado = new JLabel();
					reclamo.add(estado);
					estado.setText("estado");
					estado.setBounds(400, 121, 195, 14);
				}
				{
					lDescripcion = new JLabel();
					reclamo.add(lDescripcion);
					lDescripcion.setText("Descripcion:");
					lDescripcion.setBounds(13, 121, 71, 14);
					lDescripcion.setFont(new java.awt.Font("Tahoma",1,11));
				}
				{
					descripcion = new JTextArea();
					reclamo.add(descripcion);
					descripcion.setBounds(13, 141, 582, 102);
					descripcion.setEditable(false);
					descripcion.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					descripcion.setWrapStyleWord(true);
					descripcion.setLineWrap(true);
				}
			}
			pack();
			this.setSize(616, 283);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
