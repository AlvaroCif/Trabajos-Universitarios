/**
 * 
 */
package Modelodediseño.Negocio.Evento;

import javax.persistence.MapsId;
import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.EmbeddedId;
import javax.persistence.NamedQueries;
import javax.persistence.Version;

import Modelodediseño.Negocio.Empleado.Empleado;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author usuario_local
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "EmpleadosPorEvento.findByevento", query = "select obj from EmpleadosPorEvento obj where obj.evento = :evento"),
		@NamedQuery(name = "EmpleadosPorEvento.findByid", query = "select obj from EmpleadosPorEvento obj where obj.id = :id"),
		@NamedQuery(name = "EmpleadosPorEvento.findByhoras", query = "select obj from EmpleadosPorEvento obj where obj.horas = :horas"),
		@NamedQuery(name = "EmpleadosPorEvento.findByempleado", query = "select obj from EmpleadosPorEvento obj where obj.empleado = :empleado"),
		@NamedQuery(name = "EmpleadosPorEvento.findAll", query = "select obj from EmpleadosPorEvento obj ")
			 })
public class EmpleadosPorEvento implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@EmbeddedId private EmpleadoPorEventoId id;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@ManyToOne 
	@MapsId private Evento evento;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@ManyToOne
	@MapsId private Empleado empleado;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	@Version
	private int version;
	
	private static final long serialVersionUID = 0;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public EmpleadosPorEvento() {
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private int horas;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public EmpleadoPorEventoId getId() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.id;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param id
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setId(EmpleadoPorEventoId id) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		this.id = id;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int getHoras() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.horas;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param horas
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setHoras(int horas) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		this.horas = horas;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Empleado getEmpleado() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.empleado;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public Evento getEvento() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.evento;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param empleado
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setEmpleado(Empleado empleado) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		this.empleado = empleado;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param evento
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setEvento(Evento evento) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		this.evento = evento;
		// end-user-code
	}
}