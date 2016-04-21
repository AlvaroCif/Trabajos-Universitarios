/**
 * 
 */
package Modelodedise�o.Presentacion.Controlador.Imp;

import Modelodedise�o.Presentacion.Controlador.ControladorAplicacion;
import Modelodedise�o.Presentacion.Controlador.comandos.Comando;
import Modelodedise�o.Presentacion.Controlador.comandos.RespuestaComando;
import Modelodedise�o.Presentacion.Controlador.comandos.Factoria.FactoryComando;
import Modelodedise�o.Presentacion.Dispatcher.Dispatcher;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControladorAplicacionImp extends ControladorAplicacion {

	public void recogerEvento(int id_evento, Object datos) {
		//Se crea el comando.
		Comando comando = FactoryComando.getInstancia().crearComando(id_evento);
		//Se pasan los datos al comando.
		comando.setdata(datos);
		//Ejecuta y recoje la respuesta del comando.
		RespuestaComando rComando = comando.execute();
		//redirige a vista de acuerdo a RespuestaComando.
		Dispatcher.getInstance().processRequest(rComando.getId(), rComando);
	}
	
}