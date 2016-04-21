/**
 * 
 */
package Modelodediseño.Integracion.Producto.Imp;

import Modelodediseño.Integracion.FactoriaDAO.FactoriaDAO;
import Modelodediseño.Integracion.FactoriaDAO.Imp.FactoriaDAOImp;
import Modelodediseño.Integracion.Producto.DAOProducto;
import Modelodediseño.Integracion.Transacciones.Transaction;
import Modelodediseño.Integracion.Transacciones.TransactionManager;
import Modelodediseño.Negocio.Producto.TProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOProductoImp implements DAOProducto {
	/** 
	 * (sin Javadoc)
	 * @see DAOProducto#crear(TProducto tProducto)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int crear(TProducto tProducto) {
		int clave_generada = -1;

		Thread t = Thread.currentThread();/*  // creo que desde aqui
		TransactionManager tm = TransactionManager.getInstancia();
		//tm.newTransaction(t);
		Transaction transaccion = tm.getTransaction(t);
		//transaccion.start();

		FactoriaDAO factoria = FactoriaDAOImp.getInstancia();
		DAOProducto productoD = factoria.crearDAOProducto();
		transaccion.getResource();*/   // hasta aqui. No es necesario, ya que se hace en la linea de abajo.
		
		//COMPROBAR QUE ESTE BIEN EL CASTING
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		PreparedStatement ps;

		try 
		{
			ps = conexion.prepareStatement("insert into producto values(null,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			//ps.setInt(1, tProducto.getId());
			ps.setString(1, tProducto.getNombre());
			ps.setString(2, tProducto.getTipoProducto());
			ps.setDouble(3, tProducto.getPrecio());
			ps.setInt(4, tProducto.getCantidad());
			ps.setBoolean(5, tProducto.getActivo());

			
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next())
				clave_generada = rs.getInt(1);
			
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automaticamente
			e.printStackTrace();
		}
		//clave_generada = 1;
		//*******************************buscar codigo de id
		
		return clave_generada;

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOProducto#eliminar(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean eliminar(int id) {
		boolean verificar=false;
		Thread t = Thread.currentThread();/*
		TransactionManager tm = TransactionManager.getInstancia();
		//tm.newTransaction(t);
		Transaction transaccion = tm.getTransaction(t);
		//transaccion.start();

		FactoriaDAO factoria = FactoriaDAOImp.getInstancia();
		DAOProducto productoD = factoria.crearDAOProducto();
		transaccion.getResource();
		*/
		//COMPROBAR QUE ESTE BIEN EL CASTING
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		PreparedStatement ps;

		try 
		{
			ps = conexion.prepareStatement("update producto set activo=0 where id=?");
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
	 * @see DAOProducto#modificar(TProducto tProducto)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean modificar(TProducto tProducto) {
		boolean verificar=false;
		Thread t = Thread.currentThread();/*
		TransactionManager tm = TransactionManager.getInstancia();
		//tm.newTransaction(t);
		Transaction transaccion = tm.getTransaction(t);
		//transaccion.start();

		FactoriaDAO factoria = FactoriaDAOImp.getInstancia();
		DAOProducto productoD = factoria.crearDAOProducto();
		transaccion.getResource();
		*/
		//COMPROBAR QUE ESTE BIEN EL CASTING
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		PreparedStatement ps;

		try 
		{
			ps = conexion.prepareStatement("update producto set nombre=?, cantidad=?, tipoProducto=?, precio=?, activo=? where id=?");
			//ps.setInt(1, tProducto.getId());
			ps.setString(1, tProducto.getNombre());
			ps.setInt(2, tProducto.getCantidad());
			ps.setString(3, tProducto.getTipoProducto());
			ps.setDouble(4, tProducto.getPrecio());
			ps.setBoolean(5, tProducto.getActivo());
			ps.setInt(6, tProducto.getId());
			
			ps.execute();
			verificar = true;
			
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automaticamente
			e.printStackTrace();
		}
		//clave_generada = 1;
		//*******************************buscar codigo de id
		
		return verificar;

	}

	/** 
	 * (sin Javadoc)
	 * @see DAOProducto#mostrar(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TProducto mostrar(int id) {
		TProducto productoT= new TProducto(); 
		Thread t = Thread.currentThread();/*
		TransactionManager tm = TransactionManager.getInstancia();
		//tm.newTransaction(t);
		Transaction transaccion = tm.getTransaction(t);
		//transaccion.start();

		FactoriaDAO factoria = FactoriaDAOImp.getInstancia();
		DAOProducto productoD = factoria.crearDAOProducto();
		transaccion.getResource();
		*/
		//COMPROBAR QUE ESTE BIEN EL CASTING
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		PreparedStatement ps;

		try 
		{
			ps = conexion.prepareStatement("select id, nombre, cantidad, tipoProducto, precio, activo from producto where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//este if else seria necesario si no tuvieramos el try/catch. No se si debe usarse teniendolo
			 if (rs.next()) {
				productoT.setId(rs.getInt("id"));
				productoT.setNombre(rs.getString("nombre"));
				productoT.setCantidad(rs.getInt("cantidad"));
				productoT.setTipoProducto(rs.getString("tipoProducto"));
				productoT.setPrecio(rs.getDouble("precio"));
				productoT.setActivo(rs.getBoolean("activo"));
			 }else
			 {
				productoT=null;
			 }
		
			
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automaticamente
			e.printStackTrace();
			//productoT=null;  //creo que debemos igualarlo a null en caso de que algo salga mal
		}
		//clave_generada = 1;
		//*******************************buscar codigo de id
		
		return productoT;

	}

	/** 
	 * (sin Javadoc)
	 * @see DAOProducto#listar()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection listar() {
		TProducto productoT;
		ArrayList<TProducto> productos = new ArrayList<TProducto>();
		Thread t = Thread.currentThread();/*
		TransactionManager tm = TransactionManager.getInstancia();
		//tm.newTransaction(t);
		Transaction transaccion = tm.getTransaction(t);
		//transaccion.start();

		FactoriaDAO factoria = FactoriaDAOImp.getInstancia();
		DAOProducto productoD = factoria.crearDAOProducto();
		transaccion.getResource();
		*/
		//COMPROBAR QUE ESTE BIEN EL CASTING
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		PreparedStatement ps;
		try{
    	ps = conexion.prepareStatement("select id, nombre, cantidad, tipoProducto, precio, activo from producto for update");
	    ResultSet rs = ps.executeQuery();
	    
	    while (rs.next()) {
	    	productoT = new TProducto();
		    
		    productoT.setId(rs.getInt("id"));
			productoT.setNombre(rs.getString("nombre"));
			productoT.setCantidad(rs.getInt("cantidad"));
			productoT.setTipoProducto(rs.getString("tipoProducto"));
			productoT.setPrecio(rs.getDouble("precio"));
			productoT.setActivo(rs.getBoolean("activo"));
		    
		    productos.add(productoT);
	    }
		}catch(SQLException e){
			e.printStackTrace();
		}
	    
    	return productos;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOProducto#mostrarPorNombre(String nombre)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TProducto mostrarPorNombre(String nombre) {
		Thread t = Thread.currentThread();
		TProducto productoT= new TProducto(); 
		/*
		TransactionManager tm = TransactionManager.getInstancia();
		//tm.newTransaction(t);
		Transaction transaccion = tm.getTransaction(t);
		//transaccion.start();

		FactoriaDAO factoria = FactoriaDAOImp.getInstancia();
		DAOProducto productoD = factoria.crearDAOProducto();
		transaccion.getResource();
		*/
		//COMPROBAR QUE ESTE BIEN EL CASTING
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		PreparedStatement ps;
		try{
			ps = conexion.prepareStatement("select id, nombre, cantidad, tipoProducto, precio, activo from producto where nombre=?");
			ps.setString(1, nombre);	
			ResultSet rs = ps.executeQuery();
			//este if else seria necesario si no tuvieramos el try/catch. No se si debe usarse teniendolo
			 if (rs.next()) {
				productoT.setId(rs.getInt("id"));
				productoT.setNombre(rs.getString("nombre"));
				productoT.setCantidad(rs.getInt("cantidad"));
				productoT.setTipoProducto(rs.getString("tipoProducto"));
				productoT.setPrecio(rs.getDouble("precio"));
				productoT.setActivo(rs.getBoolean("activo"));
			 }else
			 {
				productoT=null;
			 }
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productoT;
	
	}
	
}
	