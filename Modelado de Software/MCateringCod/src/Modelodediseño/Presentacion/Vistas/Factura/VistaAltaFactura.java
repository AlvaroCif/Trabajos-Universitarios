/**
 * 
 */
package Modelodediseño.Presentacion.Vistas.Factura;

import Modelodediseño.Negocio.Factura.TFactura;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@SuppressWarnings("serial")
public class VistaAltaFactura extends JPanel implements Vista {
	
	private JTextField txtId;
	private JTextField txtIdcliente;
	private JTextField txtIdproducto;
	private JTextField txtCantidad;
	private JTextField txtFecha;
	private ArrayList<Integer> idsProd;
	private ArrayList<Integer> cantidades;
	private JFrame frame;
	private JPanel panel;
	private JDateChooser dateChooser;

	public VistaAltaFactura(){
		
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(0,2,20,20));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new java.awt.Font("Courier New", 0, 12));
		lblId.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new java.awt.Font("Courier New", 0, 12));
		txtId.setColumns(10);
		txtId.setEditable(false);
		panel.add(txtId);
		
		JLabel lblIdcliente = new JLabel("IDCliente");
		lblIdcliente.setFont(new java.awt.Font("Courier New", 0, 12));
		lblIdcliente.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblIdcliente);
		
		txtIdcliente = new JTextField();
		txtIdcliente.setFont(new java.awt.Font("Courier New", 0, 12));
		txtIdcliente.setColumns(10);
		//txtIdcliente.setEditable(false);
		panel.add(txtIdcliente);
		
		JLabel lblIdproducto = new JLabel("IDProducto");
		lblIdproducto.setFont(new java.awt.Font("Courier New", 0, 12));
		lblIdproducto.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblIdproducto);
		
		txtIdproducto = new JTextField();
		txtIdproducto.setFont(new java.awt.Font("Courier New", 0, 12));
		txtIdproducto.setColumns(10);
		//txtIdproducto.setEditable(false);
		panel.add(txtIdproducto);
		
		JLabel lblCantidad= new JLabel("Cantidad");
		lblCantidad.setFont(new java.awt.Font("Courier New", 0, 12));
		lblCantidad.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(JLabel.CENTER);
		lblFecha.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblFecha);
		
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		panel.add(dateChooser);
			

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setSize(20, 20);
		btnAceptar.setHorizontalAlignment(JButton.CENTER);
		btnAceptar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(20, 20);
		btnCancelar.setHorizontalAlignment(JButton.CENTER);
		btnCancelar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnCancelar);

		listenerButtons(btnAceptar,btnCancelar);
		
		this.add(panel);

		this.setVisible(true);
	}
	
	private void listenerButtons(JButton btnAceptar, JButton btnCancelar) {
		
		ActionListener action = new ActionListener(){

			public void actionPerformed(ActionEvent e) {  
				
				int id_evento = 0;
				Object datos = null;
				if (e.getActionCommand() == "Aceptar") {
					
					TFactura factura = new TFactura();
					
					int checkIds = prepararIDs();
					if(checkIds != 1) return;
					
					
					factura.setIdCliente(Integer.parseInt(txtIdcliente.getText()));
					factura.setIdproductos(idsProd);
					factura.setCantidad(cantidades);
					factura.setActivo(true);
					
					Date date;
					
					if(dateChooser.getDate() != null)	{
						
						date = new Date(dateChooser.getDate().getTime());
						factura.setFecha(date);
						
					}
					else{
					
						JOptionPane.showMessageDialog(null, "La fecha no puede estar vacia", "Alta Producto", JOptionPane.ERROR_MESSAGE);
						return;
					}
								
					id_evento = 21;
					datos = (Object) factura;

					ControladorAplicacion.getInstancia().recogerEvento(id_evento, datos);
				}
				else {
				    frame.dispose();
				}
			}

			
		};
		btnAceptar.addActionListener(action);
		btnCancelar.addActionListener(action);
	}

	private int prepararIDs() {
		
		if(txtIdcliente.getText().equals("") || txtIdproducto.getText().equals("") 
				||  txtCantidad.getText().equals("") ){
			
			JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios", "Alta Factura", JOptionPane.ERROR_MESSAGE);
			return 0;
			
		}
		
		try{
			//Integer.parseInt(txtId.getText());
			Integer.parseInt(txtIdcliente.getText());
		}catch (NumberFormatException e1){
			
			JOptionPane.showMessageDialog(null, "Formato ids incorrecto", "Alta Factura", JOptionPane.ERROR_MESSAGE);
			return 0;	
		}
		
		
		idsProd = new ArrayList<Integer>();
		cantidades = new ArrayList<Integer>();
		
		String[] ids = txtIdproducto.getText().split(" ");
		String[] cant = txtCantidad.getText().split(" ");
		
		
		if(ids.length != cant.length){
			
			JOptionPane.showMessageDialog(null, "El numero de ids de Producto y de Cantidades tiene que ser el mismo", "Alta Factura", JOptionPane.ERROR_MESSAGE);
			return 0;
			
		}
		else{
			
			for(int i=0;i<ids.length;i++){
				
				try{
					idsProd.add(Integer.parseInt(ids[i]));
					cantidades.add(Integer.parseInt(cant[i]));
				}catch (NumberFormatException e1){
					
					JOptionPane.showMessageDialog(null, "Formato ids incorrecto", "Alta Factura", JOptionPane.ERROR_MESSAGE);
					return 0;	
				}
				
			}
		}
		return 1;	
	}

	public void mostrar() {
		
		frame = new JFrame("Alta Factura");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,270);
		this.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	public void update(int evento, Object datos) {
		
		int exito = (Integer) datos;
		
		if(exito != -1){
			
			JOptionPane.showMessageDialog(null, "Añadido con exito, el id es: " + exito , "Alta Factura", JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			
			JOptionPane.showMessageDialog(null, "La operación no se pudo llevar a cabo", "Alta Factura", JOptionPane.ERROR_MESSAGE);
			
		}
	}
}