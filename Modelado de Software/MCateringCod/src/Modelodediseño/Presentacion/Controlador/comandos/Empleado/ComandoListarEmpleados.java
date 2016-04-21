/**
 * 
 */
package Modelodedise�o.Presentacion.Controlador.comandos.Empleado;

import java.util.Collection;

import Modelodedise�o.Negocio.Empleado.Empleado;
import Modelodedise�o.Negocio.Empleado.SAEmpleado.SAEmpleado;
import Modelodedise�o.Negocio.FactoriaSA.FactoriaSA;
import Modelodedise�o.Presentacion.Controlador.comandos.Comando;
import Modelodedise�o.Presentacion.Controlador.comandos.RespuestaComando;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoListarEmpleados implements Comando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Object datos;
	
	static final int idVistas = 57;

	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public RespuestaComando execute() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		SAEmpleado sa = FactoriaSA.getInstancia().crearSAEmpleado();
		Collection <Empleado> lista = sa.listar();
		RespuestaComando rComando = new RespuestaComando ();
		rComando.setDatos(lista);
		rComando.setId(idVistas);
		
		return rComando;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Comando#setdata(Object datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setdata(Object datos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		this.datos = datos;
		// end-user-code
	}
}