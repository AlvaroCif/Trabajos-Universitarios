/**
 * 
 */
package Modelodedise�o.Presentacion.Dispatcher;

import Modelodedise�o.Presentacion.Controlador.comandos.RespuestaComando;
import Modelodedise�o.Presentacion.Dispatcher.Imp.DispatcherImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class Dispatcher {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static Dispatcher instancia;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static Dispatcher getInstance() 
	{
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		if (instancia == null)
			instancia = new DispatcherImp();
		return instancia;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param rComando
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void processRequest(int id, RespuestaComando rComando);
}