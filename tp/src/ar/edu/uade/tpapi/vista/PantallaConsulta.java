package ar.edu.uade.tpapi.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class PantallaConsulta extends javax.swing.JFrame {
	private JButton rankingClientes;
	private JButton tiempoPromedioRta;
	private JButton rankingTratamientoReclamo;
	private JButton cantReclamosMes;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PantallaConsulta inst = new PantallaConsulta();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PantallaConsulta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Reportes");
			{
				rankingClientes = new JButton();
				getContentPane().add(rankingClientes);
				rankingClientes.setText("Ranking de clientes");
				rankingClientes.setBounds(150, 12, 293, 21);
				rankingClientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						PantallaRankingClientes pRC = new PantallaRankingClientes();
						pRC.setVisible(true);
					}
				});
			}
			{
				cantReclamosMes = new JButton();
				getContentPane().add(cantReclamosMes);
				cantReclamosMes.setText("Cantidad de reclamos por mes");
				cantReclamosMes.setBounds(150, 54, 293, 21);
				cantReclamosMes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						PantallaReclamosMes pRM = new PantallaReclamosMes();
						pRM.setVisible(true);
					}
				});
			}
			{
				rankingTratamientoReclamo = new JButton();
				getContentPane().add(rankingTratamientoReclamo);
				rankingTratamientoReclamo.setText("Ranking de Tratamiento de Reclamos");
				rankingTratamientoReclamo.setBounds(150, 94, 293, 23);
			}
			{
				tiempoPromedioRta = new JButton();
				getContentPane().add(tiempoPromedioRta);
				tiempoPromedioRta.setText("Tiempo promedio de respuestas por responsable");
				tiempoPromedioRta.setBounds(150, 135, 293, 23);
			}
			pack();
			this.setSize(565, 367);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
