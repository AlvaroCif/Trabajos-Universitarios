/**
 * 
 */
package Modelodedise�o.Integracion.FactoriaDAO.Imp;

import Modelodedise�o.Integracion.FactoriaDAO.FactoriaDAO;
import Modelodedise�o.Integracion.Cliente.DAOCliente;
import Modelodedise�o.Integracion.Cliente.Imp.DAOClienteImp;
import Modelodedise�o.Integracion.Factura.DAOFactura;
import Modelodedise�o.Integracion.Factura.Imp.DAOFacturaImp;
import Modelodedise�o.Integracion.Producto.DAOProducto;
import Modelodedise�o.Integracion.Producto.Imp.DAOProductoImp;

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
		// TODO Ap�ndice de m�todo generado autom�ticamente
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
		// TODO Ap�ndice de m�todo generado autom�ticamente
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
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return new DAOProductoImp();
		// end-user-code
	}
}