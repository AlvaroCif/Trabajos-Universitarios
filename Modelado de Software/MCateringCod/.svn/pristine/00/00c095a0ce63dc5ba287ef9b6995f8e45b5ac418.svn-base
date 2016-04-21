/**
 * 
 */
package Modelodediseño.Negocio.FactoriaSA;

import Modelodediseño.Integracion.FactoriaDAO.Imp.FactoriaDAOImp;
import Modelodediseño.Negocio.Cliente.SACliente.SACliente;
import Modelodediseño.Negocio.Departamento.SADepartamento.SADepartamento;
import Modelodediseño.Negocio.Empleado.SAEmpleado.SAEmpleado;
import Modelodediseño.Negocio.Evento.SAEvento.SAEvento;
import Modelodediseño.Negocio.FactoriaSA.Imp.FactoriaSAImp;
import Modelodediseño.Negocio.Factura.SAFactura.SAFactura;
import Modelodediseño.Negocio.Producto.SAProducto.SAProducto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaSA {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static FactoriaSA instancia;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static FactoriaSA getInstancia() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if (instancia == null)
			instancia = new FactoriaSAImp();
		return instancia;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SACliente crearSACliente();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAFactura crearSAFactura();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAProducto crearSAProducto();
	
	public abstract SADepartamento crearSADepartamento();
	
	public abstract SAEmpleado crearSAEmpleado();
	
	public abstract SAEvento crearSAEvento();
}