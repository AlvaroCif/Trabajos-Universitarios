/**
 * 
 */
package Modelodediseño.Integracion.FactoriaDAO.Imp;

import Modelodediseño.Integracion.FactoriaDAO.FactoriaDAO;
import Modelodediseño.Integracion.Cliente.DAOCliente;
import Modelodediseño.Integracion.Cliente.Imp.DAOClienteImp;
import Modelodediseño.Integracion.Factura.DAOFactura;
import Modelodediseño.Integracion.Factura.Imp.DAOFacturaImp;
import Modelodediseño.Integracion.Producto.DAOProducto;
import Modelodediseño.Integracion.Producto.Imp.DAOProductoImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaDAOImp extends FactoriaDAO {
	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAO#crearDAOCliente()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOCliente crearDAOCliente() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new DAOClienteImp();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAO#crearDAOFactura()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOFactura crearDAOFactura() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new DAOFacturaImp();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAO#crearDAOProducto()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOProducto crearDAOProducto() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new DAOProductoImp();
		// end-user-code
	}
}