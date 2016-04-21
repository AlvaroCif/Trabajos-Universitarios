package Modelodediseño.Presentacion.Vistas.Evento;

import Modelodediseño.Negocio.Empleado.Empleado;
import Modelodediseño.Negocio.Empleado.EmpleadoComercial;
import Modelodediseño.Negocio.Evento.Evento;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;

/**
 * 
 */

import Modelodediseño.Presentacion.Vistas.Vista;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class VistaMostrarEvento extends JPanel implements Vista {
	
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtTipoEvento;
	private JCheckBox checkBoxActivo;
		
	private ActionListener actListenerMostrarEvento;
	private JDateChooser dateChooser;
	private JButton btnBuscar;
	private JTextField txtNumEmpleados;
	
	
	public VistaMostrarEvento(){
		
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(0,2,20,20));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new java.awt.Font("Courier New", 0, 12));
		lblId.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new java.awt.Font("Courier New", 0, 12));
		txtId.setColumns(10);
		//txtId.setEditable(false);
		panel.add(txtId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(JLabel.CENTER);
		lblNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new java.awt.Font("Courier New", 0, 12));
		txtNombre.setEditable(false);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTipoEvento = new JLabel("Tipo Evento");
		lblTipoEvento.setHorizontalAlignment(JLabel.CENTER);
		lblTipoEvento.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblTipoEvento);
		
		txtTipoEvento = new JTextField();
		txtTipoEvento.setFont(new java.awt.Font("Courier New", 0, 12));
		txtTipoEvento.setEditable(false);
		panel.add(txtTipoEvento);
		txtTipoEvento.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(JLabel.CENTER);
		lblFecha.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblFecha);
		
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setEnabled(false);
		panel.add(dateChooser);
		
		JLabel lblNumEmpleados = new JLabel("Num Empleados");
		lblNumEmpleados.setHorizontalAlignment(JLabel.CENTER);
		lblNumEmpleados.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNumEmpleados);
		
		txtNumEmpleados = new JTextField();
		txtNumEmpleados.setFont(new java.awt.Font("Courier New", 0, 12));
		txtNumEmpleados.setEditable(false);
		panel.add(txtNumEmpleados);
		txtNumEmpleados.setColumns(10);
		
		JLabel activo = new JLabel("Activo");
		activo.setHorizontalAlignment(JLabel.CENTER);
		activo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(activo);
		
		checkBoxActivo = new  JCheckBox();
		checkBoxActivo.setSelected(true);
		checkBoxActivo.setEnabled(false);
		panel.add(checkBoxActivo);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setSize(20, 20);
		btnBuscar.setHorizontalAlignment(JButton.CENTER);
		btnBuscar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnBuscar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(20, 20);
		btnCancelar.setHorizontalAlignment(JButton.CENTER);
		btnCancelar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnCancelar);
		
		
		listenerButtons(btnBuscar,btnCancelar);
		
		this.add(panel);

		this.setVisible(false);
		//this.setVisible(true);
		
		
	}

	private void listenerButtons(JButton aceptar, JButton cancelar) {
		ActionListener action = new ActionListener(){
				public void actionPerformed(ActionEvent e) {  
					
					int id_evento = 0;
					Object datos = null;
					if (e.getActionCommand() == "Buscar") {
						
						boolean datos_correctos = true;
						
						int id=0;
						
						try
						{
							id = (Integer.parseInt(txtId.getText()));
						} catch (NumberFormatException e2)
						{
							datos_correctos = false;
							if (!txtId.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo ID debe haber un numero", "Mostrar Evento", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo ID esta vacio", "Mostrar Evento", JOptionPane.ERROR_MESSAGE);
						}
						
						if(datos_correctos){
							
							datos = (Object) id;
							id_evento = 64;
		
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
		
		frame = new JFrame("Mostrar Evento");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,270);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		Evento ev = (Evento) datos;
		
		
		if ( ev != null ){
			
			this.txtId.setText(Integer.toString(ev.getId()));
			this.txtId.setEditable(false);
			this.txtNombre.setText(ev.getNombre());
			this.dateChooser.setDate(ev.getFecha());
			this.txtTipoEvento.setText(ev.getTipoEvento());
			this.checkBoxActivo.setSelected(ev.getActivo());
			this.txtNumEmpleados.setText(Integer.toString(ev.getEventos().size()));
			

			this.btnBuscar.setVisible(false);
			
		}
		else{
			
				JOptionPane.showMessageDialog(null, "No existe el evento", "Mostar Evento", JOptionPane.ERROR_MESSAGE);
				
		}
	}

}