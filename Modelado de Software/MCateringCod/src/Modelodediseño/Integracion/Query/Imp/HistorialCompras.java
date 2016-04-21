/**
 * 
 */
package Modelodediseño.Integracion.Query.Imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import Modelodediseño.Integracion.FactoriaDAO.FactoriaDAO;
import Modelodediseño.Integracion.Factura.DAOFactura;
import Modelodediseño.Integracion.Query.Query;
import Modelodediseño.Integracion.Transacciones.Transaction;
import Modelodediseño.Integracion.Transacciones.TransactionManager;
import Modelodediseño.Negocio.Factura.TFactura;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class HistorialCompras implements Query {
	/** 
	 * (sin Javadoc)
	 * @see Query#execute(Object obj)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object execute(Object obj) {

		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		ArrayList<TFactura> facturas = new ArrayList<TFactura> ();

		Thread t = Thread.currentThread();
		TransactionManager tm = TransactionManager.getInstancia();
		//tm.newTransaction(t);
		Transaction transaccion = tm.getTransaction(t);
		transaccion.start();
		
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();
		TFactura tfactura = (TFactura) obj;
		int id = tfactura.getIdCliente();
		java.sql.Date date = tfactura.getFecha();

		
		
		try {
			PreparedStatement ps = conexion.prepareStatement("SELECT * FROM  `factura` WHERE idcliente =? && fecha >=  ? for update");
			//PreparedStatement ps = conexion.prepareStatement("SELECT * FROM `factura`");
			ps.setInt(1, id);
			
			ps.setDate(2, date);
			ResultSet rs = ps.executeQuery();
			DAOFactura dao_factura = FactoriaDAO.getInstancia().crearDAOFactura();
			while(rs.next()){
				TFactura factura = dao_factura.mostrar(rs.getInt(1));
				facturas.add(factura);
				System.out.println(factura.getCantidad().size());
			}
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return facturas;
		// end-user-code
	}
}