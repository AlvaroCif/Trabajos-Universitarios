/**
 * 
 */
package Modelodediseño.Presentacion.Controlador.comandos.Factoria.Imp;

import Modelodediseño.Presentacion.Controlador.comandos.Comando;
import Modelodediseño.Presentacion.Controlador.comandos.Cliente.ComandoAltaClienteEmpresa;
import Modelodediseño.Presentacion.Controlador.comandos.Cliente.ComandoAltaClienteParticular;
import Modelodediseño.Presentacion.Controlador.comandos.Cliente.ComandoBajaCliente;
import Modelodediseño.Presentacion.Controlador.comandos.Cliente.ComandoConsultarHistorialDeFacturas;
import Modelodediseño.Presentacion.Controlador.comandos.Cliente.ComandoListarClientes;
import Modelodediseño.Presentacion.Controlador.comandos.Cliente.ComandoModificarClienteEmpresa;
import Modelodediseño.Presentacion.Controlador.comandos.Cliente.ComandoModificarClienteParticular;
import Modelodediseño.Presentacion.Controlador.comandos.Cliente.ComandoMostrarCliente;
import Modelodediseño.Presentacion.Controlador.comandos.Departamento.ComandoAltaDepartamento;
import Modelodediseño.Presentacion.Controlador.comandos.Departamento.ComandoBajaDepartamento;
import Modelodediseño.Presentacion.Controlador.comandos.Departamento.ComandoCalcularNomina;
import Modelodediseño.Presentacion.Controlador.comandos.Departamento.ComandoEmpleadosPorDepartamento;
import Modelodediseño.Presentacion.Controlador.comandos.Departamento.ComandoListarDepartamentos;
import Modelodediseño.Presentacion.Controlador.comandos.Departamento.ComandoModificaDepartamento;
import Modelodediseño.Presentacion.Controlador.comandos.Departamento.ComandoMostrarDepartamento;
import Modelodediseño.Presentacion.Controlador.comandos.Empleado.ComandoAltaEmpleado;
import Modelodediseño.Presentacion.Controlador.comandos.Empleado.ComandoAsignarDepartamento;
import Modelodediseño.Presentacion.Controlador.comandos.Empleado.ComandoBajaEmpleado;
import Modelodediseño.Presentacion.Controlador.comandos.Empleado.ComandoBestEmployee;
import Modelodediseño.Presentacion.Controlador.comandos.Empleado.ComandoDesasignarDepartamento;
import Modelodediseño.Presentacion.Controlador.comandos.Empleado.ComandoEventosPorEmpleado;
import Modelodediseño.Presentacion.Controlador.comandos.Empleado.ComandoListarEmpleados;
import Modelodediseño.Presentacion.Controlador.comandos.Empleado.ComandoModificarEmpleado;
import Modelodediseño.Presentacion.Controlador.comandos.Empleado.ComandoMostrarEmpleado;
import Modelodediseño.Presentacion.Controlador.comandos.Evento.ComandoAltaEvento;
import Modelodediseño.Presentacion.Controlador.comandos.Evento.ComandoAsignarEmpleado;
import Modelodediseño.Presentacion.Controlador.comandos.Evento.ComandoBajaEvento;
import Modelodediseño.Presentacion.Controlador.comandos.Evento.ComandoDesasignarEmpleado;
import Modelodediseño.Presentacion.Controlador.comandos.Evento.ComandoEmpleadosPorEvento;
import Modelodediseño.Presentacion.Controlador.comandos.Evento.ComandoListarEventos;
import Modelodediseño.Presentacion.Controlador.comandos.Evento.ComandoModificarEvento;
import Modelodediseño.Presentacion.Controlador.comandos.Evento.ComandoMostrarEvento;
import Modelodediseño.Presentacion.Controlador.comandos.Factoria.FactoryComando;
import Modelodediseño.Presentacion.Controlador.comandos.Factura.ComandoAltaFactura;
import Modelodediseño.Presentacion.Controlador.comandos.Factura.ComandoDevolucionDeProductosEnFactura;
import Modelodediseño.Presentacion.Controlador.comandos.Factura.ComandoListarFacturas;
import Modelodediseño.Presentacion.Controlador.comandos.Factura.ComandoMostrarFactura;
import Modelodediseño.Presentacion.Controlador.comandos.Producto.ComandoAltaProducto;
import Modelodediseño.Presentacion.Controlador.comandos.Producto.ComandoBajaProducto;
import Modelodediseño.Presentacion.Controlador.comandos.Producto.ComandoListarProductos;
import Modelodediseño.Presentacion.Controlador.comandos.Producto.ComandoModificarProducto;
import Modelodediseño.Presentacion.Controlador.comandos.Producto.ComandoMostrarProducto;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoryComandoImp extends FactoryComando {

	public Comando crearComando(int id) {
		Comando comando = null;
		int id_aux;
		if (id == 52)
			id_aux = 51;
		else if (id == 55)
			id_aux = 54;
		else
			id_aux = id;
		/*
		 * Sintaxis id eventos:
		 *
		 * El id de evento se corresponde (sin el punto) con el id del caso de uso
		 * en el documento SRS.
		 * 
		 */
		switch (id_aux){
		
		//Cliente
		case 11: comando = new ComandoAltaClienteParticular(); break;
		case 12: comando = new ComandoAltaClienteEmpresa(); break;
		case 13: comando = new ComandoBajaCliente(); break;
		case 14: comando = new ComandoModificarClienteParticular(); break;
		case 15: comando = new ComandoModificarClienteEmpresa(); break;
		case 16: comando = new ComandoMostrarCliente(); break;
		case 17: comando = new ComandoListarClientes(); break;
		case 18: comando = new ComandoConsultarHistorialDeFacturas(); break;
		
		//Factura
		case 21: comando = new ComandoAltaFactura(); break;
		case 22: comando = new ComandoDevolucionDeProductosEnFactura(); break;
		case 23: comando = new ComandoMostrarFactura(); break;
		case 24: comando = new ComandoListarFacturas(); break;	
		
		//Producto
		case 31: comando = new ComandoAltaProducto(); break;
		case 32: comando = new ComandoBajaProducto(); break;
		case 33: comando = new ComandoModificarProducto(); break;
		case 34: comando = new ComandoMostrarProducto(); break;
		case 35: comando = new ComandoListarProductos(); break;	
		
		//Departamento
		case 41: comando = new ComandoAltaDepartamento(); break;
		case 42: comando = new ComandoBajaDepartamento(); break;
		case 43: comando = new ComandoModificaDepartamento(); break;
		case 44: comando = new ComandoMostrarDepartamento(); break;
		case 45: comando = new ComandoListarDepartamentos(); break;
		case 46: comando = new ComandoCalcularNomina(); break;
		case 47: comando = new ComandoEmpleadosPorDepartamento(); break;
		
		//Empleado
		case 50: comando = new ComandoEventosPorEmpleado(); break;
		case 51: comando = new ComandoAltaEmpleado(); break;
		case 53: comando = new ComandoBajaEmpleado(); break;
		case 54: comando = new ComandoModificarEmpleado(); break;
		case 56: comando = new ComandoMostrarEmpleado(); break;
		case 57: comando = new ComandoListarEmpleados(); break;
		case 58: comando = new ComandoAsignarDepartamento(); break;
		case 59: comando = new ComandoDesasignarDepartamento(); break;
		case 500: comando = new ComandoBestEmployee(); break;
		
		//Evento
		case 61: comando = new ComandoAltaEvento(); break;
		case 62: comando = new ComandoBajaEvento(); break;
		case 63: comando = new ComandoModificarEvento(); break;
		case 64: comando = new ComandoMostrarEvento(); break;
		case 65: comando = new ComandoListarEventos(); break;
		case 66: comando = new ComandoAsignarEmpleado(); break;
		case 67: comando = new ComandoDesasignarEmpleado(); break;
		case 68: comando = new ComandoEmpleadosPorEvento(); break;

		//Total: 17 eventos.
		}
		
		return comando;
	}
}