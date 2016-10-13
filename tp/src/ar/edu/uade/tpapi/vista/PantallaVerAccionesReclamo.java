package ar.edu.uade.tpapi.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class PantallaVerAccionesReclamo extends javax.swing.JFrame {

	
	private JTextArea detalle;
	private JLabel lDetalle;
	private JLabel fechaAlta;
	private JLabel lFechaAlta;	
	private JScrollPane jScrollPane1;
	private JPanel panel;
	private JPanel[] acciones;
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
	private Vector<AccionView> accionesView;
	private long nroReclamo;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public PantallaVerAccionesReclamo(Vector<AccionView> accionesView,long nroReclamo) {
		super();
		this.accionesView = accionesView;
		this.nroReclamo = nroReclamo;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(640, 938);
			setLocationRelativeTo(null);
			this.setTitle("Acciones del reclamo:"+" "+Long.toString(nroReclamo));
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(640, 938));
			getContentPane().add(getJScrollPane1(), BorderLayout.CENTER);
			{
				int size = accionesView.size();
				GridLayout panelLayout = new GridLayout(size, 1);
				panelLayout.setVgap(5);
				panel = new JPanel();
				panel.setLayout(panelLayout);
				panel.setBorder(BorderFactory.createLineBorder(Color.black));
				acciones = new JPanel[size];
				
				for (int i = 0; i < size; i++) {
					acciones[i] = new JPanel();
					acciones[i].setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					acciones[i].setLayout(null);
					acciones[i].setPreferredSize(new java.awt.Dimension(597, 260));
					{
						lFechaAlta = new JLabel();
						acciones[i].add(lFechaAlta);
						lFechaAlta.setText("Fecha de alta:");
						lFechaAlta.setBounds(13, 34, 86, 14);
						lFechaAlta.setFont(new java.awt.Font("Tahoma",1,11));
					}
					{
						fechaAlta = new JLabel();
						acciones[i].add(fechaAlta);
						fechaAlta.setBounds(99, 34, 75, 14);
						fechaAlta.setText(formatoFecha.format(accionesView.get(i).getFechaAlta()));
					}
					{
						lDetalle = new JLabel();
						acciones[i].add(lDetalle);
						lDetalle.setText("Descripcion:");
						lDetalle.setBounds(13, 121, 71, 14);
						lDetalle.setFont(new java.awt.Font("Tahoma",1,11));
					}
					{
						detalle = new JTextArea();
						acciones[i].add(detalle);
						detalle.setBounds(12, 141, 584, 102);
						detalle.setEditable(false);
						detalle.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						detalle.setWrapStyleWord(true);
						detalle.setLineWrap(true);
						detalle.setText(accionesView.get(i).getDetalle());
					}
					panel.add(acciones[i]);
				}
			
				getJScrollPane1().setViewportView(panel);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(0, 25, 775, 269);
		}
		return jScrollPane1;
	}
}
