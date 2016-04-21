package Modelodediseño.Presentacion.Vistas.Empleado;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelodediseño.Negocio.Empleado.EmpleadoComercial;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;

@SuppressWarnings("serial")
public class VistaAltaEmpleadoComercial extends JPanel implements Vista{
	
	private JFrame frame;
	private JPanel panel;
		
	private JTextField txtId;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtSueldo;
	private JTextField txtTelefono;
	private JTextField txtVentas;
	private JCheckBox checkBoxActivo;
	
	public VistaAltaEmpleadoComercial(){
		
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
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new java.awt.Font("Courier New", 0, 12));
		lblDni.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(JLabel.CENTER);
		lblNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setHorizontalAlignment(JLabel.CENTER);
		lblSueldo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblSueldo);
		
		txtSueldo = new JTextField();
		txtSueldo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtSueldo);
		txtSueldo.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(JLabel.CENTER);
		lblTelefono.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setHorizontalAlignment(JLabel.CENTER);
		lblVentas.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblVentas);
		
		txtVentas = new JTextField();
		txtVentas.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtVentas);
		txtVentas.setColumns(10);
		
		JLabel lblActivo = new JLabel("Activo");
		lblActivo.setHorizontalAlignment(JLabel.CENTER);
		lblActivo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblActivo);
		
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
						String dni = "";
						double sueldo = 0;
						int telefono = 0;
						int ventas = 0;
						
						if(!esDni(txtDni.getText())){
							
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. DNI no es valido", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);

						}
						else dni = txtDni.getText();
						
						if (!txtNombre.getText().matches("(.*)0(.*)") && !txtNombre.getText().matches("(.*)1(.*)") && !txtNombre.getText().matches("(.*)2(.*)") && !txtNombre.getText().matches("(.*)3(.*)") && !txtNombre.getText().matches("(.*)4(.*)") &&
								!txtNombre.getText().matches("(.*)5(.*)") && !txtNombre.getText().matches("(.*)6(.*)") && !txtNombre.getText().matches("(.*)7(.*)") && !txtNombre.getText().matches("(.*)8(.*)") && !txtNombre.getText().matches("(.*)9(.*)"))
								nombre = txtNombre.getText();
						else
						{
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Un nombre no puede contener numeros", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);
						}
						if(nombre.length()==0 && datos_correctos){
								
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Campo Nombre no puede estar vacio", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);
								
						}
						
						try
						{
							telefono = (Integer.parseInt(txtTelefono.getText()));
							if (txtTelefono.getText().length() != 9){
								
								datos_correctos = false;
								JOptionPane.showMessageDialog (null, "Error. En el campo Telefono debe haber un numero de 9 digitos", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);
	
							}
							
						} catch (NumberFormatException e2)
						{
							datos_correctos = false;
							if (!txtTelefono.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo Telefono debe haber un numero", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo Telefono esta vacio", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);
						}
						
						try
						{
							sueldo = (Double.parseDouble(txtSueldo.getText()));
						} catch (NumberFormatException e2)
						{
							datos_correctos = false;
							if (!txtSueldo.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo Sueldo debe haber un numero", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo Sueldo esta vacio", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);
						}
						try
						{
							ventas = (Integer.parseInt(txtVentas.getText()));
						} catch (NumberFormatException e2)
						{
							datos_correctos = false;
							if (!txtVentas.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo Ventas debe haber un numero", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo Ventas esta vacio", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);
						}
						
						if(datos_correctos){
							
							EmpleadoComercial empleadoC = new EmpleadoComercial();
							empleadoC.setDni(dni);
							empleadoC.setNombre(nombre);
							empleadoC.setSueldo(sueldo);
							empleadoC.setTelefono(telefono);
							empleadoC.setVentas(ventas);
							empleadoC.setActivo(true);
							
							datos = (Object) empleadoC;
							id_evento = 51;
		
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
	
	public  boolean esDni(String dni){
		
			Pattern dniPattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKE])");
			Matcher m = dniPattern.matcher(dni);
			if(m.matches()){
				int numDni = Integer.parseInt(dni.substring(0, dni.length()-1));
				char ultimaLetra = calculaLetra(numDni);
				if(ultimaLetra == dni.charAt(dni.length()-1))
					return true;
				else return false;
			}
			else
				return false;
	}
	
	char calculaLetra(int dni){
		
		String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";
		int modulo= dni % 23;
		char letra = juegoCaracteres.charAt(modulo);
		return letra; 
    } 
	
	
	@Override
	public void mostrar() {
		frame = new JFrame("Alta Empleado Comercial");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,400);
		frame.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		int exito = (Integer) datos;
		
		if(exito != -1){
			
			JOptionPane.showMessageDialog(null, "Añadido con exito, el id es: " + exito , "Alta Empleado Comercial", JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			
			JOptionPane.showMessageDialog(null, "Ese empleado ya se encuentra dado de alta en el sistema", "Alta Empleado Comercial", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

}