/**
 * 
 */
package Modelodediseņo.Presentacion.Controlador.comandos.Cliente;

import Modelodediseņo.Negocio.Cliente.TCliente;
import Modelodediseņo.Negocio.Cliente.SACliente.SACliente;
import Modelodediseņo.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseņo.Presentacion.Controlador.comandos.Comando;
import Modelodediseņo.Presentacion.Controlador.comandos.RespuestaComando;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ComandoModificarClienteParticular implements Comando {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Object datos;
	
	static final int idVistas = 14;

	/** 
	 * (sin Javadoc)
	 * @see Comando#execute()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public RespuestaComando execute() {
		// begin-user-code
		SACliente sa = FactoriaSA.getInstancia().crearSACliente();
		TCliente tcliente = (TCliente) datos;
		boolean aux = sa.modificar(tcliente);
		RespuestaComando rComando = new RespuestaComando();
		Boolean aux_2 = new Boolean(aux);
		rComando.setDatos(aux_2);
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