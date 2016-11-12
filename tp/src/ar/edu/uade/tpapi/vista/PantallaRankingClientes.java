package ar.edu.uade.tpapi.vista;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;

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
public class PantallaRankingClientes extends javax.swing.JFrame {
	private JLabel mensaje;
	private JLabel cliente1;
	private JLabel clienteView5;
	private JLabel clienteView4;
	private JLabel clienteView3;
	private JLabel clienteView2;
	private JLabel clienteView1;
	private JLabel cliente5;
	private JLabel cliente4;
	private JLabel cliente3;
	private JLabel cliente2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PantallaRankingClientes inst = new PantallaRankingClientes();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PantallaRankingClientes() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Ranking de Clientes");
			Vector<ClienteView> clientesViewTmp = Controlador.getInstance().rankingClientes();
			{
				mensaje = new JLabel();
				getContentPane().add(mensaje);
				mensaje.setText("Ranking de los primeros 5 cientes ordenados de mayor a menor");
				mensaje.setBounds(12, 12, 471, 41);
				mensaje.setFont(new java.awt.Font("Tahoma",1,14));
				mensaje.setBorder(BorderFactory.createCompoundBorder(
						null, 
						null));
				mensaje.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				cliente1 = new JLabel();
				getContentPane().add(cliente1);
				cliente1.setText("Cliente 1");
				cliente1.setBounds(124, 65, 59, 14);
			}
			{
				cliente2 = new JLabel();
				getContentPane().add(cliente2);
				cliente2.setText("Cliente 2");
				cliente2.setBounds(124, 85, 59, 14);
			}
			{
				cliente3 = new JLabel();
				getContentPane().add(cliente3);
				cliente3.setText("Cliente 3");
				cliente3.setBounds(124, 105, 59, 14);
			}
			{
				cliente4 = new JLabel();
				getContentPane().add(cliente4);
				cliente4.setText("Cliente 4");
				cliente4.setBounds(124, 125, 59, 14);
			}
			{
				cliente5 = new JLabel();
				getContentPane().add(cliente5);
				cliente5.setText("Cliente 5");
				cliente5.setBounds(124, 145, 59, 14);
			}
			{
				clienteView1 = new JLabel();
				getContentPane().add(clienteView1);
				if(clientesViewTmp.size()>=1)
					clienteView1.setText(clientesViewTmp.get(0).getNombre());
				clienteView1.setBounds(195, 65, 239, 14);
			}
			{
				clienteView2 = new JLabel();
				getContentPane().add(clienteView2);
				if(clientesViewTmp.size()>=2)
					clienteView2.setText(clientesViewTmp.get(1).getNombre());
				clienteView2.setBounds(195, 85, 239, 14);
			}
			{
				clienteView3 = new JLabel();
				getContentPane().add(clienteView3);
				if(clientesViewTmp.size()>=3)
					clienteView3.setText(clientesViewTmp.get(2).getNombre());
				clienteView3.setBounds(195, 105, 178, 14);
			}
			{
				clienteView4 = new JLabel();
				getContentPane().add(clienteView4);
				if(clientesViewTmp.size()>=4)
					clienteView4.setText(clientesViewTmp.get(3).getNombre());
				clienteView4.setBounds(195, 125, 239, 14);
			}
			{
				clienteView5 = new JLabel();
				getContentPane().add(clienteView5);
				if(clientesViewTmp.size()>=5)
					clienteView5.setText(clientesViewTmp.get(4).getNombre());
				clienteView5.setBounds(195, 145, 239, 14);
			}
			pack();
			this.setSize(503, 370);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
