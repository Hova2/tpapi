package ar.edu.uade.tpapi.vista;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import ar.edu.uade.tpapi.controlador.Controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class PantallaResponsableZona extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	private JLabel nroReclamo;
	private JLabel lNombreCliente;
	private JTextArea descripcion;
	private JMenuItem listarReclamosZona;
	private JMenu listarReclamos;
	private JLabel lDescripcion;
	private JLabel estado;
	private JLabel lEstado;
	private JLabel dniCliente;
	private JLabel lDniCLiente;
	private JLabel nombreCliente;
	private JLabel fechaAlta;
	private JLabel lFechaAlta;
	private JLabel lNroReclamo;
	
	private JScrollPane jScrollPane1;
	private JMenuItem cambiarEstado;
	private JMenu lista;
	private JMenuItem listaDeReclamos;
	private JMenu estados;
	private JMenuItem verAcciones;
	private JMenuItem altaAccion;
	private JMenu acciones;
	private JMenuBar jMenuBar1;
	private JPanel panel;
	private JPanel[] reclamos;
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
	private Vector<ReclamoZonaView> reclamosZonaView;

	public PantallaResponsableZona() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(640, 938);
			setLocationRelativeTo(null);
			this.setTitle("Responsable zona");
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(640, 938));
			getContentPane().add(getJScrollPane1(), BorderLayout.CENTER);
			{
				reclamosZonaView = Controlador.getInstance().listarReclamosZona();
				int size = reclamosZonaView.size();
				
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				jMenuBar1.add(getJMenu1());
				jMenuBar1.add(getEstados());
				jMenuBar1.add(getListarReclamos());
				GridLayout panelLayout = new GridLayout(size, 1);
				panelLayout.setVgap(5);
				panel = new JPanel();
				panel.setLayout(panelLayout);
				panel.setBorder(BorderFactory.createLineBorder(Color.black));
				reclamos = new JPanel[size];
				
				for (int i = 0; i < size; i++) {
					reclamos[i] = new JPanel();
					reclamos[i].setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					reclamos[i].setLayout(null);
					reclamos[i].setPreferredSize(new java.awt.Dimension(597, 260));
					{
						lNroReclamo = new JLabel();
						reclamos[i].add(lNroReclamo);
						lNroReclamo.setText("NroReclamo:");
						lNroReclamo.setBounds(99, 33, 75, 17);
						lNroReclamo.setFont(new java.awt.Font("Tahoma",1,11));
					}
					{
						nroReclamo = new JLabel();
						reclamos[i].add(nroReclamo);
						nroReclamo.setBounds(180, 33, 61, 16);
						nroReclamo.setText(Long.toString(reclamosZonaView.get(i).getNroReclamo()));
					}
					{
						lFechaAlta = new JLabel();
						reclamos[i].add(lFechaAlta);
						lFechaAlta.setText("Fecha de alta:");
						lFechaAlta.setBounds(369, 36, 86, 14);
						lFechaAlta.setFont(new java.awt.Font("Tahoma",1,11));
					}
					{
						fechaAlta = new JLabel();
						reclamos[i].add(fechaAlta);
						fechaAlta.setBounds(455, 36, 75, 14);
						fechaAlta.setText(formatoFecha.format(reclamosZonaView.get(i).getFechaAlta()));
					}
					{
						lNombreCliente = new JLabel();
						reclamos[i].add(lNombreCliente);
						lNombreCliente.setText("Cliente:");
						lNombreCliente.setBounds(99, 79, 48, 14);
						lNombreCliente.setFont(new java.awt.Font("Tahoma",1,11));
					}
					{
						nombreCliente = new JLabel();
						reclamos[i].add(nombreCliente);
						nombreCliente.setBounds(153, 79, 72, 14);
						nombreCliente.setText(reclamosZonaView.get(i).getCliente().getNombre());
					}
					{
						lDniCLiente = new JLabel();
						reclamos[i].add(lDniCLiente);
						lDniCLiente.setText("Dni del cliente:");
						lDniCLiente.setBounds(369, 79, 88, 14);
						lDniCLiente.setFont(new java.awt.Font("Tahoma",1,11));
					}
					{
						dniCliente = new JLabel();
						reclamos[i].add(dniCliente);
						dniCliente.setBounds(463, 79, 47, 14);
						dniCliente.setText(Long.toString(reclamosZonaView.get(i).getCliente().getDniCliente()));
					}
					{
						lEstado = new JLabel();
						reclamos[i].add(lEstado);
						lEstado.setText("Estado del reclamo:");
						lEstado.setBounds(282, 121, 112, 14);
						lEstado.setFont(new java.awt.Font("Tahoma",1,11));
					}
					{
						estado = new JLabel();
						reclamos[i].add(estado);
						estado.setBounds(400, 121, 195, 14);
						if(reclamosZonaView.get(i).getEstado() == 1){
							estado.setText("Ingresado");
						}else if(reclamosZonaView.get(i).getEstado() == 2){
							estado.setText("En tratamiento");
						}else if(reclamosZonaView.get(i).getEstado() == 3){
							estado.setText("Cerrado");
						}else{
							estado.setText("Solucionado");
						}
					}
					{
						lDescripcion = new JLabel();
						reclamos[i].add(lDescripcion);
						lDescripcion.setText("Descripcion:");
						lDescripcion.setBounds(13, 121, 71, 14);
						lDescripcion.setFont(new java.awt.Font("Tahoma",1,11));
					}
					{
						descripcion = new JTextArea();
						reclamos[i].add(descripcion);
						descripcion.setBounds(12, 141, 584, 102);
						descripcion.setEditable(false);
						descripcion.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						descripcion.setWrapStyleWord(true);
						descripcion.setLineWrap(true);
						descripcion.setText(reclamosZonaView.get(i).getDescripcion());
					}
					panel.add(reclamos[i]);
				}
			
				getJScrollPane1().setViewportView(panel);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
	private JMenu getJMenu1() {
		if(acciones == null) {
			acciones = new JMenu();
			acciones.setText("Acciones");
			acciones.add(getAltaAccion());
			acciones.add(getVerAcciones());
		}
		return acciones;
	}
	
	private JMenuItem getAltaAccion() {
		if(altaAccion == null) {
			altaAccion = new JMenuItem();
			altaAccion.setText("Agregar accion");
			altaAccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PantallaAltaAccion.getInstance().setVisible(true);
				}
			});
		}
		return altaAccion;
	}
	
	private JMenuItem getVerAcciones() {
		if(verAcciones == null) {
			verAcciones = new JMenuItem();
			verAcciones.setText("Buscar acciones");
			verAcciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PantallaBuscarAccionReclamo pBAR = new PantallaBuscarAccionReclamo(reclamosZonaView);
					pBAR.setVisible(true);
				}
			});
		}
		return verAcciones;
	}
	
	private JMenu getEstados() {
		if(estados == null) {
			estados = new JMenu();
			estados.setText("Estados");
			estados.add(getCambiarEstado());
		}
		return estados;
	}
	
	private JMenuItem getCambiarEstado() {
		if(cambiarEstado == null) {
			cambiarEstado = new JMenuItem();
			cambiarEstado.setText("Cambiar estado");
			cambiarEstado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PantallaCambioEstado.getInstance().setVisible(true);
				}
			});
		}
		return cambiarEstado;
	}
	
	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(0, 25, 775, 269);
		}
		return jScrollPane1;
	}
	
	private JMenu getListarReclamos() {
		if(listarReclamos == null) {
			listarReclamos = new JMenu();
			listarReclamos.setText("Listar Reclamos");
			listarReclamos.add(getListarReclamosZona());
		}
		return listarReclamos;
	}
	
	private JMenuItem getListarReclamosZona() {
		if(listarReclamosZona == null) {
			listarReclamosZona = new JMenuItem();
			listarReclamosZona.setText("Listar Reclamos de Zona");
			listarReclamosZona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					ListaReclamosResponsableZona.getInstance().setVisible(true);
				}
			});
		}
		return listarReclamosZona;
	}

}
