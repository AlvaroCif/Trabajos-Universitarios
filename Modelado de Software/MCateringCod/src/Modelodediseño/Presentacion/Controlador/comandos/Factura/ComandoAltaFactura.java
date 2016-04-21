/**
 * 
 */
package Modelodediseño.Presentacion.Controlador.comandos.Factura;

import Modelodediseño.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseño.Negocio.Factura.TFactura;
import Modelodediseño.Negocio.Factura.SAFactura.SAFactura;
import Modelodediseño.Presentacion.Controlador.comandos.Comando;
import Modelodediseño.Presentacion.Controlador.comandos.RespuestaComando;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ComandoAltaFactura implements Comando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Object datos;
	
	static final int idVistas = 21;

	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public RespuestaComando execute() {
		// begin-user-code
		SAFactura sa = FactoriaSA.getInstancia().crearSAFactura();
		int id = sa.alta((TFactura)datos);
		RespuestaComando rComando = new RespuestaComando();
		Integer id_aux = new Integer(id);
		rComando.setDatos(id_aux);
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