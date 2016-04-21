/**
 * 
 */
package Modelodediseño.Integracion.Cliente.Imp;

import Modelodediseño.Integracion.Cliente.DAOCliente;
import Modelodediseño.Integracion.Transacciones.Transaction;
import Modelodediseño.Integracion.Transacciones.TransactionManager;
import Modelodediseño.Negocio.Cliente.TCliente;
import Modelodediseño.Negocio.Cliente.TClienteEmpresa;
import Modelodediseño.Negocio.Cliente.TClienteParticular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOClienteImp implements DAOCliente {

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#crear(TCliente tcliente)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int crear(TCliente tcliente) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int clave_generada = -1;

		Thread t = Thread.currentThread();
		/*TransactionManager tm = TransactionManager.getInstancia();
		tm.newTransaction(t);
		Transaction transaccion = tm.getTransaction(t);
		transaccion.start();

		FactoriaDAO factoria = FactoriaDAOImp.getInstancia();
		DAOCliente clienteD = factoria.crearDAOCliente();
		transaccion.getResource();*/
		//COMPROBAR QUE ESTÉ BIEN EL CASTING
		Connection conexion = (Connection) TransactionManager.getInstancia().getTransaction(t).getResource();

		PreparedStatement ps;

		try 
		{
			ps = conexion.prepareStatement("insert into cliente values(null,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			//ps.setInt(1, tcliente.getId());
			ps.setString(1, tcliente.getNif());
			ps.setString(2, tcliente.getNombre());
			ps.setInt(3, tcliente.getTelefono());
			ps.setBoolean(4, tcliente.getActivo());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next())
				clave_generada = rs.getInt(1);
			
			// tipos : cliente particular/empresa
			TClienteParticular tCP = new TClienteParticular();
			if (tcliente.getClass().equals(tCP.getClass())) 
			{
				PreparedStatement ps2 = conexion.prepareStatement("insert into clienteparticular values(?,?)");
				ps2.setInt(1, clave_generada);
				ps2.setString(2, ((TClienteParticular) tcliente).getApellidos());
				ps2.executeUpdate();
			} else 
			{
				PreparedStatement ps3 = conexion.prepareStatement("insert into clienteempresa values(?,?)");
				ps3.setInt(1, clave_generada);
				ps3.setBoolean(2, ((TClienteEmpresa) tcliente).getClubSocios());
				ps3.executeUpdate();
			}
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		//clave_generada = 1;
		//*******************************buscar codigo de id
		
		return clave_generada;

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#eliminar(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean eliminar(int id) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		boolean verificacion = false;
		Thread thread = Thread.currentThread();
		Transaction t = TransactionManager.getInstancia().getTransaction(thread);
		
		PreparedStatement ps;
		Connection c = (Connection) t.getResource();
		
		try 
		{
			ps = c.prepareStatement("UPDATE cliente SET activo=? WHERE id=?");
			ps.setBoolean(1, false);
			ps.setInt(2, id);
			ps.executeUpdate();
			verificacion = true;
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return verificacion;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#modificar(TCliente tcliente)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean modificar(TCliente tcliente) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		boolean verificacion = false;
		Connection c = (Connection) TransactionManager.getInstancia().getTransaction(Thread.currentThread()).getResource();

		PreparedStatement ps;
		try 
		{
			ps = c.prepareStatement("UPDATE cliente SET nif=?, nombre=?, telefono=?, activo=? WHERE id=?");
			ps.setString(1, tcliente.getNif());
			ps.setString(2, tcliente.getNombre());
			ps.setInt(3, tcliente.getTelefono());
			ps.setBoolean(4, tcliente.getActivo());
			ps.setInt(5, tcliente.getId());
			
			ps.executeUpdate();
			
			TCliente cliente = new TClienteParticular ();
			if (tcliente.getClass() == cliente.getClass())
			{
				PreparedStatement ps2 = c.prepareStatement("UPDATE clienteparticular SET apellidos=? WHERE id=?");
				ps2.setString(1, ((TClienteParticular) tcliente).getApellidos());
				ps2.setInt(2, tcliente.getId());
				ps2.executeUpdate();
			}
			else
			{
				PreparedStatement ps3 = c.prepareStatement("UPDATE clienteempresa SET clubsocios=? WHERE id=?");
				ps3.setBoolean(1, ((TClienteEmpresa) tcliente).getClubSocios());
				ps3.setInt(2, tcliente.getId());
				ps3.executeUpdate();
			}
			verificacion = true;
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return verificacion;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#mostrar(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TCliente mostrar(int id) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TCliente cliente = null;
		
		Connection c = (Connection) TransactionManager.getInstancia().getTransaction(Thread.currentThread()).getResource();
		PreparedStatement ps;
		
		try 
		{
			ps = c.prepareStatement("SELECT id, nif, nombre, telefono, activo FROM cliente WHERE id=?");
			ps.setInt (1, id);
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps2;
			if (rs.next())
			{				
				ps2 = c.prepareStatement("SELECT id, apellidos FROM clienteparticular WHERE id=?");
				ps2.setInt(1, id);
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next())
				{ //Si nos deja hacer esto, esta en clienteparticular
					TClienteParticular aux = new TClienteParticular();
					aux.setId(rs.getInt("id"));
					aux.setNif(rs.getString("nif"));
					aux.setNombre(rs.getString("nombre"));
					aux.setTelefono(rs.getInt("telefono"));
					aux.setActivo(rs.getBoolean("activo"));
					aux.setApellidos (rs2.getString(2));
					cliente = aux;
					
				}
				else
				{		//Si no esta en clienteparticulas esta en clienteempresa.
					ps2 = c.prepareStatement("SELECT id, clubsocios FROM clienteempresa WHERE id=?");
					ps2.setInt(1, id);
					rs2 = ps2.executeQuery();
					if(rs2.next())
					{
						TClienteEmpresa aux = new TClienteEmpresa();
						aux.setId(rs.getInt("id"));
						aux.setNif(rs.getString("nif"));
						aux.setNombre(rs.getString("nombre"));
						aux.setTelefono(rs.getInt("telefono"));
						aux.setActivo(rs.getBoolean("activo"));
						aux.setClubSocios(rs2.getBoolean(2));
						cliente = aux;
					}
					else
					{
						cliente = null;
					}
				}
			}
			else
				cliente = null;
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		
		return cliente;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#listar()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Collection<TCliente> listar() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TCliente cliente = null;
		ArrayList<TCliente> clientes = new ArrayList<TCliente>();
		
		Connection c = (Connection) TransactionManager.getInstancia().getTransaction(Thread.currentThread()).getResource();
		PreparedStatement ps;
		try 
		{
			ps = c.prepareStatement("SELECT id, nif, nombre, telefono, activo FROM cliente");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				PreparedStatement ps2 = c.prepareStatement("SELECT id, apellidos FROM clienteparticular where id =? for update");
				ps2.setInt(1, rs.getInt("id"));
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next())
				{ //Si nos deja hacer esto, esta en clienteparticular
					TClienteParticular aux = new TClienteParticular();
					aux.setId(rs.getInt("id"));
					aux.setNif(rs.getString("nif"));
					aux.setNombre(rs.getString("nombre"));
					aux.setTelefono(rs.getInt("telefono"));
					aux.setActivo(rs.getBoolean("activo"));
					aux.setApellidos (rs2.getString(2));
					cliente = aux;
					
				}
				else
				{		//Si no esta en clienteparticulas esta en clienteempresa.
					PreparedStatement ps3 = c.prepareStatement("SELECT id, clubsocios FROM clienteempresa where id =?");
					ps3.setInt(1, rs.getInt("id"));
					ResultSet rs3 = ps3.executeQuery();
					if(rs3.next())
					{
						TClienteEmpresa aux = new TClienteEmpresa();
						aux.setId(rs.getInt("id"));
						aux.setNif(rs.getString("nif"));
						aux.setNombre(rs.getString("nombre"));
						aux.setTelefono(rs.getInt("telefono"));
						aux.setActivo(rs.getBoolean("activo"));
						aux.setClubSocios(rs3.getBoolean(2));
						cliente = aux;
					}
					else
					{
						cliente = null;
					}
				}
				clientes.add(cliente);
			}
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return clientes;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOCliente#mostrarPorNIF(String NIF)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TCliente mostrarPorNIF(String nif) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TCliente cliente = null;
		
		Connection c = (Connection) TransactionManager.getInstancia().getTransaction(Thread.currentThread()).getResource();
		PreparedStatement ps;
		
		try 
		{
			ps = c.prepareStatement("SELECT id FROM `cliente` WHERE nif=?");
			ps.setString(1, nif);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			cliente = this.mostrar(id);
		} catch (SQLException e) 
		{
			// TODO Bloque catch generado automáticamente
			//e.printStackTrace();
		}
		return cliente;
		// end-user-code
	}

}