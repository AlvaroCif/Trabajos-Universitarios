/**
 * 
 */
package Modelodedise�o.Negocio.Cliente.SACliente.Imp;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import Modelodedise�o.Integracion.Cliente.DAOCliente;
import Modelodedise�o.Integracion.Cliente.Imp.DAOClienteImp;
import Modelodedise�o.Integracion.FactoriaDAO.FactoriaDAO;
import Modelodedise�o.Integracion.Query.FactoriaQuery;
import Modelodedise�o.Integracion.Query.Query;
import Modelodedise�o.Integracion.Transacciones.Transaction;
import Modelodedise�o.Integracion.Transacciones.TransactionManager;
import Modelodedise�o.Negocio.Cliente.SACliente.SACliente;
import Modelodedise�o.Negocio.Cliente.TCliente;
import Modelodedise�o.Negocio.Cliente.TClienteEmpresa;
import Modelodedise�o.Negocio.Cliente.TClienteParticular;
import Modelodedise�o.Negocio.Factura.TFactura;

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
		// TODO Ap�ndice de m�todo generado autom�ticamente
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
		// TODO Ap�ndice de m�todo generado autom�ticamente
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
		// TODO Ap�ndice de m�todo generado autom�ticamente
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
		// TODO Ap�ndice de m�todo generado autom�ticamente
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
		// TODO Ap�ndice de m�todo generado autom�ticamente
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
		// TODO Ap�ndice de m�todo generado autom�ticamente
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