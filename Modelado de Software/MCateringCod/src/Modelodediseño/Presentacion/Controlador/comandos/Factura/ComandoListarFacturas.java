/**
 * 
 */
package Modelodedise�o.Presentacion.Controlador.comandos.Factura;

import java.util.Collection;

import Modelodedise�o.Negocio.FactoriaSA.FactoriaSA;
import Modelodedise�o.Negocio.Factura.TFactura;
import Modelodedise�o.Negocio.Factura.SAFactura.SAFactura;
import Modelodedise�o.Presentacion.Controlador.comandos.Comando;
import Modelodedise�o.Presentacion.Controlador.comandos.RespuestaComando;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ComandoListarFacturas implements Comando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Object datos;
	
	static final int idVistas = 24;

	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public RespuestaComando execute() {
		// begin-user-code
		SAFactura sa = FactoriaSA.getInstancia().crearSAFactura();
		Collection<TFactura> lista = sa.listar();
		RespuestaComando rComando = new RespuestaComando();
		rComando.setDatos(lista);
		rComando.setId(idVistas);
		
		return rComando;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Comando#setdata(Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setdata(Object datos) {
		// begin-user-code
		this.datos = datos;
		// end-user-code
	}
}