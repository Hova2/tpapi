package ar.edu.uade.tpapi.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
public class PantallaBuscarAccionReclamo extends javax.swing.JFrame {

	private JLabel lNroReclamo;
	private JButton aceptar;
	private JButton cancelar;
	private JTextField nroReclamo;
	private Vector<ReclamoZonaView> reclamosZonaView;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	
	
	public PantallaBuscarAccionReclamo(Vector<ReclamoZonaView> reclamosZonaView) {
		super();
		this.reclamosZonaView = reclamosZonaView;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);
			this.setTitle("Buscar acciones de un reclamo");
			{
				lNroReclamo = new JLabel();
				getContentPane().add(lNroReclamo);
				lNroReclamo.setText("Nro de reclamo:");
				lNroReclamo.setBounds(205, 64, 99, 21);
			}
			{
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Ver");
				aceptar.setBounds(131, 194, 82, 21);
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ReclamoZonaView reclamoZonaView = null;
						for(int i = 0; i<reclamosZonaView.size(); i++){
							if(reclamosZonaView.get(i).getNroReclamo() == Long.parseLong(nroReclamo.getText())){
								reclamoZonaView = reclamosZonaView.get(i);
								break;
							}
						}
						if (reclamoZonaView != null){
							PantallaVerAccionesReclamo pVAR = new PantallaVerAccionesReclamo(reclamoZonaView.getAcciones(),
									Long.parseLong(nroReclamo.getText()));
							pVAR.setVisible(true);
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
				nroReclamo.setBounds(198, 102, 99, 21);
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
	}
}
