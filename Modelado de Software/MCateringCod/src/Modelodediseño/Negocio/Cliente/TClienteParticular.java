/**
 * 
 */
package Modelodedise�o.Negocio.Cliente;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TClienteParticular extends TCliente {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String apellidos;
	
	public TClienteParticular ()
	{
		super();
		this.apellidos = "pepe";
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getApellidos() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return this.apellidos;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param apellidos
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setApellidos(String apellidos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		this.apellidos = apellidos;
		// end-user-code
	}
}