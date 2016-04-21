/**
 * 
 */
package Modelodediseño.Presentacion.Vistas.Factura;

import Modelodediseño.Negocio.Factura.TFactura;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;
import Modelodediseño.Presentacion.Vistas.Producto.VistaAltaProducto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;



import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VistaMostrarFactura extends JPanel implements Vista {
	
	private JTextField txtId;
	private JTextField txtIdcliente;
	private JTextField txtIdproducto;
	private JTextField txtCantidad;
	private JTextField txtFecha;
	private ArrayList<Integer> idsProd;
	private ArrayList<Integer> cantidades;
	private JTextField txtTotal;
	private JButton btnBuscar;
	private JButton btnVolver;
	private JFrame frame;
	private JPanel panel;
	private JCheckBox cbActivo;
	
	public VistaMostrarFactura(){
		
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(0,2,20,20));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new java.awt.Font("Courier New", 0, 12));
		lblId.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new java.awt.Font("Courier New", 0, 12));
		txtId.setColumns(10);
		//txtId.setEditable(false);
		panel.add(txtId);
		
		JLabel lblIdcliente = new JLabel("IDCliente");
		lblIdcliente.setFont(new java.awt.Font("Courier New", 0, 12));
		lblIdcliente.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblIdcliente);
		
		txtIdcliente = new JTextField();
		txtIdcliente.setFont(new java.awt.Font("Courier New", 0, 12));
		txtIdcliente.setColumns(10);
		txtIdcliente.setEditable(false);
		panel.add(txtIdcliente);
		
		JLabel lblIdproducto = new JLabel("IDProducto");
		lblIdproducto.setFont(new java.awt.Font("Courier New", 0, 12));
		lblIdproducto.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblIdproducto);
		
		txtIdproducto = new JTextField();
		txtIdproducto.setFont(new java.awt.Font("Courier New", 0, 12));
		txtIdproducto.setColumns(10);
		txtIdproducto.setEditable(false);
		panel.add(txtIdproducto);
		
		JLabel lblCantidad= new JLabel("Cantidad");
		lblCantidad.setFont(new java.awt.Font("Courier New", 0, 12));
		lblCantidad.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new java.awt.Font("Courier New", 0, 12));
		txtCantidad.setEditable(false);
		panel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(JLabel.CENTER);
		lblFecha.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setToolTipText("dd/MM/yyyy");
		txtFecha.setFont(new java.awt.Font("Courier New", 0, 12));
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		panel.add(txtFecha);
		
		
		JLabel lblTotal = new JLabel("Fecha");
		lblTotal.setHorizontalAlignment(JLabel.CENTER);
		lblTotal.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new java.awt.Font("Courier New", 0, 12));
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		panel.add(txtTotal);
		
		JLabel lblActivo = new JLabel("Activo");
		lblActivo .setHorizontalAlignment(JLabel.CENTER);
		lblActivo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblActivo);
		
		cbActivo = new JCheckBox();
		cbActivo.setEnabled(false);
		panel.add(cbActivo);
		

		btnBuscar = new JButton("Buscar");
		btnBuscar.setSize(20, 20);
		btnBuscar.setHorizontalAlignment(JButton.CENTER);
		btnBuscar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnBuscar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setSize(20, 20);
		btnVolver.setHorizontalAlignment(JButton.CENTER);
		btnVolver.setFont(new java.awt.Font("Courier New", 0, 12));
		//btnVolver.setVisible(false);
		panel.add(btnVolver);

	
		listenerButtons(btnBuscar,btnVolver);
		
		this.add(panel);

		this.setVisible(false);
	}

	@Override
	public void mostrar() {
		
		frame = new JFrame("Mostrar Factura");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,400);
		this.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		
	}

	private void listenerButtons(JButton btnAceptar,JButton btnVolver) {

		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent e) {  
				
				int id_evento = 0;
				Object datos = null;
				if (e.getActionCommand() == "Buscar") {
					
					Integer id;
					
					try{
						id = new Integer((Integer.parseInt(txtId.getText())));
					}catch (NumberFormatException e1){
						
						JOptionPane.showMessageDialog(null, "Formato de id incorrecto", "Mostrar Factura", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					id_evento = 23;
				

					ControladorAplicacion.getInstancia().recogerEvento(id_evento, id);
				}
				else if (e.getActionCommand() == "Volver") {
					
						frame.dispose();
				}
				else {
				    
						frame.dispose();
				}
			}

			
		};
		btnAceptar.addActionListener(action);;
		btnVolver.addActionListener(action);
		
	}

	@Override
	public void update(int evento, Object datos) {
		
		TFactura factura = (TFactura) datos;
		
		if( factura != null ){
			
			txtId.setEditable(false);
			txtIdcliente.setText(Integer.toString(factura.getIdCliente()));
			
			idsProd = factura.getIdproductos();
			String idsP="";
			for(int i=0; i<idsProd.size();i++){
				idsP = idsP + idsProd.get(i) + " ";
			}
			txtIdproducto.setText(idsP);
			
			cantidades = factura.getCantidad();
			String cant = "";
			for(int i=0; i<cantidades.size();i++){
				cant= cant + cantidades.get(i) + " ";
			}
			txtCantidad.setText(cant);
			
			txtTotal.setText(Double.toString(factura.getTotal()));
			
			txtFecha.setText(factura.getFecha().toString());
			this.cbActivo.setSelected(factura.getActivo());
			
			this.btnBuscar.setVisible(false);
			this.btnVolver.setVisible(true);
			
		}
		
		else{
			
			JOptionPane.showMessageDialog(null, "No existe la factura", "Mostar Factura", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}
	
	
}