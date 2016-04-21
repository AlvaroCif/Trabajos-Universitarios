package Modelodediseño.Presentacion.Vistas.Empleado;

import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;

/**
 * 
 */

import Modelodediseño.Presentacion.Vistas.Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




@SuppressWarnings("serial")
public class VistaAsignarDepartamento extends JPanel implements Vista {
	
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtIdEmpleado;
	private JTextField txtIdDepartamento;
	
	private ActionListener actListenerAsignarEmpleado;
	
	
	public VistaAsignarDepartamento(){
		
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(0,2,20,20));
		
		JLabel lblIdEmpleado = new JLabel("ID Empleado");
		lblIdEmpleado.setFont(new java.awt.Font("Courier New", 0, 12));
		lblIdEmpleado.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblIdEmpleado);
		
		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setFont(new java.awt.Font("Courier New", 0, 12));
		txtIdEmpleado.setColumns(10);
		//txtId.setEditable(false);
		panel.add(txtIdEmpleado);
		
		JLabel lblIdDepartamento = new JLabel("ID Departamento");
		lblIdDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		lblIdDepartamento.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblIdDepartamento);
		
		txtIdDepartamento = new JTextField();
		txtIdDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		txtIdDepartamento.setColumns(10);
		//txtId.setEditable(false);
		panel.add(txtIdDepartamento);
	
		
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

	private void listenerButtons(JButton aceptar, JButton cancelar) {
		ActionListener action = new ActionListener(){
				public void actionPerformed(ActionEvent e) {  
					
					int id_evento = 0;
					Object datos = null;
					if (e.getActionCommand() == "Aceptar") {
						
						boolean datos_correctos = true;
						
						int idEmpleado=0;
						int idDepartamento=0;
						
						
						try
						{
							idEmpleado = (Integer.parseInt(txtIdEmpleado.getText()));
						} catch (NumberFormatException e2)
						{
							datos_correctos = false;
							if (!txtIdEmpleado.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo ID Empleado debe haber un numero", "Asignar Departamento", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo ID Empleado esta vacio", "Asignar Departamento", JOptionPane.ERROR_MESSAGE);
						}
						try
						{
							idDepartamento = (Integer.parseInt(txtIdDepartamento.getText()));
						} catch (NumberFormatException e2)
						{
							datos_correctos = false;
							if (!txtIdDepartamento.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo ID Departamento debe haber un numero", "Asignar Departamento", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo ID Departamento esta vacio", "Asignar Departamento", JOptionPane.ERROR_MESSAGE);
						}
						
						if (datos_correctos){
							
							Collection<Integer> coll = new ArrayList<Integer>();
							
							coll.add(idEmpleado);
							coll.add(idDepartamento);
							
							//cliente.setClubSocios(checkBox.isSelected());
							
							datos = (Object) coll;
							id_evento = 58;
		
							ControladorAplicacion.getInstancia().recogerEvento(id_evento, datos);
							
						}
						
					}
					else {
					    
					    frame.dispose();
					}
				}

				
		};
		aceptar.addActionListener(action);
		cancelar.addActionListener(action);
	}
	
	
	
	@Override
	public void mostrar() {
		
		frame = new JFrame("Asignar Departamento");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,140);
		frame.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		int resultado = (Integer) datos;
		
		switch(resultado)
		{
			case 0:
				JOptionPane.showMessageDialog(null, "Se ha asignado con exito", "Asignar departamento", JOptionPane.INFORMATION_MESSAGE);
				break;
			
			case 1:			
				JOptionPane.showMessageDialog(null, "Ese departamento y ese empleado no se encuentran en nuestra BBDD", "Asignar departamento", JOptionPane.ERROR_MESSAGE);
				break;
				
			case 2:
				JOptionPane.showMessageDialog(null, "El empleado o el departamento no se encuentran activo", "Asignar departamento", JOptionPane.ERROR_MESSAGE);
				break;
		}
	
		

	}
	
}