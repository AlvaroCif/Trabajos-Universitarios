/**
 * 
 */
package Modelodedise�o.Presentacion.Dispatcher.Imp;

import Modelodedise�o.Presentacion.Dispatcher.Dispatcher;
import Modelodedise�o.Presentacion.Vistas.Factoria.FactoryVista;
import Modelodedise�o.Presentacion.Controlador.comandos.RespuestaComando;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DispatcherImp extends Dispatcher {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Object respuestaComando;

	/** 
	 * (sin Javadoc)
	 * @see Dispatcher#processRequest(RespuestaComando rComando)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void processRequest(int id_evento,RespuestaComando rComando) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		FactoryVista.getInstancia().RedirigirVista(rComando.getDatos(), rComando.getId());
		// end-user-code
	}
}