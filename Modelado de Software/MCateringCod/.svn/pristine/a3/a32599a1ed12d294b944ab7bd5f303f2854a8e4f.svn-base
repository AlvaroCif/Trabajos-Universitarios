/**
 * 
 */
package Modelodediseño.Presentacion.Controlador.comandos.Factura;

import Modelodediseño.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseño.Negocio.Factura.SAFactura.SAFactura;
import Modelodediseño.Presentacion.Controlador.comandos.Comando;
import Modelodediseño.Presentacion.Controlador.comandos.RespuestaComando;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ComandoDevolucionDeProductosEnFactura implements Comando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Object datos;
	
	static final int idVistas = 22;

	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public RespuestaComando execute() {
		// begin-user-code
		SAFactura sa = FactoriaSA.getInstancia().crearSAFactura();
		int id = (Integer) datos;
		boolean resultado = sa.baja(id);
		RespuestaComando rComando = new RespuestaComando();
		Boolean resultado_aux = new Boolean (resultado);
		rComando.setDatos(resultado_aux);
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