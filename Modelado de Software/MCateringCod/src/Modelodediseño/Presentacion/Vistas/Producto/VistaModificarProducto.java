package Modelodediseño.Presentacion.Vistas.Producto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelodediseño.Negocio.Producto.TProducto;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;



@SuppressWarnings("serial")
public class VistaModificarProducto extends JPanel implements Vista {
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId,txtNombre,txtTipoProducto,txtPrecio,txtCantidad;
	
	public VistaModificarProducto() {
		
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
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTipo = new JLabel("TipoDeProducto");
		lblTipo.setHorizontalAlignment(JLabel.CENTER);
		lblTipo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblTipo);
		
		txtTipoProducto = new JTextField();
		txtTipoProducto.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtTipoProducto);
		txtTipoProducto.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(JLabel.CENTER);
		lblPrecio.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(JLabel.CENTER);
		lblCantidad.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setSize(250, 20);
		txtCantidad.setFont(new java.awt.Font("Courier New", 0, 12));
		txtCantidad.setColumns(10);
		panel.add(txtCantidad);

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

		this.setVisible(false);
		//this.setVisible(true);
	}

	private void listenerButtons(JButton btnAceptar, JButton btnCancelar) {
		
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{  
				
				int id_evento = 0;
				Object datos = null;
				if (e.getActionCommand() == "Aceptar") 
				{
					
					boolean datos_correctos = true;
					
					if(txtNombre.getText().equals("") || txtTipoProducto.getText().equals("")
					|| txtPrecio.getText().equals("") || txtCantidad.getText().equals(""))
					{
						datos_correctos = false;
						JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios", "Modificar Producto", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						if (txtNombre.getText().matches("(.*)0(.*)") || txtNombre.getText().matches("(.*)1(.*)") || txtNombre.getText().matches("(.*)2(.*)") || txtNombre.getText().matches("(.*)3(.*)") || txtNombre.getText().matches("(.*)4(.*)") ||
							txtNombre.getText().matches("(.*)5(.*)") || txtNombre.getText().matches("(.*)6(.*)") || txtNombre.getText().matches("(.*)7(.*)") || txtNombre.getText().matches("(.*)8(.*)") || txtNombre.getText().matches("(.*)9(.*)"))
						{
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Un nombre de producto no puede contener numeros", "Modificar Producto", JOptionPane.ERROR_MESSAGE);
						}
						
						if (txtTipoProducto.getText().matches("(.*)0(.*)") || txtTipoProducto.getText().matches("(.*)1(.*)") || txtTipoProducto.getText().matches("(.*)2(.*)") || txtTipoProducto.getText().matches("(.*)3(.*)") || txtTipoProducto.getText().matches("(.*)4(.*)") ||
							txtTipoProducto.getText().matches("(.*)5(.*)") || txtTipoProducto.getText().matches("(.*)6(.*)") || txtTipoProducto.getText().matches("(.*)7(.*)") || txtTipoProducto.getText().matches("(.*)8(.*)") || txtTipoProducto.getText().matches("(.*)9(.*)"))
						{
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Un nombre de producto no puede contener numeros", "Modificar Producto", JOptionPane.ERROR_MESSAGE);
						}		
						try
						{
							Integer.parseInt(txtId.getText());
						} catch (NumberFormatException e2)
						{
							JOptionPane.showMessageDialog(null, "Error en formato de Id", "Modificar Producto", JOptionPane.ERROR_MESSAGE);
						}
							
						try
						{
							Double.parseDouble(txtPrecio.getText());
							Integer.parseInt(txtCantidad.getText());
						}catch (NumberFormatException e1)
						{								
							datos_correctos = false;
							JOptionPane.showMessageDialog(null, "Error en formato de Precio o Cantidad", "Modificar Producto", JOptionPane.ERROR_MESSAGE);
						}
					
						TProducto producto;
						if (datos_correctos)
						{
							producto = new TProducto();
							producto.setId(Integer.parseInt(txtId.getText()));
							producto.setNombre(txtNombre.getText());
							producto.setTipoProducto(txtTipoProducto.getText());
							producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
							producto.setActivo(true);
							producto.setCantidad(Integer.parseInt(txtCantidad.getText()));
							
							id_evento = 33;
							datos = (Object) producto;
	
							ControladorAplicacion.getInstancia().recogerEvento(id_evento, datos);
						}
					}	
				}
				else 
				{
				    frame.dispose();
				}
			}

			
		};
		btnAceptar.addActionListener(action);
		btnCancelar.addActionListener(action);
		
	}
	

	@Override
	public void mostrar() {
		
		frame = new JFrame("Modificar Producto");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,270);
		frame.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		boolean exito = (Boolean) datos;
		
		if(exito){
			
			JOptionPane.showMessageDialog(null, "Se ha modificado el producto con exito", "Modificar Producto", JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			
			JOptionPane.showMessageDialog(null, "No se ha podido llevar a cabo la operacion", "Modificar Producto", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
}
