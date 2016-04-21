/**
 * 
 */
package Modelodediseño.Negocio.Evento.SAEvento.Imp;

import Modelodediseño.Negocio.Empleado.Empleado;
import Modelodediseño.Negocio.Evento.SAEvento.SAEvento;
import Modelodediseño.Negocio.Evento.EmpleadoPorEventoId;
import Modelodediseño.Negocio.Evento.EmpleadosPorEvento;
import Modelodediseño.Negocio.Evento.Evento;

import java.util.Collection;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class SAEventoImp implements SAEvento 
{
	/** 
	 * (sin Javadoc)
	 * @see SAEvento#alta(Evento evento)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int alta(Evento evento) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int resultado = -1;
		Evento even = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Evento> query = em.createNamedQuery("Evento.findBynombre", Evento.class);
		query.setParameter("nombre", evento.getNombre());
		
		if (!query.getResultList().isEmpty())
			even = query.getSingleResult();
		if (even != null)
		{
			if (!even.getActivo())
			{
				even.setActivo(true);
				
				et.commit();
				resultado = evento.getId(); //reactivación correcta
			}
			else
				em.getTransaction().rollback(); //Ya está dado de alta
		}
		else
		{
			em.persist(evento);
			et.commit();
			resultado = evento.getId();
		}
		
		em.close();
		emf.close();
		
		return resultado;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAEvento#baja(int id)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int baja(int id) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int resultado = 0;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Evento evento = em.find(Evento.class, id);
		if (evento != null)
			if(evento.getActivo())
			{
				evento.setActivo(false);
				et.commit();
			}
			else
			{
				et.rollback();
				resultado = 1; //ya está dado de baja
			}
		else
		{
			et.rollback();
			resultado = 2; //evento no existe
		}
		
		em.close();
		emf.close();
		
		return resultado;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAEvento#modificar(Evento evento)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int modificar(Evento evento) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int correcto = 0;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Evento even = em.find(Evento.class, evento.getId(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		TypedQuery <Evento> query;
		if (even != null)
			if (even.getActivo())
			{
				if (!even.getNombre().equals(evento.getNombre()))
				{
					query = em.createNamedQuery("Evento.findBynombre", Evento.class);
					query.setParameter("nombre", evento.getNombre());
					if (query.getResultList().isEmpty())
					{
						even.setNombre(evento.getNombre());
						even.setTipoEvento(evento.getTipoEvento());
						even.setFecha(evento.getFecha());
						et.commit(); //modificar correcto
					}
					else
					{
						correcto = 1; //Ya hay evento con ese nombre
						et.rollback();
					}
				}
				else
				{
					even.setTipoEvento(evento.getTipoEvento());
					even.setFecha(evento.getFecha());
					et.commit(); //correcto
				}
			}
			else
			{
				correcto = 2; //evento no está activo
				et.rollback();
			}
		else
		{
			correcto = 3; //evento no existe
			et.rollback();
		}
		
		em.close();
		emf.close();
		
		return correcto;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAEvento#mostrar(int id)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Evento mostrar(int id) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Evento ev = em.find(Evento.class, id);
		if(ev == null)
			et.rollback();
		else
			et.commit();
		
		em.close();
		emf.close();
		
		return ev;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAEvento#listar()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Collection<Evento> listar() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Evento> query = em.createNamedQuery("Evento.findBytodo", Evento.class);
		Collection<Evento> lista = query.getResultList();
		if (lista.isEmpty())
			et.rollback();
		else
			et.commit();
		
		em.close();
		emf.close();
		
		return lista;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAEvento#asignarEmpleado(int idEmpleado, int numHoras, int idEvento)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int asignarEmpleado(int idEmpleado, int numHoras, int idEvento) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int correcto = 0;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		EmpleadoPorEventoId epeId = new EmpleadoPorEventoId ();
		epeId.setEmpleado(idEmpleado);
		epeId.setEvento(idEvento);
		
		Empleado empleado = em.find(Empleado.class, idEmpleado, LockModeType.OPTIMISTIC);
		if (empleado != null)
		{
			Evento evento = em.find(Evento.class, idEvento, LockModeType.OPTIMISTIC);
			if (evento != null)
			{
				if(evento.getActivo() && empleado.getActivo()){
					EmpleadosPorEvento epe = em.find(EmpleadosPorEvento.class, epeId);
					if (epe == null)
					{
						epe = new EmpleadosPorEvento ();
						epe.setEmpleado(empleado);
						epe.setEvento(evento);
						epe.setHoras(numHoras);
						em.persist(epe);
						et.commit();
					}
					else
					{
						correcto = 1; //Ya está asignado el empleado al evento
						et.rollback();
					}
				}
				else{
					et.rollback();
					correcto = 2; //Alguno no está activo
				}

			}
			else
			{
				correcto = 3; //Evento no existe
				et.rollback();
			}
		}
		else
		{
			correcto = 4; //Empleado no está activo
			et.rollback();
		}

		em.close();
		emf.close();
		
		return correcto;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAEvento#desasignarEmpleado(int idEvento, int idEmpleado)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int desasignarEmpleado(int idEvento, int idEmpleado) 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int correcto = 0;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		EmpleadoPorEventoId epeId = new EmpleadoPorEventoId ();
		epeId.setEvento(idEvento);
		epeId.setEmpleado(idEmpleado);
		
		EmpleadosPorEvento epe = em.find(EmpleadosPorEvento.class, epeId);
		
		if (epe != null)
		{
			em.remove(epe);
			et.commit();
		}
		else
		{
			correcto = 1; //No existe la asignación
			et.rollback();
		}

		em.close();
		emf.close();
				
		return correcto;
		// end-user-code
	}

	@Override
	public Collection<EmpleadosPorEvento> empleadosPorEvento(int idEvento) 
	{
		// TODO Auto-generated method stub
		Collection<EmpleadosPorEvento> empleados = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Evento even = em.find(Evento.class, idEvento);
		if (even == null)
			transaction.rollback();
		else
		{
			empleados = even.getEventos();
			transaction.commit();
		}
		
		em.close();
		emf.close();
		
		return empleados;
	}
}