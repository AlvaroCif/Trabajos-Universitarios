/**
 * 
 */
package Modelodediseño.Integracion.Transacciones.Imp;

import Modelodediseño.Integracion.Transacciones.TransactionManager;
import java.util.concurrent.ConcurrentHashMap;
import Modelodediseño.Integracion.Transacciones.Transaction;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionManagerImp extends TransactionManager {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ConcurrentHashMap hashConections;

	public TransactionManagerImp()
	{
		hashConections = new ConcurrentHashMap<Thread, TransactionMySQL>();
	}
	
	/** 
	 * (sin Javadoc)
	 * @see TransactionManager#getTransaction(Thread thread)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Transaction getTransaction(Thread thread) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return (Transaction) this.hashConections.get(thread);
		// end-user-code
	}

	public void newTransaction(Thread thread) {
		// TODO Apéndice de método generado automáticamente
		hashConections.put(thread,new TransactionMySQL());
	}

	public void deleteTransaction(Thread thread) {
		// TODO Apéndice de método generado automáticamente
		hashConections.remove(thread);
	}
}