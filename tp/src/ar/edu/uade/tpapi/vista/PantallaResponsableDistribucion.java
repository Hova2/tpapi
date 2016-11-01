package ar.edu.uade.tpapi.vista;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class PantallaResponsableDistribucion extends javax.swing.JFrame {
	private JButton agregar;
	private JButton listar;
	private JButton salir;
	private JButton consultar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PantallaResponsableDistribucion inst = new PantallaResponsableDistribucion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PantallaResponsableDistribucion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Administración de Reclamos  - Distribución");
			pack();
			setSize(400, 300);
			getContentPane().setLayout(null);
			{
				agregar = new JButton();
				getContentPane().add(agregar);
				agregar.setText("Agregar Reclamo");
				agregar.setBounds(121, 36, 114, 23);
			}
			{
				consultar = new JButton();
				getContentPane().add(consultar);
				consultar.setText("Consultar Reclamo");
				consultar.setBounds(121, 83, 114, 23);
			}
			{
				listar = new JButton();
				getContentPane().add(listar);
				listar.setText("Listar Reclamos");
				listar.setBounds(121, 132, 114, 23);
				listar.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt) {
						ListaReclamosResponsableDistribucion ld = new ListaReclamosResponsableDistribucion();
						ld.setVisible(true);
					}
				});
			}
			{
				salir = new JButton();
				getContentPane().add(salir);
				salir.setText("Salir");
				salir.setBounds(121, 191, 114, 23);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
