/**
 * 
 */
package Modelodediseño.Presentacion.Controlador.comandos.Evento;

import Modelodediseño.Negocio.Evento.Evento;
import Modelodediseño.Negocio.Evento.SAEvento.SAEvento;
import Modelodediseño.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseño.Presentacion.Controlador.comandos.Comando;
import Modelodediseño.Presentacion.Controlador.comandos.RespuestaComando;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class ComandoMostrarEvento implements Comando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Object datos;

	static final int idVistas = 64;
	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public RespuestaComando execute() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		SAEvento sa = FactoriaSA.getInstancia().crearSAEvento();
		int id = (Integer) datos;
		Evento even = sa.mostrar(id);
		RespuestaComando rComando = new RespuestaComando();
		rComando.setDatos(even);
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
		// TODO Apéndice de método generado automáticamente
		this.datos = datos;
		// end-user-code
	}
}