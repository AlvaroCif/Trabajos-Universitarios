package Modelodediseño.Presentacion.Vistas.Departamento;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Modelodediseño.Negocio.Departamento.Departamento;
import Modelodediseño.Negocio.Empleado.Empleado;
import Modelodediseño.Negocio.Empleado.EmpleadoComercial;
import Modelodediseño.Negocio.Empleado.EmpleadoRepartidor;
import Modelodediseño.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;

public class VistaEmpleadosPorDepartamento extends JPanel implements Vista
{
	
	private JFrame frame;
	private JPanel panel;
	
	private JLabel etiquetaId;
	private JTextField textoId;
	
	private JButton btnBuscar;
	private JButton btnVolver;
	
	private String[] col = {"ID", "DNI", "Nombre", "Telefono", "Nº de ventas", "Km recorridos", "Sueldo", "Activo"};
	private String[][] data = {};
	private JTable table;
	
	public VistaEmpleadosPorDepartamento(){
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,2,20,20));
		
		this.etiquetaId = new JLabel ("ID");
		this.etiquetaId.setFont(new java.awt.Font("Courier New", 0, 12));
		this.etiquetaId.setHorizontalAlignment(JLabel.CENTER);
		panel.add(etiquetaId);
		
		this.textoId = new JTextField();
		this.textoId.setFont(new java.awt.Font("Courier New", 0, 12));
		this.textoId.setHorizontalAlignment(JLabel.CENTER);
		panel.add(textoId);
		
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
		
		listenerButtons (btnBuscar, btnVolver);
		
		this.add(panel);
		
		this.setVisible(false);
	}

	
	private ActionListener actListenerVistaEmpleadosPorDepartamento;

	private void listenerButtons (JButton btnBuscar, JButton btnVolver)
	{
		this.actListenerVistaEmpleadosPorDepartamento = new ActionListener ()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				int id_evento = 0;
				Object datos = null;
				if (arg0.getActionCommand() == "Volver") 
				{

					frame.dispose();
				}
				
				else 
				{
					datos = (Integer) Integer.parseInt(textoId.getText());
					
					id_evento = 47;
				    ControladorAplicacion.getInstancia().recogerEvento(id_evento, datos);
				}

			}
			
		};
		btnBuscar.addActionListener(actListenerVistaEmpleadosPorDepartamento);
		btnVolver.addActionListener(actListenerVistaEmpleadosPorDepartamento);
	}
	
	@Override
	public void mostrar() 
	{
		// TODO Auto-generated method stub
		frame = new JFrame ("Listado de empleados por departamento");
		this.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(600,200);
		frame.add(panel);
		frame.setVisible(true);
	
	}

	@Override
	public void update(int evento, Object datos) 
	{
		// TODO Auto-generated method stub
		Collection <Empleado> epd = (Collection <Empleado>) datos;
		if (epd != null)
		{
			if (!epd.isEmpty())	
			{
				data = new String[epd.size()] [col.length];
				int i = 0;
				for (Empleado emp: epd)
				{
					if (emp != null)
					{
						data[i][0] = Integer.toString(emp.getId());
						data[i][1] = emp.getDni();
						data[i][2] = emp.getNombre();
						data[i][3] = Integer.toString(emp.getTelefono());
						if (emp.getClass().equals(EmpleadoComercial.class))
						{
							data [i][4] = Integer.toString(((EmpleadoComercial) emp).getVentas());
							data [i][5] = "";
						}
						else
						{
							data [i][4] = "";
							data [i][5] = Integer.toString(((EmpleadoRepartidor) emp).getKm());
						}
						data [i][6] = Double.toString(emp.calculoNomina());
						data [i][7] = Boolean.toString(emp.getActivo());
					}
					i++;
				}
				
				this.etiquetaId.setVisible(false);
				this.textoId.setVisible(false);
				this.btnBuscar.setVisible(false);
				this.btnVolver.setVisible(false);
				
				table = new JTable(data,col);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(0, 0, 800, 300);
				panel.setLayout(new BorderLayout());
				panel.add(scrollPane, BorderLayout.CENTER);
				table.setFont(new java.awt.Font("Courier New", 0, 12));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Lista vacia", "Listado de empleados por departamento", JOptionPane.ERROR_MESSAGE);
				frame.dispose();
			}	
		}
		else  
		{
			JOptionPane.showMessageDialog(null, "Departamento inexistente", "Listado de empleados por departamento", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
	}

}
