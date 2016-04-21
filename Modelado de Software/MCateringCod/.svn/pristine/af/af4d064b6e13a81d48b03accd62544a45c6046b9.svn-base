/**
 * 
 */
package Modelodediseño.Presentacion.Vistas.Factura;

/**
 * 
 */


import Modelodediseño.Negocio.Factura.TFactura;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class VistaDevolucionDeProductosEnFactura extends JPanel implements Vista {
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId;

	public  VistaDevolucionDeProductosEnFactura() {
		
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
				
		listenerButtons(btnEliminar,btnCancelar);
		
		this.add(panel);

		this.setVisible(false);

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
						
						JOptionPane.showMessageDialog(null, "Formato de id incorrecto", "Devolucion De Productos En Factura", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					id_evento = 22;
					
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
		frame = new JFrame("Devolucion De Productos en Factura");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,100);
		this.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {

		boolean exito = (Boolean) datos;
		
		if(exito){
			
			JOptionPane.showMessageDialog(null, "Productos devueltos correctamente", "Devolucion De Productos En Factura", JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			
			JOptionPane.showMessageDialog(null, "No se ha podido devolver correctamente la factura", "Devolucion De Productos En Factura", JOptionPane.ERROR_MESSAGE);
			
		}
	}
}