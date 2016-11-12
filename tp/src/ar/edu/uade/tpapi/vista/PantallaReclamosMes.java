package ar.edu.uade.tpapi.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
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
public class PantallaReclamosMes extends javax.swing.JFrame {
	private JLabel textoMes;
	private JLabel cantidad;
	private JButton aceptar;
	private JRadioButton noviembre;
	private ButtonGroup meses;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PantallaReclamosMes inst = new PantallaReclamosMes();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PantallaReclamosMes() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				textoMes = new JLabel();
				getContentPane().add(textoMes);
				textoMes.setText("Elegir el mes");
				textoMes.setBounds(193, 29, 157, 38);
				textoMes.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				noviembre = new JRadioButton();
				getContentPane().add(noviembre);
				noviembre.setText("Noviembre");
				noviembre.setBounds(205, 71, 145, 18);
				noviembre.setHorizontalTextPosition(SwingConstants.LEADING);
				noviembre.setActionCommand("11");
				getMeses().add(noviembre);
			}
			{
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Aceptar");
				aceptar.setBounds(234, 114, 83, 30);
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						int cantTmp = Controlador.getInstance().cantReclamosMes(Integer.parseInt(getMeses().getSelection().getActionCommand()));
						cantidad.setText(Integer.toString(cantTmp));
						cantidad.setVisible(true);
					}
				});
			}
			{
				cantidad = new JLabel();
				getContentPane().add(cantidad);
				cantidad.setBounds(246, 214, 57, 24);
				cantidad.setVisible(false);
			}
			pack();
			this.setSize(576, 373);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getMeses() {
		if(meses == null) {
			meses = new ButtonGroup();
		}
		return meses;
	}

}
