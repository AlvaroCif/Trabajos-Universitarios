package Modelodediseño.Presentacion.Vistas.Producto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelodediseño.Negocio.Producto.TProducto;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaListarClientes;


@SuppressWarnings("serial")
public class VistaMostrarProducto extends JPanel implements Vista {
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId,txtNombre,txtTipoProducto,txtPrecio,txtCantidad;
	private JLabel lblActivo;
	private JCheckBox cbActivo;
	private JButton btnBuscar;
	private JButton btnVolver;
	public VistaMostrarProducto() {
		
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(0,2,20,20));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new java.awt.Font("Courier New", 0, 12));
		lblId.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new java.awt.Font("Courier New", 0, 12));
		txtId.setColumns(10);
		panel.add(txtId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		lblNombre.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		txtNombre.setEditable(false);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTipo = new JLabel("TipoDeProducto");
		lblTipo.setHorizontalAlignment(JLabel.CENTER);
		lblTipo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblTipo);
		
		txtTipoProducto = new JTextField();
		txtTipoProducto.setFont(new java.awt.Font("Courier New", 0, 12));
		txtTipoProducto.setEditable(false);
		panel.add(txtTipoProducto);
		txtTipoProducto.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(JLabel.CENTER);
		lblPrecio.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(JLabel.CENTER);
		lblCantidad.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setSize(250, 20);
		txtCantidad.setFont(new java.awt.Font("Courier New", 0, 12));
		txtCantidad.setColumns(10);
		panel.add(txtCantidad);

		lblActivo = new JLabel("Activo");
		lblActivo .setHorizontalAlignment(JLabel.CENTER);
		lblActivo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblActivo);
		
		cbActivo = new JCheckBox();
		cbActivo.setEnabled(false);
		panel.add(cbActivo);
		
		btnBuscar = new JButton("Aceptar");
		btnBuscar.setSize(20, 20);
		btnBuscar.setHorizontalAlignment(JButton.CENTER);
		btnBuscar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnBuscar);

		btnVolver = new JButton("Volver");
		btnVolver.setSize(20, 20);
		btnVolver.setHorizontalAlignment(JButton.CENTER);
		btnVolver.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnVolver);

		listenerButtons(btnBuscar,btnVolver);
		
		this.add(panel);

		this.setVisible(false);
		//this.setVisible(true);
	}

	private void listenerButtons(JButton btnAceptar, JButton btnCancelar) {
		
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent e) {  
				
				int id_evento = 0;
				if (e.getActionCommand() == "Aceptar") {
					
					Integer id;
					
					try{
						 id = (Integer.parseInt(txtId.getText()));
					}catch (NumberFormatException e1){
						
						JOptionPane.showMessageDialog(null, "Formato de id incorrecto", "Mostrar Producto", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					id_evento = 34;

					ControladorAplicacion.getInstancia().recogerEvento(id_evento, id);
				}
				else {
				    frame.dispose();
				}
			}

			
		};
		btnAceptar.addActionListener(action);
		btnCancelar.addActionListener(action);
		
	}

	@Override
	public void mostrar() {
		
		frame = new JFrame("Mostrar Producto");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,270);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	@Override
	public void update(int evento, Object datos) {
		
		TProducto producto = (TProducto) datos;
		
		if(producto != null){
			
			this.txtId.setText(Integer.toString(producto.getId()));
			this.txtId.setEditable(false);
			this.txtNombre.setText(producto.getNombre());
			this.txtTipoProducto.setText(producto.getTipoProducto());
			this.txtPrecio.setText(Double.toString(producto.getPrecio()));
			this.txtCantidad.setText(Integer.toString(producto.getCantidad()));
			this.cbActivo.setSelected(producto.getActivo());
			
			this.btnBuscar.setVisible(false);
			
			
		}
		else{
			
			JOptionPane.showMessageDialog(null, "No existe el producto", "Mostrar Producto", JOptionPane.ERROR_MESSAGE);
				
		}
		
	}
	
}
