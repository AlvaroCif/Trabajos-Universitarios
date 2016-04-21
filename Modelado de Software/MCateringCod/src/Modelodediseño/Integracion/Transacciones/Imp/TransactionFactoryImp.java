/**
 * 
 */
package Modelodediseño.Integracion.Transacciones.Imp;

import Modelodediseño.Integracion.Transacciones.TransactionFactory;
import Modelodediseño.Integracion.Transacciones.Transaction;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionFactoryImp extends TransactionFactory {
	/** 
	 * (sin Javadoc)
	 * @see TransactionFactory#nuevaTransaccionMySQL()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Transaction nuevaTransaccionMySQL() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new TransactionMySQL();
		// end-user-code
	}
}