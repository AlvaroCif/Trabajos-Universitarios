/**
 * 
 */
package Modelodediseño.Negocio.Departamento.SADepartamento.Imp;

import Modelodediseño.Negocio.Departamento.SADepartamento.SADepartamento;
import Modelodediseño.Negocio.Departamento.Departamento;
import Modelodediseño.Negocio.Empleado.Empleado;
import Modelodediseño.Negocio.Evento.Evento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
public class SADepartamentoImp implements SADepartamento {
	/** 
	 * (sin Javadoc)
	 * @see SADepartamento#alta(Departamento departamento)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int alta(Departamento departamento) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int resultado = 0;
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		TypedQuery<Departamento> query = em.createNamedQuery("Departamento.findBynombre", Departamento.class);
		query.setParameter("nombre", departamento.getNombre());
		
		Departamento d = null;
		if(query.getResultList().size() != 0){
			d =  query.getSingleResult();
		}

		if(d != null){
			if (d.getActivo() == false){
				d.setActivo(true);
				transaction.commit();
				resultado = d.getId();  
			}
			else{
				transaction.rollback();
				resultado = -1;		//Si el resultado de dar de alta es -1 es que el nombre esta ya pillado.
			}
		}
		else{
			em.persist(departamento);
			transaction.commit();
			resultado = departamento.getId();
		}
		em.close();
		EMF.close(); 
		return resultado;
		// end-user-code
	}
	/** 
	 * (sin Javadoc)
	 * @see SADepartamento#baja(int id)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int baja(int id) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int resultado = 0;
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		TypedQuery<Departamento> query = em.createNamedQuery("Departamento.findByid", Departamento.class);
		query.setParameter("id", id);
		if(query.getResultList().size() != 0){
			Departamento d = query.getSingleResult();
			if(d.getActivo()){
				d.setActivo(false);
				transaction.commit();
				resultado = 0; //baja correcta
			}
			else{
			resultado = 1; //Ya está dado de baja
			transaction.rollback();
			}
		}
		else{
			resultado = 2; //No está en la BBDD
			transaction.rollback();
		}
		em.close();EMF.close();
		return resultado;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SADepartamento#modificar(Departamento departamento)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int modificar(Departamento departamento) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int resultado = 0;
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Departamento dep = em.find(Departamento.class, departamento.getId(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		if(dep != null) {
			if (dep.getActivo()){
				if(!dep.getNombre().equals(departamento.getNombre())){
					TypedQuery<Departamento> query = em.createNamedQuery("Departamento.findBynombre", Departamento.class);
					query.setParameter("nombre", departamento.getNombre());
					if(query.getResultList().size() == 0){
						dep.setNombre(departamento.getNombre());
						transaction.commit();
						resultado = 0;
					}
					else{
						transaction.rollback();
						resultado = 1; //Nombre ya en el sistema
					}
				}
				else{
					transaction.commit();
					resultado = 0;
				}
			}
			else{
				transaction.rollback();
				resultado = 2; //Departamento de baja
			}
		}
		else{
			transaction.rollback();
			resultado = 3; //No está en la BBDD
		}
		em.close(); EMF.close();
		return resultado;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SADepartamento#mostrar(int id)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Departamento mostrar(int id) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Departamento dep = em.find(Departamento.class, id);
		transaction.commit();
		em.close();EMF.close();
		return dep;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SADepartamento#listar()
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Collection<Departamento> listar() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		TypedQuery<Departamento> query = em.createNamedQuery("Departamento.findBytodo", Departamento.class);
		Collection<Departamento> departamentos = query.getResultList();
		transaction.commit();
		em.close();EMF.close();
		return departamentos;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SADepartamento#calcularNomina(int id)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public double calcularNomina(int id) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		double resultado = 0;
		Departamento dep = em.find(Departamento.class, id);
		if( dep != null){

			for (Empleado empleado : dep.getEmpleados()) {
				if (empleado.getActivo()){
			    em.lock(empleado, LockModeType.OPTIMISTIC);
			    resultado += empleado.calculoNomina();
				}
			}
			transaction.commit();
		}
		else{
			resultado = -1;
			transaction.rollback();
		}
		em.close();EMF.close();
		return resultado;
		// end-user-code
	}
	
	@Override
	public Collection<Empleado> empleadosPorDepartamento(int idDepartamento) 
	{
		// TODO Auto-generated method stub
		Collection<Empleado> lista = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MCateringCod");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Departamento dep = em.find(Departamento.class, idDepartamento);
		if (dep == null)
			transaction.rollback();
		else
			//if (dep.getActivo())
			{
				lista = dep.getEmpleados();
				transaction.commit();
			}
			//else
				//transaction.rollback();
		
		em.close();
		emf.close();
		
		return lista;
	}
	
}