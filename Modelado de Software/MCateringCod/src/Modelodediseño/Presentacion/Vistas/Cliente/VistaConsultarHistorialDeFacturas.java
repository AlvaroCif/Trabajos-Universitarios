/**
 * 
 */
package Modelodediseño.Presentacion.Vistas.Cliente;

import Modelodediseño.Negocio.Factura.TFactura;
import Modelodediseño.Presentacion.Controlador.ControladorAplicacion;
import Modelodediseño.Presentacion.Vistas.Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class VistaConsultarHistorialDeFacturas extends JPanel implements Vista {
	
	private JFrame frame;
	private JPanel panel;
	private JTable table;
	private String[] col = { "ID", "IDCliente","IDproductos", "Cantidades","Fecha", "Total","Activo" };
	private String[][] data = {};
	
	private JTextField txtId;
	private JDateChooser dateChooser;
	
	public VistaConsultarHistorialDeFacturas(){
		
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(0,2,20,20));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new java.awt.Font("Courier New", 0, 12));
		lblId.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new java.awt.Font("Courier New", 0, 12));
		txtId.setColumns(10);
		txtId.setEditable(true);
		panel.add(txtId);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(JLabel.CENTER);
		lblFecha.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(lblFecha);
		
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		panel.add(dateChooser);
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setSize(20, 20);
		btnBuscar.setHorizontalAlignment(JButton.CENTER);
		btnBuscar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(20, 20);
		btnCancelar.setHorizontalAlignment(JButton.CENTER);
		btnCancelar.setFont(new java.awt.Font("Courier New", 0, 12));
		panel.add(btnCancelar);
		
		listenerButtons(btnBuscar,btnCancelar);
		
		this.add(panel);

		this.setVisible(false);
		//this.setVisible(true);
	}
	
	private void listenerButtons(JButton btnBuscar, JButton btnCancelar) 
	{
		
		ActionListener action = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{  
				
				int id_evento = 0;
				if (e.getActionCommand() == "Buscar") 
				{
					
					TFactura factura = new TFactura();
					
					Integer id;
		 
					try{
						 id = (Integer.parseInt(txtId.getText()));
						 factura.setIdCliente(id);
					}catch (NumberFormatException e1){
						
						JOptionPane.showMessageDialog(null, "Formato de id incorrecto", "Consultar Historial De Facturas", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					Date date;
					
					if(dateChooser.getDate() != null)	{
						
						date = new Date(dateChooser.getDate().getTime());
						factura.setFecha(date);
						
					}
					else{
					
						JOptionPane.showMessageDialog(null, "Operacion fallida: Fecha vacia", "Consultar Hisorial De Factura", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					id_evento = 18;

					ControladorAplicacion.getInstancia().recogerEvento(id_evento,factura);
				}
			
				else {
				    frame.dispose();
				}
			}

			
		};
		btnBuscar.addActionListener(action);
		btnCancelar.addActionListener(action);
		
	}
	
	@Override
	public void mostrar() {
		
		frame = new JFrame("Historial de Facturas");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400,150);
		this.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void update(int evento, Object datos) {
		
		ArrayList<TFactura> listaFacturas = (ArrayList<TFactura>) datos;
		
		if(listaFacturas.size() > 0){
		
			JFrame frame = new JFrame();
			frame = new JFrame("Historial de Facturas del Cliente: "+listaFacturas.get(0).getIdCliente());
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    frame.setSize(800,350);
		    JPanel panel = new JPanel();
			frame.add(panel);
			this.setVisible(true);
			frame.setVisible(true);
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
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(5).setPreferredWidth(40);
			table.getColumnModel().getColumn(6).setPreferredWidth(40);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 0, 800, 300);
			table.setFont(new java.awt.Font("Courier New", 0, 12));
			
			panel.add(scrollPane);
			
		}else{
			JOptionPane.showMessageDialog(null, "No existen facturas del cliente", "Consultar Historial De Facturas", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
		
		
	}
	
}