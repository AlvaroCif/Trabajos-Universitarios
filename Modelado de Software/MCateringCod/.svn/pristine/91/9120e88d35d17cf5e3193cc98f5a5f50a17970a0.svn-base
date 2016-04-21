package Modelodediseño.Presentacion.Vistas.Departamento;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;

@SuppressWarnings("serial")
public class VistaBajaDepartamento extends JPanel implements Vista {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField txtId;
	


	public VistaBajaDepartamento(){
		
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
					
					int id;
					boolean datos_correctos = true;
					
					try
					{
						id = (Integer.parseInt(txtId.getText()));
					} catch (NumberFormatException e2)
					{
						datos_correctos = false;
						if (!txtId.getText().isEmpty())
							JOptionPane.showMessageDialog (null, "Error. En el campo ID debe haber un numero", "Alta Departamento", JOptionPane.ERROR_MESSAGE);
						else
							JOptionPane.showMessageDialog (null, "Error. El campo ID esta vacio", "Alta Departamento", JOptionPane.ERROR_MESSAGE);
					}
					
					if(datos_correctos){
						
						datos = (Object) Integer.parseInt(txtId.getText());
						id_evento = 42;
						
						ControladorAplicacion.getInstancia().recogerEvento(id_evento, datos);
						
					}
					
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
		
		frame = new JFrame("Baja Departamento");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,100);
		frame.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		int resultado = (Integer) datos;
		
		switch (resultado)
		{
			case 0:
				JOptionPane.showMessageDialog(null, "Departamento Eliminado Correctamente", "Baja Departamento", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				break;
				
			case 1:
				JOptionPane.showMessageDialog(null, "El departamento ya se encuentra dado de baja", "Baja Departamento", JOptionPane.ERROR_MESSAGE);
				break;
				
			case 2:
				JOptionPane.showMessageDialog(null, "Ese departamento no está en nuestro sistema", "Baja Departamento", JOptionPane.ERROR_MESSAGE);
				break;
		}
 		
	}

}
