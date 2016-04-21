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
public class VistaMostrarDepartamento extends JPanel implements Vista {
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtNumEmpleados;
	private JButton btnBuscar;
	private JButton btnVolver;
	private JLabel lblNumEmpleados;
	private JLabel lblId;
	private JLabel lblNombre;

	public VistaMostrarDepartamento(){
		
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(0,2,20,20));
		
		lblId = new JLabel("ID");
		lblId.setFont(new java.awt.Font("Courier New", 0, 12));
		lblId.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new java.awt.Font("Courier New", 0, 12));
		txtId.setColumns(10);
		txtId.setEditable(true);
		panel.add(txtId);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(JLabel.CENTER);
		lblNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		txtNombre.setEditable(false);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNumEmpleados = new JLabel("Num Empleados");
		lblNumEmpleados.setHorizontalAlignment(JLabel.CENTER);
		lblNumEmpleados.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNumEmpleados);
		
		txtNumEmpleados = new JTextField();
		txtNumEmpleados.setFont(new java.awt.Font("Courier New", 0, 12));
		txtNumEmpleados.setEditable(false);
		panel.add(txtNumEmpleados);
		txtNumEmpleados.setColumns(10);
		
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
				
				else {
					
					int id = 0;
					boolean datos_correctos = true;
					
					try
					{
						id = (Integer.parseInt(txtId.getText()));
					} catch (NumberFormatException e2)
					{
						datos_correctos = false;
						if (!txtId.getText().isEmpty())
							JOptionPane.showMessageDialog (null, "Error. En el campo ID debe haber un numero", "Mostrar Departamento", JOptionPane.ERROR_MESSAGE);
						else
							JOptionPane.showMessageDialog (null, "Error. El campo ID esta vacio", "Mostrar Departamento", JOptionPane.ERROR_MESSAGE);
					}
					
					if(datos_correctos){
						
						datos = (Integer) id;
						
						id_evento = 44;
					    ControladorAplicacion.getInstancia().recogerEvento(id_evento, datos);
						
					}
					
				}
			}

			
		};
		btnBuscar.addActionListener(action);

		btnVolver.addActionListener(action);
		
	}


	@Override
	public void mostrar() {
		frame = new JFrame("Mostrar Departamento");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,200);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		Departamento dep = (Departamento) datos;
		
		
		if ( dep != null ){
			
			this.txtId.setText(Integer.toString(dep.getId()));
			this.txtId.setEditable(false);
			this.txtNumEmpleados.setText(Integer.toString(dep.getEmpleados().size()));
			this.txtNombre.setText(dep.getNombre());
			this.btnBuscar.setVisible(false);
			
		}
		else{
			
				JOptionPane.showMessageDialog(null, "No existe el departamento", "Mostar Departamento", JOptionPane.ERROR_MESSAGE);
				
		}
		
	}

}

