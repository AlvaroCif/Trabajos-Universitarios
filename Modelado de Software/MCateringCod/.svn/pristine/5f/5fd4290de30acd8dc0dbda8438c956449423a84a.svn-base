/**
 * 
 */
package Modelodediseño.Presentacion.Controlador.comandos.Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import Modelodediseño.Negocio.Cliente.SACliente.SACliente;
import Modelodediseño.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseño.Negocio.Factura.TFactura;
import Modelodediseño.Presentacion.Controlador.comandos.Comando;
import Modelodediseño.Presentacion.Controlador.comandos.RespuestaComando;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ComandoConsultarHistorialDeFacturas implements Comando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Object datos;
	
	static final int idVistas = 18;

	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public RespuestaComando execute() {
		// begin-user-code
		SACliente sa = FactoriaSA.getInstancia().crearSACliente();
		
		TFactura a = (TFactura)datos;
		Collection<TFactura> facturas = sa.consultarHistorialFacturas(a);
		RespuestaComando rComando = new RespuestaComando();
		rComando.setDatos(facturas);
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