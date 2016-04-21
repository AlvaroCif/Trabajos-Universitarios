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
import Modelodediseño.Presentacion.Vistas.Cliente.VistaBajaCliente;



@SuppressWarnings("serial")
public class VistaBajaProducto extends JPanel implements Vista {
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId;
	
	
	public VistaBajaProducto(){
		
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(0,2,20,20));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new java.awt.Font("Courier New", 0, 12));
		lblId.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new java.awt.Font("Courier New", 0, 12));
		txtId.setColumns(10);
		txtId.setEditable(true);
		panel.add(txtId);
		
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setSize(20, 20);
		btnEliminar.setHorizontalAlignment(JButton.CENTER);
		btnEliminar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnEliminar);


		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(20, 20);
		btnCancelar.setHorizontalAlignment(JButton.CENTER);
		btnCancelar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnCancelar);
		
		//this.rellenaCampos(cliente);
		
		listenerButtons(btnEliminar,btnCancelar);
		
		this.add(panel);

		this.setVisible(false);
		//this.setVisible(true);
	}

	private void listenerButtons(JButton btnEliminar, JButton btnCancelar) {
		
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent e) {  
				
				int id_evento = 0;
				Object datos = null;
				if (e.getActionCommand() == "Eliminar") {
					
					Integer id;
					
					try{
						 id = (Integer.parseInt(txtId.getText()));
					}catch (NumberFormatException e1){
						
						JOptionPane.showMessageDialog(null, "Formato de id incorrecto", "Baja Producto", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
	
					id_evento = 32;
					
					ControladorAplicacion.getInstancia().recogerEvento(id_evento, id);
				}
			
				else {
				   frame.dispose();
				}
			}

			
		};
		btnEliminar.addActionListener(action);
		btnCancelar.addActionListener(action);
		
	}

	

	@Override
	public void mostrar() {
		frame = new JFrame("Baja Producto");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,100);
		frame.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		
	}


	@Override
	public void update(int evento, Object datos) {
		
		boolean exito = (Boolean) datos;
		
		if(exito){
			
			JOptionPane.showMessageDialog(null, "Se ha dado de baja correctamente", "Baja Producto", JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			
			JOptionPane.showMessageDialog(null, "No se ha podido dar de baja", "Baja Producto", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
}