

package Modelodediseño.Presentacion.Vistas.Producto;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Modelodediseño.Negocio.Producto.TProducto;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;




@SuppressWarnings("serial")
public class VistaListarProductos extends JPanel implements Vista {
	private JFrame frame;
	
	private String[] col = { "ID", "Nombre", "TipoProducto","Precio", "Activo","Cantidad"};
	private String[][] data = {};
	private JTable table;
	private JScrollPane scrollPane;

	private JPanel panel;
	
	public  VistaListarProductos() {
		
		panel = new JPanel();
		this.setVisible(false);
		
	}

	@Override
	public void mostrar() {
		
		frame = new JFrame("Listar Productos");
		this.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(600,200);
		this.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		
		int id_evento = 35;
		ControladorAplicacion.getInstancia().recogerEvento(id_evento, null);
		
		
	}
	
	@Override
	public void update(int evento, Object datos) {
		
		ArrayList<TProducto> listaProductos = ((ArrayList<TProducto>) datos);
		
		if (listaProductos.size()>0){
			data = new String[listaProductos.size() ][6];
			for (int i = 0;i<listaProductos.size();i++){
				if (listaProductos.get(i)!= null){
					data[i][0] = Integer.toString(listaProductos.get(i).getId());
					data[i][1] = listaProductos.get(i).getNombre();
					data[i][2] = listaProductos.get(i).getTipoProducto();
					data[i][3] = Double.toString(listaProductos.get(i).getPrecio());
 					data[i][4] = Boolean.toString(listaProductos.get(i).getActivo());
 					data[i][5] = Integer.toString(listaProductos.get(i).getCantidad());
				}
			}
			table = new JTable(data,col);
			table.getColumnModel().getColumn(0).setPreferredWidth(5);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(30);
			table.getColumnModel().getColumn(4).setPreferredWidth(30);
			table.getColumnModel().getColumn(5).setPreferredWidth(40);
			table.setFont(new java.awt.Font("Courier New", 0, 12));
			scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 0, 800, 300);
			panel.add(scrollPane);
		}
		else {
			JOptionPane.showMessageDialog(null, "No existen Productos", "Listar Productos", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
		
		
		
	}
	
}
