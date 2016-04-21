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
public class VistaCalcularNomina extends JPanel implements Vista {
	
	
	private JFrame frame;
	private JPanel panel;
	
	private JTextField txtId;
	private JTextField txtNomina;
	
	public VistaCalcularNomina(){
		
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
		
		JLabel lblNomina = new JLabel("Nomina");
		lblNomina.setHorizontalAlignment(JLabel.CENTER);
		lblNomina.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblNomina);
		
		txtNomina = new JTextField();
		txtNomina.setFont(new java.awt.Font("Courier New", 0, 12));
		txtNomina.setEnabled(false);
		panel.add(txtNomina);
		txtNomina.setColumns(10);
		
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
						
						int id = 0;
						boolean datos_correctos = true;
						
						try
						{
							id = (Integer.parseInt(txtId.getText()));
						} catch (NumberFormatException e2)
						{
							datos_correctos = false;
							if (!txtId.getText().isEmpty())
								JOptionPane.showMessageDialog (null, "Error. En el campo ID debe haber un numero", "Calcular Nomina", JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog (null, "Error. El campo ID esta vacio", "Calcular Nomina", JOptionPane.ERROR_MESSAGE);
						}
						
						if (datos_correctos){
							
							datos = (Object) id;
							id_evento = 46;
		
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
		frame = new JFrame("Calcular Nomina");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,140);
		frame.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		double nomina = (Double) datos;
		
		if(nomina == -1){
			
			JOptionPane.showMessageDialog(null, "No existe ese departamento", "Calcular Nomina", JOptionPane.ERROR_MESSAGE);

		}
		else{
			
			txtNomina.setText(Double.toString(nomina));
			txtId.setEnabled(false);

		}
			
		
	}

}
