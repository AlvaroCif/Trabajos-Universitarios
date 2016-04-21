/**
 * 
 */
package Modelodediseño.Negocio.Factura.SAFactura.Imp;

import Modelodediseño.Integracion.Cliente.DAOCliente;
import Modelodediseño.Integracion.FactoriaDAO.FactoriaDAO;
import Modelodediseño.Integracion.Factura.DAOFactura;
import Modelodediseño.Integracion.Producto.DAOProducto;
import Modelodediseño.Integracion.Transacciones.Transaction;
import Modelodediseño.Integracion.Transacciones.TransactionManager;
import Modelodediseño.Negocio.Cliente.TCliente;
import Modelodediseño.Negocio.Factura.SAFactura.SAFactura;
import Modelodediseño.Negocio.Factura.TFactura;
import Modelodediseño.Negocio.Producto.TProducto;

import java.util.Collection;
import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAFacturaImp implements SAFactura {
	/** 
	 * (sin Javadoc)
	 * @see SAFactura#alta(TFactura tfactura)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int alta(TFactura tfactura) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int resultado_operacion = -1;
		//Crear TManager e iniciar transaccion.
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOFactura dao_factura = FactoriaDAO.getInstancia().crearDAOFactura();
		DAOCliente dao_cliente = FactoriaDAO.getInstancia().crearDAOCliente();
		DAOProducto dao_producto = FactoriaDAO.getInstancia().crearDAOProducto();
		TCliente tcliente = dao_cliente.mostrar(tfactura.getIdCliente());
		TProducto tproducto;
		boolean correcto = true;
		double total = 0;
		if(tcliente != null && tcliente.getActivo() == true){
			int i = 0;
			while(i < tfactura.getIdproductos().size() && correcto){
				tproducto = dao_producto.mostrar(tfactura.getIdproductos().get(i));
				if(tproducto != null && tproducto.getActivo() == true){
					if (tproducto.getCantidad()>= tfactura.getCantidad().get(i)){
						tproducto.setCantidad(tproducto.getCantidad() - tfactura.getCantidad().get(i));
						dao_producto.modificar(tproducto);
						total = total + tproducto.getPrecio() * tfactura.getCantidad().get(i);
					}
					else{
						transaction.rollback();
						correcto = false;
					}
				}
				else{
					transaction.rollback();
					correcto = false;
				}
				i++;
			}
			
		}
		else{
			transaction.rollback();
			correcto = false;
		}
		if(correcto){
			tfactura.setTotal(total);
			resultado_operacion = dao_factura.crear(tfactura);
			if (resultado_operacion != -1) transaction.commit();
			else transaction.rollback();
		}
		else{
			transaction.rollback();
		}
		tm.deleteTransaction(Thread.currentThread());
		return resultado_operacion;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAFactura#baja(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean baja(int id) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		boolean resultado_operacion;
		//Crear TManager e iniciar transaccion.
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOFactura dao_factura = FactoriaDAO.getInstancia().crearDAOFactura();
		DAOProducto dao_producto = FactoriaDAO.getInstancia().crearDAOProducto();
		
		TFactura tfactura = dao_factura.mostrar(id);
		if(tfactura != null && tfactura.getActivo() == true){
			for(int i = 0; i < tfactura.getIdproductos().size();i++){
				TProducto tproducto = dao_producto.mostrar(tfactura.getIdproductos().get(i));
				tproducto.setCantidad(tproducto.getCantidad() + tfactura.getCantidad().get(i));
				dao_producto.modificar(tproducto);
			}
		
			if(dao_factura.eliminar(id)){
				resultado_operacion = true;
				transaction.commit();
			}
			else{
				resultado_operacion = false;
				transaction.rollback();
			}
		}
		else{
			resultado_operacion = false;
			transaction.rollback();
		}
		tm.deleteTransaction(Thread.currentThread());
		return resultado_operacion;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAFactura#mostrar(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TFactura mostrar(int id) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		//Crear TManager e iniciar transaccion.
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOFactura dao_factura = FactoriaDAO.getInstancia().crearDAOFactura();
		TFactura tfactura = dao_factura.mostrar(id);
		transaction.commit();
		tm.deleteTransaction(Thread.currentThread());
		
		return tfactura;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAFactura#listar()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection<TFactura> listar() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		
		DAOFactura dao_factura = FactoriaDAO.getInstancia().crearDAOFactura();
		Collection<TFactura> facturas = dao_factura.listar();
		
		transaction.commit();
		tm.deleteTransaction(Thread.currentThread());
		return facturas;
		// end-user-code
	}
}