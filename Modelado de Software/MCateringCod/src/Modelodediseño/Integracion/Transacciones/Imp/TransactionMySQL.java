/**
 * 
 */
package Modelodediseño.Integracion.Transacciones.Imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Modelodediseño.Integracion.Transacciones.Transaction;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionMySQL implements Transaction {
	
	private Connection conexion;
	
	/** 
	 * (sin Javadoc)
	 * @see Transaction#start()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void start() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		try 
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			//this.conexion = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql498868", "sql498868", "pW4m2Kv2TQ");
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdCatering", "root", "1234");
			//this.conexion = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/mcatering_db", "mcatering_db", "123456");
			this.conexion.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			this.conexion = null;
			e.printStackTrace();
		}
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#commit()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void commit() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		try 
		{
			this.conexion.commit();
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#rollback()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void rollback() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		try 
		{
			this.conexion.rollback();
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#getResource()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object getResource() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.conexion;
		// end-user-code
	}
}