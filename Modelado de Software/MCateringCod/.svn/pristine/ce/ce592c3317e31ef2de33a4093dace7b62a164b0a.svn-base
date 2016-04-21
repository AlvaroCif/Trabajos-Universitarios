/**
 * 
 */
package Modelodediseño.Negocio.Cliente.SACliente.Imp;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import Modelodediseño.Integracion.Cliente.DAOCliente;
import Modelodediseño.Integracion.Cliente.Imp.DAOClienteImp;
import Modelodediseño.Integracion.FactoriaDAO.FactoriaDAO;
import Modelodediseño.Integracion.Query.FactoriaQuery;
import Modelodediseño.Integracion.Query.Query;
import Modelodediseño.Integracion.Transacciones.Transaction;
import Modelodediseño.Integracion.Transacciones.TransactionManager;
import Modelodediseño.Negocio.Cliente.SACliente.SACliente;
import Modelodediseño.Negocio.Cliente.TCliente;
import Modelodediseño.Negocio.Cliente.TClienteEmpresa;
import Modelodediseño.Negocio.Cliente.TClienteParticular;
import Modelodediseño.Negocio.Factura.TFactura;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAClienteImp implements SACliente 
{
	/** 
	 * (sin Javadoc)
	 * @see SACliente#alta(TCliente tcliente)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int alta(TCliente tcliente) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int resultado_operacion;
		//Crear TManager e iniciar transaccion.
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOCliente dao_cliente = FactoriaDAO.getInstancia().crearDAOCliente();

		TCliente aux = dao_cliente.mostrarPorNIF(tcliente.getNif());
		if (aux != null) {
			if (aux.getActivo() == true)
			{
				resultado_operacion = -1;
				transaction.rollback();
			}
			else
			{
				aux.setActivo(true);
				dao_cliente.modificar(aux);
				resultado_operacion = aux.getId();
				transaction.commit();
			}
		}else{
			resultado_operacion = dao_cliente.crear(tcliente);
			if(resultado_operacion != -1){
				transaction.commit();
			}
			else{
				transaction.rollback();
			}
			
		}
		tm.deleteTransaction(Thread.currentThread());
		return resultado_operacion;
		
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SACliente#baja(int id)
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
		DAOCliente dao_cliente = FactoriaDAO.getInstancia().crearDAOCliente();
		TCliente tcliente = dao_cliente.mostrar(id);
		if (tcliente == null){
			resultado_operacion = false;
			transaction.rollback();
		}
		else{
			if(tcliente.getActivo() == false){
				transaction.rollback();
				resultado_operacion = false;
			}
			else if(dao_cliente.eliminar(id)){
					transaction.commit();
					resultado_operacion = true;
				}else{
					transaction.rollback();
					resultado_operacion = false;
				}
		}
		tm.deleteTransaction(Thread.currentThread());
		return resultado_operacion;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SACliente#modificar(TCliente tcliente)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean modificar(TCliente tcliente) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		boolean resultado_operacion;
		//Crear TManager e iniciar transaccion.
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOCliente dao_cliente = FactoriaDAO.getInstancia().crearDAOCliente();
		TCliente aux = dao_cliente.mostrar(tcliente.getId());
		if(aux != null && aux.getClass() == tcliente.getClass()){
			{
				if(dao_cliente.mostrarPorNIF(tcliente.getNif()) != null && dao_cliente.mostrarPorNIF(tcliente.getNif()).getId() != tcliente.getId()){
					resultado_operacion = false;
					transaction.rollback();
				}
				else{ 
					if(dao_cliente.modificar(tcliente)){
						resultado_operacion = true;
						transaction.commit();
				}
					else{
						resultado_operacion = false;
						transaction.rollback();
					}
				}
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
	 * @see SACliente#mostrar(boolean id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TCliente mostrar(int id) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		//Crear TManager e iniciar transaccion.
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOCliente dao_cliente = FactoriaDAO.getInstancia().crearDAOCliente();
		TCliente cliente = dao_cliente.mostrar(id);
		transaction.commit();
		tm.deleteTransaction(Thread.currentThread());
		return cliente;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SACliente#listar()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection<TCliente> listar() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		//Crear TManager e iniciar transaccion.
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear Dao y empezar a hacer operaciones.
		DAOCliente dao_cliente = FactoriaDAO.getInstancia().crearDAOCliente();
		Collection<TCliente> clientes = dao_cliente.listar();
		transaction.commit();
		tm.deleteTransaction(Thread.currentThread());
		return clientes;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SACliente#consultarHistorialFacturas()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection<TFactura> consultarHistorialFacturas(TFactura tfactura) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(Thread.currentThread());
		Transaction transaction = tm.getTransaction(Thread.currentThread());
		transaction.start();
		//Crear query y ejecutarla
		Query query = FactoriaQuery.getInstancia().crearQuery();
		Object o = query.execute(tfactura);
		transaction.commit();
		tm.deleteTransaction(Thread.currentThread());
		return (Collection<TFactura>) o;
		// end-user-code
	}
	public static void main(String[] args) {
		TClienteParticular cliente = new  TClienteParticular();
		cliente.setId(57);
		cliente.setNif("70823433Q");
		cliente.setNombre("Boba");
		cliente.setTelefono(123456789);
		cliente.setApellidos("Fett");
		
		SAClienteImp s = new  SAClienteImp();
		DAOCliente dao = new DAOClienteImp();
		TransactionManager.getInstancia().newTransaction(Thread.currentThread());
		
		
		//System.out.println(dao.mostrarPorNIF("05454169H").getActivo());
		//System.out.println(dao.mostrarPorNIF("50226526T").getActivo());
		//System.out.println(dao.mostrarPorNIF("05454169H") != null);
		System.out.println(s.modificar(cliente));
		TClienteEmpresa aux2 = (TClienteEmpresa)s.mostrar(44);
		System.out.println(aux2.getId() + " " + aux2.getClubSocios());
		
		//s.alta(cliente);
	}
}