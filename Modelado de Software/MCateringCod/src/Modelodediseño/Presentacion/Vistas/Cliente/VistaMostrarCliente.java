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

import Modelodediseño.Negocio.Cliente.TCliente;
import Modelodediseño.Negocio.Cliente.TClienteEmpresa;
import Modelodediseño.Negocio.Cliente.TClienteParticular;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;



@SuppressWarnings("serial")
public class VistaMostrarCliente extends JPanel implements Vista {
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId;
	private JTextField txtNif;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JCheckBox cbClubSocios;
	private JCheckBox cbActivo;
	private JButton btnBuscar;
	//private JButton btnCancelar;
	private JTextField txtApellidos;
	private JLabel lblClubSocios;
	private JLabel lblApellidos;
	private JLabel lblActivo;
	private JButton btnVolver;

	public VistaMostrarCliente(){
		
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
		
		JLabel lblDni = new JLabel("NIF");
		lblDni.setFont(new java.awt.Font("Courier New", 0, 12));
		lblDni.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblDni);
		
		txtNif = new JTextField();
		txtNif.setFont(new java.awt.Font("Courier New", 0, 12));
		txtNif.setEditable(false);
		panel.add(txtNif);
		txtNif.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(JLabel.CENTER);
		lblNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		txtNombre.setEditable(false);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(JLabel.CENTER);
		lblTelefono.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new java.awt.Font("Courier New", 0, 12));
		txtTelefono.setEditable(false);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblActivo = new JLabel("Activo");
		lblActivo .setHorizontalAlignment(JLabel.CENTER);
		lblActivo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblActivo);
		
		cbActivo = new JCheckBox();
		cbActivo.setEnabled(false);
		panel.add(cbActivo);
		
		lblClubSocios = new JLabel("Club Socios");
		lblClubSocios.setHorizontalAlignment(JLabel.CENTER);
		lblClubSocios.setFont(new java.awt.Font("Courier New", 0, 12));
		lblClubSocios.setVisible(false);
		panel.add(lblClubSocios);
		
		
		cbClubSocios = new  JCheckBox();
		cbClubSocios.setEnabled(false);
		cbClubSocios.setVisible(false);
		//panel.add(txtClubSocios);
		//panel.add(radioButton1);
		panel.add(cbClubSocios);
		
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(JLabel.CENTER);
		lblApellidos.setFont(new java.awt.Font("Courier New", 0, 12));
		lblApellidos.setVisible(false);
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new java.awt.Font("Courier New", 0, 12));
		txtApellidos.setColumns(10);
		txtApellidos.setText("true");
		txtApellidos.setEditable(false);
		txtApellidos.setVisible(false);
		panel.add(txtApellidos);

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
					Integer id = Integer.parseInt(txtId.getText());
					
					id_evento = 16;
				    ControladorAplicacion.getInstancia().recogerEvento(id_evento, id);
				}
			}

			
		};
		btnBuscar.addActionListener(action);

		btnVolver.addActionListener(action);
		
	}


	@Override
	public void mostrar() {
		frame = new JFrame("Mostrar Cliente");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,370);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		TCliente cliente = (TCliente) datos;
		
		
		if ( !cliente.equals(null) ){
			
			this.txtId.setText(Integer.toString(cliente.getId()));
			this.txtId.setEditable(false);
			this.txtNombre.setText(cliente.getNombre());
			this.txtNif.setText(cliente.getNif());
			this.txtTelefono.setText(Integer.toString( cliente.getTelefono()));
			this.cbActivo.setSelected(cliente.getActivo());
			if(cliente instanceof TClienteEmpresa){
				
				TClienteEmpresa temp = (TClienteEmpresa) cliente;
				this.lblClubSocios.setVisible(true);
				this.cbClubSocios.setSelected(temp.getClubSocios());
				this.cbClubSocios.setVisible(true);
				
			}
			else{
				
				TClienteParticular temp = (TClienteParticular) cliente;
				this.lblApellidos.setVisible(true);
				this.txtApellidos.setText(temp.getApellidos());
				this.txtApellidos.setVisible(true);
			}

			this.btnBuscar.setVisible(false);
			
		}
		else{
			
				JOptionPane.showMessageDialog(null, "No existe el cliente", "Mostar Cliente", JOptionPane.ERROR_MESSAGE);
				
		}
		
	}
	
}

