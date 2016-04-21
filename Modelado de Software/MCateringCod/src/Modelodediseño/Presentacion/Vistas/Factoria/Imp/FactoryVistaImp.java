/**
 * 
 */
package Modelodediseño.Presentacion.Vistas.Factoria.Imp;

import Modelodediseño.Presentacion.Vistas.SwingPrincipalView;
import Modelodediseño.Presentacion.Vistas.Vista;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaAltaClienteEmpresa;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaAltaClienteParticular;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaBajaCliente;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaConsultarHistorialDeFacturas;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaListarClientes;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaModificarClienteEmpresa;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaModificarClienteParticular;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaMostrarCliente;
import Modelodediseño.Presentacion.Vistas.Departamento.VistaAltaDepartamento;
import Modelodediseño.Presentacion.Vistas.Departamento.VistaBajaDepartamento;
import Modelodediseño.Presentacion.Vistas.Departamento.VistaCalcularNomina;
import Modelodediseño.Presentacion.Vistas.Departamento.VistaEmpleadosPorDepartamento;
import Modelodediseño.Presentacion.Vistas.Departamento.VistaListarDepartamentos;
import Modelodediseño.Presentacion.Vistas.Departamento.VistaModificarDepartamento;
import Modelodediseño.Presentacion.Vistas.Departamento.VistaMostrarDepartamento;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaAltaEmpleadoComercial;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaAltaEmpleadoRepartidor;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaAsignarDepartamento;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaBajaEmpleado;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaDesasignarDepartamento;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaEventosPorEmpleado;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaListarEmpleados;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaMejorEmpleado;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaModificarEmpleadoComercial;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaModificarEmpleadoRepartidor;
import Modelodediseño.Presentacion.Vistas.Empleado.VistaMostrarEmpleado;
import Modelodediseño.Presentacion.Vistas.Evento.VistaAltaEvento;
import Modelodediseño.Presentacion.Vistas.Evento.VistaAsignarEmpleado;
import Modelodediseño.Presentacion.Vistas.Evento.VistaBajaEvento;
import Modelodediseño.Presentacion.Vistas.Evento.VistaDesasignarEmpleado;
import Modelodediseño.Presentacion.Vistas.Evento.VistaEmpleadosPorEvento;
import Modelodediseño.Presentacion.Vistas.Evento.VistaListarEventos;
import Modelodediseño.Presentacion.Vistas.Evento.VistaModificarEvento;
import Modelodediseño.Presentacion.Vistas.Evento.VistaMostrarEvento;
import Modelodediseño.Presentacion.Vistas.Factoria.FactoryVista;
import Modelodediseño.Presentacion.Vistas.Factura.VistaAltaFactura;
import Modelodediseño.Presentacion.Vistas.Factura.VistaDevolucionDeProductosEnFactura;
import Modelodediseño.Presentacion.Vistas.Factura.VistaListarFacturas;
import Modelodediseño.Presentacion.Vistas.Factura.VistaMostrarFactura;
import Modelodediseño.Presentacion.Vistas.Producto.VistaAltaProducto;
import Modelodediseño.Presentacion.Vistas.Producto.VistaBajaProducto;
import Modelodediseño.Presentacion.Vistas.Producto.VistaListarProductos;
import Modelodediseño.Presentacion.Vistas.Producto.VistaModificarProducto;
import Modelodediseño.Presentacion.Vistas.Producto.VistaMostrarProducto;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoryVistaImp extends FactoryVista {
	/** 
	 * (sin Javadoc)
	 * @see FactoryVista#RedirigirVista(Object datos, int idVista)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void RedirigirVista(Object datos, int idVista) {

		/*
		 * Sintaxis id eventos:
		 *
		 * El id de evento se corresponde con el id del caso de uso
		 * (sin el punto) en el documento SRS.
		 * 
		 */
		switch (idVista) 
		{
		
			//Cliente.
			case 11: SwingPrincipalView.getInstancia().selectVistaAltaClienteParticular().update(idVista, datos); break;
			case 12: SwingPrincipalView.getInstancia().selectVistaAltaClienteEmpresa().update(idVista, datos); break;
			case 13: SwingPrincipalView.getInstancia().selectVistaBajaCliente().update(idVista, datos); break;
			case 14: SwingPrincipalView.getInstancia().selectVistaModificarClienteParticular().update(idVista, datos); break;
			case 15: SwingPrincipalView.getInstancia().selectVistaModificarClienteEmpresa().update(idVista, datos); break;
			case 16: SwingPrincipalView.getInstancia().selectVistaMostarCliente().update(idVista, datos); break;
			case 17: SwingPrincipalView.getInstancia().selectVistaListarClientes().update(idVista, datos); break;
			case 18: SwingPrincipalView.getInstancia().selectVistaConsultarHistoriaDeFacturas().update(idVista, datos); break;
			
			//Factura.
			case 21: SwingPrincipalView.getInstancia().selectVistaAltaFactura().update(idVista, datos); break;
			case 22: SwingPrincipalView.getInstancia().selectVistaDevolucionDeProductosEnFactura().update(idVista, datos); break;
			case 23: SwingPrincipalView.getInstancia().selectVistaMostrarFactura().update(idVista, datos); break;
			case 24: SwingPrincipalView.getInstancia().selectVistaListarFacturas().update(idVista, datos); break;
			
			//Producto.
			case 31: SwingPrincipalView.getInstancia().selectVistaAltaProducto().update(idVista, datos); break;
			case 32: SwingPrincipalView.getInstancia().selectVistaBajaProducto().update(idVista, datos); break;
			case 33: SwingPrincipalView.getInstancia().selectVistaModificarProducto().update(idVista, datos); break;
			case 34: SwingPrincipalView.getInstancia().selectVistaMostrarProducto().update(idVista, datos); break;
			case 35: SwingPrincipalView.getInstancia().selectVistaListarProductos().update(idVista, datos); break;
			//case 36: 
			
			//Departamento.
			case 41: SwingPrincipalView.getInstancia().selectVistaAltaDepartamento().update(idVista, datos); break;
			case 42: SwingPrincipalView.getInstancia().selectVistaBajaDepartamento().update(idVista, datos); break;
			case 43: SwingPrincipalView.getInstancia().selectVistaModificarDepartamento().update(idVista, datos); break;
			case 44: SwingPrincipalView.getInstancia().selectVistaMostrarDepartamento().update(idVista, datos); break;
			case 45: SwingPrincipalView.getInstancia().selectVistaListarDepartamentos().update(idVista, datos); break;
			case 46: SwingPrincipalView.getInstancia().selectVistaCalcularNomina().update(idVista, datos); break;
			case 47: SwingPrincipalView.getInstancia().selectVistaEmpleadosPorDepartamento().update(idVista, datos); break;
			
			//Empleados
			case 50: SwingPrincipalView.getInstancia().selectVistaEventosPorEmpleado().update(idVista, datos); break;
			case 51: SwingPrincipalView.getInstancia().selectVistaAltaEmpleadoComercial().update(idVista, datos); break;
			case 52: SwingPrincipalView.getInstancia().selectVistaAltaEmpleadoRepartidor().update(idVista, datos); break;
			case 53: SwingPrincipalView.getInstancia().selectVistaBajaEmpleado().update(idVista, datos); break;
			case 54: SwingPrincipalView.getInstancia().selectVistaModificarEmpleadoComercial().update(idVista, datos); break;
			case 55: SwingPrincipalView.getInstancia().selectVistaModificarEmpleadoRepartidor().update(idVista, datos); break;
			case 56: SwingPrincipalView.getInstancia().selectVistaMostrarEmpleado().update(idVista, datos); break;
			case 57: SwingPrincipalView.getInstancia().selectVistaListarEmpleados().update(idVista, datos); break;
			case 58: SwingPrincipalView.getInstancia().selectVistaAsignarDepartamento().update(idVista, datos); break;
			case 59: SwingPrincipalView.getInstancia().selectVistaDesasignarDepartamento().update(idVista, datos); break;
			case 500: SwingPrincipalView.getInstancia().selectVistaMejorEmpleado().update(idVista, datos); break;

			
			//Evento
			case 61: SwingPrincipalView.getInstancia().selectVistaAltaEvento().update(idVista, datos); break;
			case 62: SwingPrincipalView.getInstancia().selectVistaBajaEvento().update(idVista, datos); break;
			case 63: SwingPrincipalView.getInstancia().selectVistaModificarEvento().update(idVista, datos); break;
			case 64: SwingPrincipalView.getInstancia().selectVistaMostrarEvento().update(idVista, datos); break;
			case 65: SwingPrincipalView.getInstancia().selectVistaListarEventos().update(idVista, datos); break;
			case 66: SwingPrincipalView.getInstancia().selectVistaAsignarEmpleado().update(idVista, datos); break;
			case 67: SwingPrincipalView.getInstancia().selectVistaDesasignarEmpleado().update(idVista, datos); break;
			case 68: SwingPrincipalView.getInstancia().selectVistaEmpleadosPorEvento().update(idVista, datos); break;


			
			//case 36: 
		
		//Total: 39 eventos.
		}
		
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoryVista#crearVista(int idVista)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Vista crearVista(int idVista) {
		
		Vista vista = null;
		/*
		 * Sintaxis id eventos:
		 *
		 * El id de evento se corresponde con el id del caso de uso
		 * (sin el punto) en el documento SRS.
		 * 
		 */
		switch (idVista) 
		{
		
			//Cliente.
			case 11: vista = new VistaAltaClienteParticular(); break;
			case 12: vista = new VistaAltaClienteEmpresa(); break;
			case 13: vista = new VistaBajaCliente(); break;
			case 14: vista = new VistaModificarClienteParticular(); break;
			case 15: vista = new VistaModificarClienteEmpresa(); break;
			case 16: vista = new VistaMostrarCliente(); break;
			case 17: vista = new VistaListarClientes(); break;
			case 18: vista = new VistaConsultarHistorialDeFacturas(); break;
			
			//Factura.
			case 21: vista = new VistaAltaFactura(); break;
			case 22: vista = new VistaDevolucionDeProductosEnFactura(); break;
			case 23: vista = new VistaMostrarFactura(); break;
			case 24: vista = new VistaListarFacturas(); break;
			
			//Producto.
			case 31: vista = new VistaAltaProducto(); break;
			case 32: vista = new VistaBajaProducto(); break;
			case 33: vista = new VistaModificarProducto(); break;
			case 34: vista = new VistaMostrarProducto(); break;
			case 35: vista = new VistaListarProductos(); break;
			
			//Departamento
			case 41: vista = new VistaAltaDepartamento(); break;
			case 42: vista = new VistaBajaDepartamento(); break;
			case 43: vista = new VistaModificarDepartamento(); break;
			case 44: vista = new VistaMostrarDepartamento(); break;
			case 45: vista = new VistaListarDepartamentos(); break;
			case 46: vista = new VistaCalcularNomina(); break;
			case 47: vista = new VistaEmpleadosPorDepartamento(); break;
			
			//Empleado
			case 50: vista = new VistaEventosPorEmpleado(); break;
			case 51: vista = new VistaAltaEmpleadoComercial(); break;
			case 52: vista = new VistaAltaEmpleadoRepartidor(); break;
			case 53: vista = new VistaBajaEmpleado(); break;
			case 54: vista = new VistaModificarEmpleadoComercial(); break;
			case 55: vista = new VistaModificarEmpleadoRepartidor(); break;
			case 56: vista = new VistaMostrarEmpleado(); break;
			case 57: vista = new VistaListarEmpleados(); break;
			case 58: vista = new VistaAsignarDepartamento(); break;
			case 59: vista = new VistaDesasignarDepartamento(); break;
			case 500: vista = new VistaMejorEmpleado(); break;
			
			//Evento
			case 61: vista = new VistaAltaEvento(); break;
			case 62: vista = new VistaBajaEvento(); break;
			case 63: vista = new VistaModificarEvento(); break;
			case 64: vista = new VistaMostrarEvento(); break;
			case 65: vista = new VistaListarEventos(); break;
			case 66: vista = new VistaAsignarEmpleado(); break;
			case 67: vista = new VistaDesasignarEmpleado(); break;
			case 68: vista = new VistaEmpleadosPorEvento(); break;
		
		//Total: 39 eventos.
		
		}
		return vista;
		
	}
}