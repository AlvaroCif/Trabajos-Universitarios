package Modelodediseño.Presentacion.Vistas.Evento;

import Modelodediseño.Negocio.Evento.Evento;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;

/**
 * 
 */

import Modelodediseño.Presentacion.Vistas.Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class VistaModificarEvento extends JPanel implements Vista {
	
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtTipoEvento;
	private JCheckBox checkBoxActivo;
		
	private ActionListener actListenerModificarEvento;
	private JDateChooser dateChooser;
	
	
	public VistaModificarEvento(){
		
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
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTipoEvento = new JLabel("Tipo Evento");
		lblTipoEvento.setHorizontalAlignment(JLabel.CENTER);
		lblTipoEvento.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblTipoEvento);
		
		txtTipoEvento = new JTextField();
		txtTipoEvento.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(txtTipoEvento);
		txtTipoEvento.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(JLabel.CENTER);
		lblFecha.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblFecha);
		
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		panel.add(dateChooser);
		
		JLabel activo = new JLabel("Activo");
		activo.setHorizontalAlignment(JLabel.CENTER);
		activo.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(activo);
		
		checkBoxActivo = new  JCheckBox();
		checkBoxActivo.setSelected(true);
		//checkBoxActivo.setEnabled(false);
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
						
						int id=0;
						String nombre = "";
						Date date = null;
						String tipoEvento = "";
						
						try
						{
							id = (Integer.parseInt(txtId.getText()));
						} catch (NumberFormatException e2)
						{
							datos_correctos = false;
							if (!txtId.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo ID debe haber un numero", "Modificar Evento", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo ID esta vacio", "Modificar Evento", JOptionPane.ERROR_MESSAGE);
						}
						
						if (!txtNombre.getText().matches("(.*)0(.*)") && !txtNombre.getText().matches("(.*)1(.*)") && !txtNombre.getText().matches("(.*)2(.*)") && !txtNombre.getText().matches("(.*)3(.*)") && !txtNombre.getText().matches("(.*)4(.*)") &&
							!txtNombre.getText().matches("(.*)5(.*)") && !txtNombre.getText().matches("(.*)6(.*)") && !txtNombre.getText().matches("(.*)7(.*)") && !txtNombre.getText().matches("(.*)8(.*)") && !txtNombre.getText().matches("(.*)9(.*)"))
							nombre = txtNombre.getText();
						else
						{
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Un nombre no puede contener numeros", "Modificar Evento", JOptionPane.ERROR_MESSAGE);
						}
						if(nombre.length()==0 && datos_correctos){
							
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Campo Nombre no puede estar vacio", "Modificar Evento", JOptionPane.ERROR_MESSAGE);
							
						}
						if(txtTipoEvento.getText().isEmpty()){
							
							datos_correctos = false;
							JOptionPane.showMessageDialog (null, "Error. Campo TipoEvento no puede estar vacio", "Modificar Evento", JOptionPane.ERROR_MESSAGE);
							
						}
						else tipoEvento = txtTipoEvento.getText();
						
						if(dateChooser.getDate() != null)	{
							
							date = new Date(dateChooser.getDate().getTime());
							
							
						}
						else{
							
							datos_correctos = false;
							JOptionPane.showMessageDialog(null, "Exito Negativo: Fecha vacia", "ModificarEvento", JOptionPane.ERROR_MESSAGE);
						}
						
						if(datos_correctos){
							
							Evento evento = new Evento();
							
							evento.setId(id);
							evento.setNombre(nombre);
							evento.setTipoEvento(tipoEvento);
							evento.setFecha(date);
							evento.setActivo(true);
									
							
							datos = (Object) evento;
							id_evento = 63;
		
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
		
		frame = new JFrame("Modificar Evento");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,270);
		frame.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		int exito = (Integer) datos;
		
		switch(exito)
		{
			case 0:
				JOptionPane.showMessageDialog(null, "Se ha modificado con exito", "ModificarEvento", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Ya existe ese nombre en otro evento", "ModificarEvento", JOptionPane.ERROR_MESSAGE);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "El evento no se encuentra activo", "ModificarEvento", JOptionPane.ERROR_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "No existe ese evento", "ModificarEvento", JOptionPane.ERROR_MESSAGE);
				break;
		}
	}

}