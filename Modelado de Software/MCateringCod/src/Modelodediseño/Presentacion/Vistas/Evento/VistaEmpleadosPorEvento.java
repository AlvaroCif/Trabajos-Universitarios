package Modelodedise�o.Presentacion.Vistas.Evento;

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

import Modelodedise�o.Negocio.Empleado.EmpleadoComercial;
import Modelodedise�o.Negocio.Empleado.EmpleadoRepartidor;
import Modelodedise�o.Negocio.Evento.EmpleadosPorEvento;
import Modelodedise�o.Negocio.Evento.Evento;
import Modelodedise�o.Negocio.FactoriaSA.FactoriaSA;
import Modelodedise�o.Presentacion.Controlador.ControladorAplicacion;
import Modelodedise�o.Presentacion.Vistas.Vista;

public class VistaEmpleadosPorEvento extends JPanel implements Vista
{
	
	private JFrame frame;
	private JPanel panel;
	
	private JLabel etiquetaId;
	private JTextField textoId;
	
	private JButton btnBuscar;
	private JButton btnVolver;
	
	private String[] col = {"ID_Evento", "Nombre_Evento", "ID_Empleado", "DNI_Empleado", "N� de horas"};
	private String[][] data = {};
	private JTable table;
	
	public VistaEmpleadosPorEvento ()
	{
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

	private void listenerButtons (JButton btnBuscar, JButton btnVolver)
	{
		this.actListenerVistaEmpleadosPorEvento = new ActionListener ()
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
					
					id_evento = 68;
				    ControladorAplicacion.getInstancia().recogerEvento(id_evento, datos);
				}

			}
			
		};
		btnBuscar.addActionListener(actListenerVistaEmpleadosPorEvento);
		btnVolver.addActionListener(actListenerVistaEmpleadosPorEvento);
	}

	
	private ActionListener actListenerVistaEmpleadosPorEvento; 

	@Override
	public void mostrar() 
	{
		// TODO Auto-generated method stub
		frame = new JFrame ("Listado de empleados por evento");
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
		Collection <EmpleadosPorEvento> cepv = (Collection<EmpleadosPorEvento>) datos;
		if (cepv != null)
		{
			if (!cepv.isEmpty())
			{
				data = new String [cepv.size()][col.length];
				int i = 0;
				for (EmpleadosPorEvento epv: cepv)
				{
					if (epv != null)
					{
						data[i][0] = Integer.toString(epv.getEvento().getId());
						data[i][1] = epv.getEvento().getNombre();
						data[i][2] = Integer.toString(epv.getEmpleado().getId());
						data[i][3] = epv.getEmpleado().getDni();
						data[i][4] = Integer.toString(epv.getHoras());
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
				JOptionPane.showMessageDialog(null, "Lista vacia", "Listado de empleados por evento", JOptionPane.ERROR_MESSAGE);
				frame.dispose();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Evento inexistente", "Listado de empleados por evento", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
	}

}
