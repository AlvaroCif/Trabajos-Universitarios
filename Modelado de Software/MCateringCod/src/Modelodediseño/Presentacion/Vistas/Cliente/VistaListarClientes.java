package Modelodediseño.Presentacion.Vistas.Cliente;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Modelodediseño.Negocio.Cliente.TCliente;
import Modelodediseño.Negocio.Cliente.TClienteEmpresa;
import Modelodediseño.Negocio.Cliente.TClienteParticular;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;



@SuppressWarnings("serial")
public class VistaListarClientes extends JPanel implements Vista {
	private JFrame frame;
	
	private String[] col = { "ID", "NIF", "Nombre","Telefono", "Activo","Apellidos","ClubSocios" };
	private String[][] data = {};
	private JTable table;

	private JPanel panel;
	
	public VistaListarClientes(){
		
		panel = new JPanel();
		
		this.setVisible(false);
	}

	
	@Override
	public void mostrar() {
		frame = new JFrame("Listar Clientes");
		this.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(600,200);
		frame.add(panel);
		frame.setVisible(true);
		
		int id_evento = 17;
		ControladorAplicacion.getInstancia().recogerEvento(id_evento, null);
	}

	@Override
	public void update(int evento, Object datos) {
		
		ArrayList<TCliente> listaClientes = (ArrayList<TCliente>) datos;
		
		if (listaClientes.size() > 0 ){
			data = new String[listaClientes.size() ][7];
			for (int i = 0;i<listaClientes.size();i++){
				if (listaClientes.get(i)!= null){
					data[i][0] = Integer.toString(listaClientes.get(i).getId());
					data[i][1] = listaClientes.get(i).getNif();
					data[i][2] = listaClientes.get(i).getNombre();
					data[i][3] = Integer.toString(listaClientes.get(i).getTelefono());
 					data[i][4] = Boolean.toString(listaClientes.get(i).getActivo());
 					if(listaClientes.get(i) instanceof TClienteEmpresa) {
 						
 						TClienteEmpresa emp = (TClienteEmpresa) listaClientes.get(i);
 						data[i][6] = Boolean.toString(emp.getClubSocios());
 					}
 					else{
 						
 						TClienteParticular par = (TClienteParticular) listaClientes.get(i);
 						data[i][5] = par.getApellidos();	
 					}
				}
			}
			table = new JTable(data,col);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(45);
			table.getColumnModel().getColumn(5).setPreferredWidth(120);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 0, 800, 300);
			panel.add(scrollPane);
			table.setFont(new java.awt.Font("Courier New", 0, 12));
		}
		
		else {
			JOptionPane.showMessageDialog(null, "No existen clientes", "Listar Clientes", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
		
	}
	
}
