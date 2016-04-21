/**
 * 
 */
package Modelodediseño.Negocio.Producto.SAProducto.Imp;

import Modelodediseño.Integracion.Cliente.DAOCliente;
import Modelodediseño.Integracion.FactoriaDAO.FactoriaDAO;
import Modelodediseño.Integracion.Producto.DAOProducto;
import Modelodediseño.Integracion.Transacciones.Transaction;
import Modelodediseño.Integracion.Transacciones.TransactionManager;
import Modelodediseño.Negocio.Cliente.TCliente;
import Modelodediseño.Negocio.Producto.SAProducto.SAProducto;
import Modelodediseño.Negocio.Producto.TProducto;

import java.util.Collection;
import java.util.Set;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAProductoImp implements SAProducto {
	/** 
	 * (sin Javadoc)
	 * @see SAProducto#alta(TProducto tproducto)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int alta(TProducto tproducto) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int resultado_operacion;
		//Crear TManager e iniciar transaccion.
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOProducto dao_producto = FactoriaDAO.getInstancia().crearDAOProducto();
		TProducto producto = dao_producto.mostrarPorNombre(tproducto.getNombre());
		if (producto != null){
			if(producto.getActivo() == false){
				producto.setActivo(true);
				if(modificar(producto)){
					resultado_operacion = producto.getId();
					transaction.commit();
				}
				else{
					resultado_operacion = -1;
					transaction.rollback();
				}
			}
			else{
				resultado_operacion = -1;
				transaction.rollback();
			}
		}
		else{
			resultado_operacion = dao_producto.crear(tproducto);
			if(resultado_operacion == -1) transaction.rollback();
			else transaction.commit();
		}
		tm.deleteTransaction(Thread.currentThread());
		return resultado_operacion;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAProducto#baja(int id)
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
		DAOProducto dao_producto = FactoriaDAO.getInstancia().crearDAOProducto();
		TProducto tproducto = dao_producto.mostrar(id);
		if (tproducto == null){
			resultado_operacion = false;
			transaction.rollback();
		}
		else{
			if(tproducto.getActivo() == false){
				transaction.rollback();
				resultado_operacion = false;
			}
			else{ 
				if(dao_producto.eliminar(id)){
				transaction.commit();
				resultado_operacion = true;
				}else{
					transaction.rollback();
					resultado_operacion = false;
				}
			}
		}
		tm.deleteTransaction(Thread.currentThread());
		return resultado_operacion;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAProducto#modificar(TProducto tproducto)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean modificar(TProducto tproducto) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		boolean resultado_operacion;
		//Crear TManager e iniciar transaccion.
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOProducto dao_producto = FactoriaDAO.getInstancia().crearDAOProducto();
		if(dao_producto.mostrar(tproducto.getId()) == null){
			transaction.rollback();
			resultado_operacion = false;
		}
		else{
			if((dao_producto.mostrarPorNombre(tproducto.getNombre())) != null && dao_producto.mostrarPorNombre(tproducto.getNombre()).getId() != tproducto.getId()){
				transaction.rollback();
				resultado_operacion = false;
			}
			else{
				if(dao_producto.modificar(tproducto)){
					transaction.commit();
					resultado_operacion = true;
				}
				else{
					transaction.rollback();
					resultado_operacion = false;
				}
			}
		}

		tm.deleteTransaction(Thread.currentThread());
		return resultado_operacion;
		// end-user-code
	}


	/** 
	 * (sin Javadoc)
	 * @see SAProducto#mostrar(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TProducto mostrar(int id) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOProducto dao_producto = FactoriaDAO.getInstancia().crearDAOProducto();
		TProducto producto = dao_producto.mostrar(id);
		transaction.commit();
		tm.deleteTransaction(Thread.currentThread());
		return producto;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAProducto#listar()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection<TProducto> listar() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOProducto dao_producto = FactoriaDAO.getInstancia().crearDAOProducto();
		Collection<TProducto> productos = dao_producto.listar();
		transaction.commit();
		tm.deleteTransaction(Thread.currentThread());
		return productos;

		// end-user-code
	}
}