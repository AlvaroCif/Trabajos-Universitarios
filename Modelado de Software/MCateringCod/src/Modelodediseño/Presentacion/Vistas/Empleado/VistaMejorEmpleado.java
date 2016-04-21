package Modelodediseño.Presentacion.Vistas.Empleado;

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
import Modelodediseño.Negocio.Empleado.Empleado;
import Modelodediseño.Negocio.Empleado.EmpleadoComercial;
import Modelodediseño.Negocio.Empleado.EmpleadoRepartidor;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;

@SuppressWarnings("serial")
public class VistaMejorEmpleado extends JPanel implements Vista{
	
	private JFrame frame;
	private JPanel panel;
		
	private JTextField txtId;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtSueldo;
	private JTextField txtTelefono;
	private JTextField txtDepartamento;
	private JTextField txtVentas;
	private JTextField txtKm;
	private JCheckBox checkBoxActivo;
	private JButton btnBuscar;
	private JButton btnVolver;
	private JLabel lblVentas;
	private JLabel lblKm;
	
	public VistaMejorEmpleado(){
		
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
		txtDni.setEditable(false);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(JLabel.CENTER);
		lblNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		txtNombre.setEditable(false);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setHorizontalAlignment(JLabel.CENTER);
		lblSueldo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblSueldo);
		
		txtSueldo = new JTextField();
		txtSueldo.setFont(new java.awt.Font("Courier New", 0, 12));
		txtSueldo.setEditable(false);
		panel.add(txtSueldo);
		txtSueldo.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(JLabel.CENTER);
		lblTelefono.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new java.awt.Font("Courier New", 0, 12));
		txtTelefono.setEditable(false);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setHorizontalAlignment(JLabel.CENTER);
		lblDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblDepartamento);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		txtDepartamento.setEditable(false);
		panel.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		lblVentas = new JLabel("Ventas");
		lblVentas.setHorizontalAlignment(JLabel.CENTER);
		lblVentas.setFont(new java.awt.Font("Courier New", 0, 12));
		lblVentas.setVisible(false);
		panel.add(lblVentas);
		
		txtVentas = new JTextField();
		txtVentas.setFont(new java.awt.Font("Courier New", 0, 12));
		txtVentas.setEditable(false);
		txtVentas.setVisible(false);
		panel.add(txtVentas);
		txtVentas.setColumns(10);
		
		lblKm = new JLabel("Kilometros");
		lblKm.setHorizontalAlignment(JLabel.CENTER);
		lblKm.setFont(new java.awt.Font("Courier New", 0, 12));
		lblKm.setVisible(false);
		panel.add(lblKm);
		
		txtKm = new JTextField();
		txtKm.setFont(new java.awt.Font("Courier New", 0, 12));
		txtKm.setEditable(false);
		txtKm.setVisible(false);
		panel.add(txtKm);
		txtKm.setColumns(10);
		
		JLabel lblActivo = new JLabel("Activo");
		lblActivo.setHorizontalAlignment(JLabel.CENTER);
		lblActivo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblActivo);
		
		checkBoxActivo = new  JCheckBox();
		checkBoxActivo.setEnabled(false);
		panel.add(checkBoxActivo);

		btnBuscar = new JButton("Buscar");
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

	
private void listenerButtons(JButton btnBuscar, JButton btnVolver) {
		
		ActionListener action = new ActionListener(){
			public void actionPerformed(ActionEvent e) {  
				
				int id_evento = 0;
				Object datos = null;
				if (e.getActionCommand() == "Volver") {

					frame.dispose();
				}
				
				else{
					
					
						id_evento = 500;
					    ControladorAplicacion.getInstancia().recogerEvento(id_evento, datos);
					}
					
					
				
			}

			
		};
		btnBuscar.addActionListener(action);

		btnVolver.addActionListener(action);
		
	}
		
	@Override
	public void mostrar() {
		frame = new JFrame("Mejor Empleado");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,400);
		frame.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		Empleado empleado = (Empleado) datos;
		
		
		if ( empleado != null ){
			
			this.txtId.setText(Integer.toString(empleado.getId()));
			this.txtNombre.setText(empleado.getNombre());
			this.txtDni.setText(empleado.getDni());
			this.txtTelefono.setText(Integer.toString( empleado.getTelefono()));
			if (empleado.getDepartamento() != null)
				this.txtDepartamento.setText(Integer.toString( empleado.getDepartamento().getId()));
			this.txtSueldo.setText(Double.toString( empleado.getSueldo()));
			this.checkBoxActivo.setSelected(empleado.getActivo());
			
			if(empleado instanceof EmpleadoComercial){
				
				EmpleadoComercial temp = (EmpleadoComercial) empleado;
				this.lblVentas.setVisible(true);
				this.txtVentas.setText(Integer.toString(temp.getVentas()));
				this.txtVentas.setVisible(true);
				
			}
			else{
				
				EmpleadoRepartidor temp = (EmpleadoRepartidor) empleado;
				this.lblKm.setVisible(true);
				this.txtKm.setText(Integer.toString(temp.getKm()));
				this.txtKm.setVisible(true);
			}

			this.btnBuscar.setVisible(false);
			
		}
		else{
			
				JOptionPane.showMessageDialog(null, "No hay empleados asignados a eventos", "Mostar Empleado", JOptionPane.ERROR_MESSAGE);
				
		}
		
	}

}
