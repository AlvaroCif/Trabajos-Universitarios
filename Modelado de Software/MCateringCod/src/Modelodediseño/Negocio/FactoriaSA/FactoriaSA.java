/**
 * 
 */
package Modelodedise�o.Negocio.FactoriaSA;

import Modelodedise�o.Integracion.FactoriaDAO.Imp.FactoriaDAOImp;
import Modelodedise�o.Negocio.Cliente.SACliente.SACliente;
import Modelodedise�o.Negocio.Departamento.SADepartamento.SADepartamento;
import Modelodedise�o.Negocio.Empleado.SAEmpleado.SAEmpleado;
import Modelodedise�o.Negocio.Evento.SAEvento.SAEvento;
import Modelodedise�o.Negocio.FactoriaSA.Imp.FactoriaSAImp;
import Modelodedise�o.Negocio.Factura.SAFactura.SAFactura;
import Modelodedise�o.Negocio.Producto.SAProducto.SAProducto;

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
		// TODO Ap�ndice de m�todo generado autom�ticamente
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