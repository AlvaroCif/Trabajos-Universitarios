/**
 * 
 */
package Modelodediseño.Presentacion.Vistas.Factura;

import Modelodediseño.Negocio.Factura.TFactura;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


@SuppressWarnings("serial")
public class VistaListarFacturas extends JPanel implements Vista {
	
	private String[] col = { "ID", "IDCliente","IDproductos", "Cantidades","Fecha", "Total","Activo" };
	private String[][] data = {};
	private JTable table;
	private JFrame frame;
	private JPanel panel;
	
	public VistaListarFacturas(){
		
		panel = new JPanel();
		this.setVisible(false);
	}
	
	@Override
	public void mostrar() {
		
		frame = new JFrame("Listar Facturas");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(800,350);
	    frame.add(panel);
	    this.setVisible(true);
		frame.setVisible(true);
	
		int id_evento = 24;
		ControladorAplicacion.getInstancia().recogerEvento(id_evento, null);
	}

	@Override
	public void update(int evento, Object datos) {

		ArrayList<TFactura> listaFacturas = (ArrayList<TFactura>) datos;
		
		if (listaFacturas.size()>0){
			
			data = new String [listaFacturas.size()][7];
	
			for (int i = 0;i<listaFacturas.size();i++){
				if (listaFacturas.get(i)!= null){
					data[i][0] = Integer.toString(listaFacturas.get(i).getId());
					data[i][1] = Integer.toString(listaFacturas.get(i).getIdCliente());
					
					ArrayList<Integer> idsProd = listaFacturas.get(i).getIdproductos();
					String idsP="";
					for(int j=0; j<idsProd.size();j++){
						idsP = idsP + idsProd.get(j) + " ";
					}
					data[i][2] = idsP;
					
					ArrayList<Integer> cantidades = listaFacturas.get(i).getCantidad();
					String can="";
					for(int j=0; j<cantidades.size();j++){
						can = can + cantidades.get(j) + " ";
					}
					data[i][3] = can;
					
					data[i][4] = (listaFacturas.get(i).getFecha().toString());
 					data[i][5] = Double.toString(listaFacturas.get(i).getTotal());
 					data[i][6] = Boolean.toString(listaFacturas.get(i).getActivo());
 					
				}
				
			}
			table = new JTable(data,col);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(5).setPreferredWidth(50);
			table.getColumnModel().getColumn(6).setPreferredWidth(60);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 0, 800, 300);
			table.setFont(new java.awt.Font("Courier New", 0, 12));
			
			panel.add(scrollPane);
		}
		else{
			JOptionPane.showMessageDialog(null, "No existen facturas", "Listar Facturas", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
		
	}
}