package Modelodediseño.Presentacion.Vistas.Cliente;

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

import com.aeat.valida.Validador;

import Modelodediseño.Negocio.Cliente.TClienteEmpresa;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;



@SuppressWarnings("serial")
public class VistaModificarClienteEmpresa extends JPanel implements Vista {
	
	
	private JFrame frame;
	private JPanel panel;
	
	private JCheckBox checkBox;
	private JTextField txtId;
	private JTextField txtNif;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	
	public VistaModificarClienteEmpresa(){
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
		
		JLabel lblDni = new JLabel("NIF");
		lblDni.setFont(new java.awt.Font("Courier New", 0, 12));
		lblDni.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblDni);
		
		txtNif = new JTextField();
		txtNif.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtNif);
		txtNif.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(JLabel.CENTER);
		lblNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(JLabel.CENTER);
		lblTelefono.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblClubSocios = new JLabel("Club Socios");
		lblClubSocios.setHorizontalAlignment(JLabel.CENTER);
		lblClubSocios.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblClubSocios);
		
		checkBox = new  JCheckBox();
		//panel.add(txtClubSocios);
		//panel.add(radioButton1);
		panel.add(checkBox);

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
		


	
	private void listenerButtons(JButton aceptar, JButton cancelar) 
	{
		ActionListener action = new ActionListener()
		{
				public void actionPerformed(ActionEvent e) 
				{  
					
					int id_evento = 0;
					Object datos = null;
					if (e.getActionCommand() == "Aceptar") 
					{
						boolean datos_correctos = true;
						
						int id = -1;
						String nif = "";
						String nombre = "";
						int telefono = -1;
						Validador val = new Validador();
						int resul = val.checkNif(txtNif.getText());
						if (resul > 0)
							nif = txtNif.getText();
						else
						{
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. El formato del DNI no es correcto", "Modificar Cliente Empresa", JOptionPane.ERROR_MESSAGE);
						}
				
						if (!txtNombre.getText().matches("(.*)0(.*)") && !txtNombre.getText().matches("(.*)1(.*)") && !txtNombre.getText().matches("(.*)2(.*)") && !txtNombre.getText().matches("(.*)3(.*)") && !txtNombre.getText().matches("(.*)4(.*)") &&
							!txtNombre.getText().matches("(.*)5(.*)") && !txtNombre.getText().matches("(.*)6(.*)") && !txtNombre.getText().matches("(.*)7(.*)") && !txtNombre.getText().matches("(.*)8(.*)") && !txtNombre.getText().matches("(.*)9(.*)"))
							nombre = txtNombre.getText();
						else
						{
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Un nombre no puede contener numeros", "Modificar Cliente Empresa", JOptionPane.ERROR_MESSAGE);
						}
						try
						{
							id = (Integer.parseInt(txtId.getText()));
						} catch (NumberFormatException e1)
						{
							datos_correctos = false;
							if (!txtId.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo id debe haber un numero", "Modificar Cliente Empresa", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo id esta vacio", "Modificar Cliente Empresa", JOptionPane.ERROR_MESSAGE);
						}
						try
						{
							telefono = (Integer.parseInt(txtTelefono.getText()));
						} catch (NumberFormatException e2)
						{
							datos_correctos = false;
							if (!txtTelefono.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo telefono debe haber un numero", "Modificar Cliente Empresa", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo telefono esta vacio", "Modificar Cliente Empresa", JOptionPane.ERROR_MESSAGE);
						}
						if (telefono != -1 && txtTelefono.getText().length() != 9)
						{
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. El campo telefono debe tener 9 digitos", "Modificar Cliente Empresa", JOptionPane.ERROR_MESSAGE);
						}
						
						TClienteEmpresa cliente;
						if (datos_correctos)
						{
							cliente = new TClienteEmpresa();
							cliente.setId(Integer.parseInt(txtId.getText()));
							cliente.setNif(nif);
							cliente.setNombre(nombre);
							cliente.setActivo(true);
							cliente.setTelefono(telefono);
							cliente.setClubSocios(checkBox.isSelected());
							
							datos = (Object) cliente;
							id_evento = 15;
		
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
		frame = new JFrame("Modificar Cliente Empresa");
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
				JOptionPane.showMessageDialog(null, "Se ha modificado el cliente con exito", "Modificar Cliente Empresa", JOptionPane.INFORMATION_MESSAGE);
				
			}else{
				
				JOptionPane.showMessageDialog(null, "No se ha podido modificar", "Modificar Cliente Empresa", JOptionPane.ERROR_MESSAGE);
				
			}
		
	}
	
}
