package Modelodediseño.Presentacion.Vistas.Evento;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Modelodediseño.Negocio.Empleado.Empleado;
import Modelodediseño.Negocio.Empleado.EmpleadoComercial;
import Modelodediseño.Negocio.Evento.Evento;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;



@SuppressWarnings("serial")
public class VistaListarEventos extends JPanel implements Vista {
	private JFrame frame;
	
	private String[] col = { "ID","Nombre","Tipo Evento","Fecha","Nº Empleados", "Activo" };
	private String[][] data = {};
	private JTable table;

	private JPanel panel;
	
	public VistaListarEventos(){
		
		panel = new JPanel();
		
		this.setVisible(false);
	}

	
	@Override
	public void mostrar() {
		frame = new JFrame("Listar Eventos");
		this.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(800,200);
		frame.add(panel);
		frame.setVisible(true);
		
		int id_evento = 65;
		ControladorAplicacion.getInstancia().recogerEvento(id_evento, null);
	}

	@Override
	public void update(int evento, Object datos) {
		
		Collection<Evento> listaEventos = (Collection<Evento>) datos;
		
		if (listaEventos.size() > 0 && listaEventos != null){
			
			data = new String[listaEventos.size() ][6];
			int i=0;
			
			 for (Evento temp : listaEventos){
				 
				 if(temp != null){
					 
					 data[i][0] = Integer.toString(temp.getId());
					 data[i][1] = temp.getNombre();
					 data[i][2] = temp.getTipoEvento();
					 data[i][3] = (temp.getFecha().toString());
					 data[i][4] = Integer.toString(temp.getEventos().size());
					 data[i][5] = Boolean.toString(temp.getActivo());
					 	 
				 }
				 i++;
	 
			 }
			
			
			table = new JTable(data,col);
			table.getColumnModel().getColumn(0).setPreferredWidth(5);
			table.getColumnModel().getColumn(2).setPreferredWidth(50);
			table.getColumnModel().getColumn(5).setPreferredWidth(20);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 0, 800, 300);
			panel.add(scrollPane);
			table.setFont(new java.awt.Font("Courier New", 0, 12));
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Lista vacia", "Listar Eventos", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
		
	}
	
}
