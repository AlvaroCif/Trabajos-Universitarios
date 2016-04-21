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
import Modelodediseño.Negocio.Departamento.Departamento;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;



@SuppressWarnings("serial")
public class VistaModificarDepartamento extends JPanel implements Vista {
	
	
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId;
	private JTextField txtNombre;
	
	public VistaModificarDepartamento(){
		
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
		lblNombre.setHorizontalAlignment(JLabel.CENTER);
		lblNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		txtNombre.setColumns(10);
		panel.add(txtNombre);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setSize(20, 20);
		btnModificar.setHorizontalAlignment(JButton.CENTER);
		btnModificar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnModificar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(20, 20);
		btnCancelar.setHorizontalAlignment(JButton.CENTER);
		btnCancelar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnCancelar);
		
		
		listenerButtons(btnModificar,btnCancelar);
		
		this.add(panel);

		this.setVisible(false);
		//this.setVisible(true);
	}
		


	
	private void listenerButtons(JButton aceptar, JButton cancelar) {
		ActionListener action = new ActionListener(){
				public void actionPerformed(ActionEvent e) {  
					
					int id_evento = 0;
					Object datos = null;
					if (e.getActionCommand() == "Modificar") {
						
						boolean datos_correctos = true;
						
						String nombre = "";
						int id = 0;
						
						try
						{
							id = (Integer.parseInt(txtId.getText()));
						} catch (NumberFormatException e2)
						{
							datos_correctos = false;
							if (!txtId.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo ID debe haber un numero", "Modificar Departamento", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo ID esta vacio", "Modificar Departamento", JOptionPane.ERROR_MESSAGE);
						}
						
						if (!txtNombre.getText().matches("(.*)0(.*)") && !txtNombre.getText().matches("(.*)1(.*)") && !txtNombre.getText().matches("(.*)2(.*)") && !txtNombre.getText().matches("(.*)3(.*)") && !txtNombre.getText().matches("(.*)4(.*)") &&
							!txtNombre.getText().matches("(.*)5(.*)") && !txtNombre.getText().matches("(.*)6(.*)") && !txtNombre.getText().matches("(.*)7(.*)") && !txtNombre.getText().matches("(.*)8(.*)") && !txtNombre.getText().matches("(.*)9(.*)"))
							nombre = txtNombre.getText();
						else
						{
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Un nombre no puede contener numeros", "Modificar Departamento", JOptionPane.ERROR_MESSAGE);
						}
						if(nombre.length()==0 && datos_correctos){
							
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Campo Nombre no puede estar vacio", "Modificar Departamento", JOptionPane.ERROR_MESSAGE);
							
						}
						
						if(datos_correctos){
							
							Departamento dep = new Departamento();
							
							dep.setId(id);
							dep.setNombre(nombre);
							dep.setActivo(true);
							
							datos = (Object) dep;
							id_evento = 43;
		
							ControladorAplicacion.getInstancia().recogerEvento(id_evento, datos);
						}
						
						
					}
					else {
					    //frame.setVisible(false);
					    frame.dispose();
					}
				}

				
		};
		aceptar.addActionListener(action);
		cancelar.addActionListener(action);
	}
	
	@Override
	public void mostrar() {
		frame = new JFrame("Modificar Departamento");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,140);
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
					JOptionPane.showMessageDialog(null, "Se ha modificado con exito", "Modificar Departamento", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					break;
				case 1:				
					JOptionPane.showMessageDialog(null, "No se ha podido modificar. Ya hay otro departamento con ese nombre", "Modificar Departameno", JOptionPane.ERROR_MESSAGE);
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "No se puede modificar un departamento dado de baja", "Modificar Departameno", JOptionPane.ERROR_MESSAGE);
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "Ese nombre no esta en nuestra BBDD", "Modificar Departameno", JOptionPane.ERROR_MESSAGE);
					break;
				
			}
		
	}
	
}
