package Modelodediseño.Presentacion.Vistas.Empleado;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Modelodediseño.Negocio.Departamento.Departamento;
import Modelodediseño.Negocio.Empleado.Empleado;
import Modelodediseño.Negocio.Empleado.EmpleadoComercial;
import Modelodediseño.Negocio.Empleado.EmpleadoRepartidor;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;



@SuppressWarnings("serial")
public class VistaListarEmpleados extends JPanel implements Vista {
	private JFrame frame;
	
	private String[] col = { "ID", "DNI", "Nombre","Sueldo","Telefono", "Activo","Departamento","Ventas","Km" };
	private String[][] data = {};
	private JTable table;

	private JPanel panel;
	
	public VistaListarEmpleados(){
		
		panel = new JPanel();
		
		this.setVisible(false);
	}

	
	@Override
	public void mostrar() {
		frame = new JFrame("Listar Empleados");
		this.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(500,200);
		frame.add(panel);
		frame.setVisible(true);
		
		int id_evento = 57;
		ControladorAplicacion.getInstancia().recogerEvento(id_evento, null);
	}

	@Override
	public void update(int evento, Object datos) {
		
		Collection<Empleado> listEmpleados = (Collection<Empleado>) datos;
		
		if (listEmpleados.size() > 0 && !listEmpleados.equals(null)){
			
			data = new String[listEmpleados.size() ][9];
			int i=0;
			
			for (Empleado emp : listEmpleados){
				
				if (emp != null){
					
					data[i][0] = Integer.toString(emp.getId());
					data[i][1] = emp.getDni();
					data[i][2] = emp.getNombre();
					data[i][3] = Double.toString(emp.getSueldo());
					data[i][4] = Integer.toString(emp.getTelefono());
					data[i][5] = Boolean.toString(emp.getActivo());
					if (emp.getDepartamento() != null)
						data[i][6] = Integer.toString(emp.getDepartamento().getId());
					
						
 					if(emp instanceof EmpleadoComercial) {
 						
 						data[i][7] = Integer.toString(((EmpleadoComercial) emp).getVentas());
 					}
 					else{
 						
 						data[i][8] = Integer.toString(((EmpleadoRepartidor) emp).getKm());	
 					}
				}
				i++;
			}
			table = new JTable(data,col);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(3).setPreferredWidth(50);
			table.getColumnModel().getColumn(5).setPreferredWidth(45);
			table.getColumnModel().getColumn(6).setPreferredWidth(90);
			table.getColumnModel().getColumn(7).setPreferredWidth(45);
			table.getColumnModel().getColumn(8).setPreferredWidth(25);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 0, 800, 300);
			panel.add(scrollPane);
			table.setFont(new java.awt.Font("Courier New", 0, 12));
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Lista vacia", "Listar Empleados", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
		
	}
	
}
