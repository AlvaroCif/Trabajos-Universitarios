package Modelodediseño.Presentacion.Vistas.Departamento;


import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import Modelodediseño.Negocio.Departamento.Departamento;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;



@SuppressWarnings("serial")
public class VistaListarDepartamentos extends JPanel implements Vista {
	private JFrame frame;
	
	private String[] col = { "ID", "Nombre", "Activo","Num Empleados" };
	private String[][] data = {};
	private JTable table;

	private JPanel panel;
	
	public VistaListarDepartamentos(){
		
		panel = new JPanel();
		
		this.setVisible(false);
	}

	
	@Override
	public void mostrar() {
		frame = new JFrame("Listar Departamentos");
		this.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(600,200);
		frame.add(panel);
		frame.setVisible(true);
		
		int id_evento = 45;
		ControladorAplicacion.getInstancia().recogerEvento(id_evento, null);
	}

	@Override
	public void update(int evento, Object datos) {
		
		Collection<Departamento> listaDep = (Collection <Departamento>) datos;
		
		if (listaDep.size() > 0 && listaDep != null ){
			
			data = new String[listaDep.size() ][4];
			int i = 0;
			
			for(Departamento dep: listaDep){
				
				if(dep != null){
					
					data[i][0] = Integer.toString(dep.getId());
					data[i][1] = dep.getNombre();
 					data[i][2] = Boolean.toString(dep.getActivo());
 					data[i][3] = Integer.toString(dep.getEmpleados().size());
						
				}
				i++;
			}
			
			
			table = new JTable(data,col);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 0, 800, 300);
			panel.add(scrollPane);
			table.setFont(new java.awt.Font("Courier New", 0, 12));
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Lista vacia", "Listar Departamentos", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
		
	}
	
}
