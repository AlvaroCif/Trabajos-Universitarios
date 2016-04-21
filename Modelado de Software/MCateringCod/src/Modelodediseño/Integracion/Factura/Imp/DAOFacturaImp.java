/**
 * 
 */
package Modelodediseño.Integracion.Factura.Imp;
import Modelodediseño.Integracion.Factura.DAOFactura;
import Modelodediseño.Integracion.Transacciones.TransactionManager;
import Modelodediseño.Negocio.Factura.TFactura;
import Modelodediseño.Negocio.Producto.TProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.Date;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOFacturaImp implements DAOFactura {
	/** 
	 * (sin Javadoc)
	 * @see DAOFactura#crear(TFactura tfactura)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int crear(TFactura tfactura) {
		int clave_generada = -1;

		Thread t = Thread.currentThread();  
		
		//COMPROBAR QUE ESTE BIEN EL CASTING
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		PreparedStatement ps;
		PreparedStatement ps2;

		try 
		{
			ps = conexion.prepareStatement("insert into factura values(null,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			//ps.setInt(1, tProducto.getId());
			ps.setDate(1, tfactura.getFecha());
			ps.setDouble(2, tfactura.getTotal());
			ps.setBoolean(3, tfactura.getActivo());
			ps.setInt(4, tfactura.getIdCliente());

			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()){
				clave_generada = rs.getInt(1);
			}
			try {
				for(int i=0;i<tfactura.getIdproductos().size();i++){
					ps2 = conexion.prepareStatement("insert into productosporfactura values(?,?,?)");
					ps2.setInt(1, clave_generada);
					ps2.setInt(2,tfactura.getIdproductos().get(i));
					ps2.setInt(3,tfactura.getCantidad().get(i));
					ps2.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		// TABLA PRODUCTOS POR FACTURA
		
		
		
		//clave_generada = 1;
		//*******************************buscar codigo de id
		
		return clave_generada;

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOFactura#eliminar(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean eliminar(int id) {
		boolean verificar=false;
		Thread t = Thread.currentThread();
	
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		PreparedStatement ps;

		try 
		{
			ps = conexion.prepareStatement("update factura set activo=0 where id=?");
			ps.setInt(1, id);
			ps.execute();
			verificar = true;
			
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automaticamente
			e.printStackTrace();
		}	
		return verificar;

	}

	/** 
	 * (sin Javadoc)
	 * @see DAOFactura#mostrar(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TFactura mostrar(int id) {
		TFactura facturaT= new TFactura(); 
		Thread t = Thread.currentThread();
		ArrayList<Integer> AUXidproductos;
		ArrayList<Integer> AUXcantidades;
		int i=0;
		
		//COMPROBAR QUE ESTE BIEN EL CASTING
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		PreparedStatement ps;
		PreparedStatement ps2;

		try 
		{	//Tabla factura
			ps = conexion.prepareStatement("select id, fecha, total, activo, idcliente from factura where id=? for update");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			 if (rs.next()) {
				 facturaT.setId(rs.getInt("id"));
				 facturaT.setFecha(rs.getDate("fecha"));
				 facturaT.setTotal(rs.getDouble("total"));
				 facturaT.setActivo(rs.getBoolean("activo"));
				 facturaT.setIdCliente(rs.getInt("idcliente"));
			 }else
			 {
				 facturaT=null;
			 }
			 //tabla productos/factura
			 if(facturaT != null){
			 	ps2 = conexion.prepareStatement("select idproducto,cantidadporfactura from productosporfactura where idfactura=? for update");
				ps2.setInt(1, id);
				ResultSet rs2 = ps2.executeQuery();
				 AUXidproductos= new ArrayList<Integer>();
				 AUXcantidades = new ArrayList<Integer>();
				 while (rs2.next()) {
					 AUXidproductos.add(rs2.getInt("idproducto"));
					 AUXcantidades.add(rs2.getInt("cantidadporfactura"));
				 }
				 facturaT.setIdproductos(AUXidproductos);
				 facturaT.setCantidad(AUXcantidades);
			 }
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automaticamente
			e.printStackTrace();
			//productoT=null;  //creo que debemos igualarlo a null en caso de que algo salga mal
		}
		//clave_generada = 1;
		//*******************************buscar codigo de id
		
		return facturaT;

	}

	/** 
	 * (sin Javadoc)
	 * @see DAOFactura#listar()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection listar() {
		TFactura facturaT; 
		ArrayList<TFactura> facturas = new ArrayList<TFactura>();
		ArrayList<Integer> AUXidproductos= new ArrayList<Integer>();;
		ArrayList<Integer> AUXcantidades=new ArrayList<Integer>();
		int i=0;
		Thread t = Thread.currentThread();
		
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		PreparedStatement ps;
		PreparedStatement ps2;
		try{
    	ps = conexion.prepareStatement("select id, fecha, total, activo, idcliente from factura for update");
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
			AUXidproductos= new ArrayList<Integer>();;
			AUXcantidades=new ArrayList<Integer>();
	    	facturaT = new TFactura();
		    
		   	 facturaT.setId(rs.getInt("id"));
			 facturaT.setFecha(rs.getDate("fecha"));
			 facturaT.setTotal(rs.getDouble("total"));
			 facturaT.setActivo(rs.getBoolean("activo"));
			 facturaT.setIdCliente(rs.getInt("idcliente"));
		    
			 
			 //segunda tabla, para cada factura activa
			ps2 = conexion.prepareStatement("select idproducto,cantidadporfactura from productosporfactura where idfactura=? for update");
			ps2.setInt(1, rs.getInt("id"));
			ResultSet rs2 = ps2.executeQuery();
			 while (rs2.next()) {
				 AUXidproductos.add(rs2.getInt("idproducto"));
				 AUXcantidades.add(rs2.getInt("cantidadporfactura"));
			 }
			 facturaT.setIdproductos(AUXidproductos);
			 facturaT.setCantidad(AUXcantidades);
				 
		    facturas.add(facturaT);
	    }
		}catch(SQLException e){
			e.printStackTrace();
		}
	    
    	return facturas;
	}
	
}
	
