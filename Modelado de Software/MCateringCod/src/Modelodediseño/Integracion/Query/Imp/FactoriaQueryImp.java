/**
 * 
 */
package Modelodediseņo.Integracion.Query.Imp;

import Modelodediseņo.Integracion.Query.FactoriaQuery;
import Modelodediseņo.Integracion.Query.Query;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaQueryImp extends FactoriaQuery {

	@Override
	public Query crearQuery() {
		return new HistorialCompras();
	}
}