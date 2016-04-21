/**
 * 
 */
package Modelodediseño.Negocio.Cliente;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TClienteEmpresa extends TCliente {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private boolean clubSocios;
	
	public TClienteEmpresa ()
	{
		super();
		this.clubSocios = false;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean getClubSocios() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.clubSocios;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param clubSocios
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setClubSocios(boolean clubSocios) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		this.clubSocios = clubSocios;
		// end-user-code
	}
}