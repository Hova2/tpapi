package ar.edu.uade.tpapi.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


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
public class PantallaCallCenter extends javax.swing.JFrame{
	private JMenuBar jMenuBar1;
	private JMenu jMenu1;
	private JMenuItem jMenuItem1;
	private JMenuItem reclamoFaltante;
	private JMenuItem reclamoFacturacion;
	private JMenuItem reclamoCantidad;

	public PantallaCallCenter() {
		super();
		initGUI();
	}
		
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
			{
				this.setTitle("Call Center");
				{
					jMenuBar1 = new JMenuBar();
					setJMenuBar(jMenuBar1);
					{
						jMenu1 = new JMenu();
						jMenuBar1.add(jMenu1);
						jMenu1.setText("Alta reclamos");
						{
							jMenuItem1 = new JMenuItem();
							jMenu1.add(jMenuItem1);
							jMenuItem1.setText("Reclamo zona");
							jMenuItem1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									PantallaReclamoZona.getInstance().setVisible(true);
								}
							});
						}
						{
							reclamoCantidad = new JMenuItem();
							jMenu1.add(reclamoCantidad);
							reclamoCantidad.setText("Reclamo Cantidad");
							reclamoCantidad.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									//PantallaReclamoCantidad.getInstance().setVisible(true);
								}
							});
						}
						{
							reclamoFacturacion = new JMenuItem();
							jMenu1.add(reclamoFacturacion);
							reclamoFacturacion.setText("Reclamo Facturacion");
							reclamoFacturacion.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									//PantallaReclamoFacturacion.getInstance().setVisible(true);
								}
							});
						}
						{
							reclamoFaltante = new JMenuItem();
							jMenu1.add(reclamoFaltante);
							reclamoFaltante.setText("Reclamo Faltante");
							reclamoFaltante.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									//PantallaReclamoFaltante.getInstance().setVisible(true);
								}
							});
						}
					}
				}
			}
			{
				this.setSize(448, 339);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
