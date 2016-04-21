package Modelodediseño.Presentacion.Vistas.Departamento;

import Modelodediseño.Negocio.Departamento.Departamento;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;

/**
 * 
 */

import Modelodediseño.Presentacion.Vistas.Vista;

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


@SuppressWarnings("serial")
public class VistaAltaDepartamento extends JPanel implements Vista {
	
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId;
	private JTextField txtNombre;
	private JCheckBox checkBoxActivo;
		
	private ActionListener actListenerAltaDepartamento;
	
	
	public VistaAltaDepartamento(){
		
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
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(JLabel.CENTER);
		lblNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel activo = new JLabel("Activo");
		activo.setHorizontalAlignment(JLabel.CENTER);
		activo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(activo);
		
		checkBoxActivo = new  JCheckBox();
		checkBoxActivo.setSelected(true);
		checkBoxActivo.setEnabled(false);
		panel.add(checkBoxActivo);

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
						
						String nombre = "";
						int id;
						
						if (!txtNombre.getText().matches("(.*)0(.*)") && !txtNombre.getText().matches("(.*)1(.*)") && !txtNombre.getText().matches("(.*)2(.*)") && !txtNombre.getText().matches("(.*)3(.*)") && !txtNombre.getText().matches("(.*)4(.*)") &&
							!txtNombre.getText().matches("(.*)5(.*)") && !txtNombre.getText().matches("(.*)6(.*)") && !txtNombre.getText().matches("(.*)7(.*)") && !txtNombre.getText().matches("(.*)8(.*)") && !txtNombre.getText().matches("(.*)9(.*)"))
							nombre = txtNombre.getText();
						else
						{
							datos_correctos = false;
							if(!txtNombre.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. Un nombre no puede contener numeros", "Alta Departamento", JOptionPane.ERROR_MESSAGE);
							else 
								JOptionPane.showMessageDialog (null, "Error. Campo Nombre no puede estar vacio", "Alta Departamento", JOptionPane.ERROR_MESSAGE);

						}
						
						if(nombre.length()==0 && datos_correctos){
							
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Campo Nombre no puede estar vacio", "Alta Departamento", JOptionPane.ERROR_MESSAGE);
							
						}
								
						if(datos_correctos){
							Departamento dep = new Departamento();
							dep.setNombre(txtNombre.getText());
							dep.setActivo(true);
							//cliente.setClubSocios(checkBox.isSelected());
							
							datos = (Object) dep;
							id_evento = 41;
		
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
		
		frame = new JFrame("Alta Departamento");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,270);
		frame.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		int exito = (Integer) datos;
		
		if(exito != -1){
			
			JOptionPane.showMessageDialog(null, "Añadido con exito, el id es: " + exito , "Alta Departamento", JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
			
		}else{
			
			JOptionPane.showMessageDialog(null, "Ese nombre de departamento ya se encuentra en el sistema.", "Alta Departamento", JOptionPane.ERROR_MESSAGE);
			
		}
	}

}