package ar.edu.uade.tpapi.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
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
public class PantallaCambioEstado extends javax.swing.JFrame {

	private static PantallaCambioEstado instancia;
	private JRadioButton cerrado;
	private JRadioButton enTratamiento;
	private ButtonGroup estados;
	private JLabel lNroReclamo;
	private JButton aceptar;
	private JButton cancelar;
	private JTextField nroReclamo;

	private PantallaCambioEstado() {
		super();
		initGUI();
	}
	
	public static PantallaCambioEstado getInstance(){
		if (instancia==null){
				instancia=new PantallaCambioEstado();
			}
		return instancia;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			this.setTitle("Cambio de estado");
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
						if(getEstados().getSelection().getActionCommand().equals("2")){
							Controlador.getInstance().cambiarEstado(2, Long.parseLong(nroReclamo.getText()));
						}else{
							Controlador.getInstance().cambiarEstado(3, Long.parseLong(nroReclamo.getText()));
						}
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
				nroReclamo = new JTextField();
				getContentPane().add(nroReclamo);
				getContentPane().add(getEnTratamiento());
				getContentPane().add(getCerrado());
				nroReclamo.setBounds(193, 39, 99, 21);
				nroReclamo.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			pack();
			setSize(502, 261);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void limpiarPantalla(){	
		nroReclamo.setText("");
		getEnTratamiento().setSelected(true);
		getCerrado().setSelected(false);
	}
	
	private ButtonGroup getEstados() {
		if(estados == null) {
			estados = new ButtonGroup();
		}
		return estados;
	}
	
	private JRadioButton getEnTratamiento() {
		if(enTratamiento == null) {
			enTratamiento = new JRadioButton();
			enTratamiento.setText("En tratamiento");
			getEstados().add(enTratamiento);
			enTratamiento.setBounds(137, 125, 117, 33);
			enTratamiento.setSelected(true);
			enTratamiento.setVerticalTextPosition(SwingConstants.BOTTOM);
			enTratamiento.setActionCommand("2");
		}
		return enTratamiento;
	}
	
	private JRadioButton getCerrado() {
		if(cerrado == null) {
			cerrado = new JRadioButton();
			cerrado.setText("Cerrado");
			cerrado.setBounds(278, 125, 84, 33);
			getEstados().add(cerrado);
			cerrado.setVerticalTextPosition(SwingConstants.BOTTOM);
			cerrado.setActionCommand("3");
		}
		return cerrado;
	}

}
