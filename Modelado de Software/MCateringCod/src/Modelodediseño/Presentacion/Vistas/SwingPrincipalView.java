/**
 * 
 */
package Modelodediseņo.Presentacion.Vistas;

import Modelodediseņo.Presentacion.Vistas.Cliente.VistaAltaClienteParticular;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Modelodediseņo.Presentacion.Vistas.Cliente.VistaAltaClienteEmpresa;
import Modelodediseņo.Presentacion.Vistas.Factura.VistaAltaFactura;
import Modelodediseņo.Presentacion.Vistas.Producto.VistaAltaProducto;
import Modelodediseņo.Presentacion.Vistas.Cliente.VistaModificarClienteParticular;
import Modelodediseņo.Presentacion.Vistas.Cliente.VistaModificarClienteEmpresa;
import Modelodediseņo.Presentacion.Vistas.Producto.VistaModificarProducto;
import Modelodediseņo.Presentacion.Vistas.Cliente.VistaBajaCliente;
import Modelodediseņo.Presentacion.Vistas.Producto.VistaBajaProducto;
import Modelodediseņo.Presentacion.Vistas.Factura.VistaDevolucionDeProductosEnFactura;
import Modelodediseņo.Presentacion.Vistas.Cliente.VistaListarClientes;
import Modelodediseņo.Presentacion.Vistas.Producto.VistaListarProductos;
import Modelodediseņo.Presentacion.Vistas.Factura.VistaListarFacturas;
import Modelodediseņo.Presentacion.Vistas.Cliente.VistaMostrarCliente;
import Modelodediseņo.Presentacion.Vistas.Departamento.VistaAltaDepartamento;
import Modelodediseņo.Presentacion.Vistas.Departamento.VistaBajaDepartamento;
import Modelodediseņo.Presentacion.Vistas.Departamento.VistaCalcularNomina;
import Modelodediseņo.Presentacion.Vistas.Departamento.VistaEmpleadosPorDepartamento;
import Modelodediseņo.Presentacion.Vistas.Departamento.VistaListarDepartamentos;
import Modelodediseņo.Presentacion.Vistas.Departamento.VistaModificarDepartamento;
import Modelodediseņo.Presentacion.Vistas.Departamento.VistaMostrarDepartamento;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaAltaEmpleadoComercial;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaAltaEmpleadoRepartidor;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaAsignarDepartamento;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaBajaEmpleado;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaDesasignarDepartamento;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaEventosPorEmpleado;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaListarEmpleados;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaMejorEmpleado;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaModificarEmpleadoComercial;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaModificarEmpleadoRepartidor;
import Modelodediseņo.Presentacion.Vistas.Empleado.VistaMostrarEmpleado;
import Modelodediseņo.Presentacion.Vistas.Evento.VistaAltaEvento;
import Modelodediseņo.Presentacion.Vistas.Evento.VistaAsignarEmpleado;
import Modelodediseņo.Presentacion.Vistas.Evento.VistaBajaEvento;
import Modelodediseņo.Presentacion.Vistas.Evento.VistaDesasignarEmpleado;
import Modelodediseņo.Presentacion.Vistas.Evento.VistaEmpleadosPorEvento;
import Modelodediseņo.Presentacion.Vistas.Evento.VistaListarEventos;
import Modelodediseņo.Presentacion.Vistas.Evento.VistaModificarEvento;
import Modelodediseņo.Presentacion.Vistas.Evento.VistaMostrarEvento;
import Modelodediseņo.Presentacion.Vistas.Producto.VistaMostrarProducto;
import Modelodediseņo.Presentacion.Vistas.Factura.VistaMostrarFactura;
import Modelodediseņo.Presentacion.Vistas.Imp.SwingPrincipalViewImp;
import Modelodediseņo.Presentacion.Vistas.Cliente.VistaConsultarHistorialDeFacturas;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class SwingPrincipalView extends JFrame {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static SwingPrincipalView instancia;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static SwingPrincipalView getInstancia() 
	{
		if (instancia == null)
        	instancia = new SwingPrincipalViewImp();       
        return instancia; 
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaAltaClienteParticular selectVistaAltaClienteParticular();
	
	/**
	 * 
	 */
	public abstract void setVistaAltaClienteParticular(int id_vista);

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaAltaClienteEmpresa selectVistaAltaClienteEmpresa();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaAltaFactura selectVistaAltaFactura();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaAltaProducto selectVistaAltaProducto();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaModificarClienteParticular selectVistaModificarClienteParticular();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaModificarClienteEmpresa selectVistaModificarClienteEmpresa();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaModificarProducto selectVistaModificarProducto();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaBajaCliente selectVistaBajaCliente();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaBajaProducto selectVistaBajaProducto();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaDevolucionDeProductosEnFactura selectVistaDevolucionDeProductosEnFactura();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaListarClientes selectVistaListarClientes();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaListarProductos selectVistaListarProductos();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaListarFacturas selectVistaListarFacturas();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaMostrarCliente selectVistaMostarCliente();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaMostrarProducto selectVistaMostrarProducto();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaMostrarFactura selectVistaMostrarFactura();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract VistaConsultarHistorialDeFacturas selectVistaConsultarHistoriaDeFacturas();
	
	public abstract VistaAltaDepartamento selectVistaAltaDepartamento();
	public abstract VistaBajaDepartamento selectVistaBajaDepartamento();
	public abstract VistaModificarDepartamento selectVistaModificarDepartamento();
	public abstract VistaMostrarDepartamento selectVistaMostrarDepartamento();
	public abstract VistaListarDepartamentos selectVistaListarDepartamentos();
	public abstract VistaCalcularNomina selectVistaCalcularNomina();
	public abstract VistaEmpleadosPorDepartamento selectVistaEmpleadosPorDepartamento();
	
	public abstract VistaEventosPorEmpleado selectVistaEventosPorEmpleado();
	public abstract VistaAltaEmpleadoComercial selectVistaAltaEmpleadoComercial();
	public abstract VistaAltaEmpleadoRepartidor selectVistaAltaEmpleadoRepartidor();
	public abstract VistaBajaEmpleado selectVistaBajaEmpleado();
	public abstract VistaModificarEmpleadoComercial selectVistaModificarEmpleadoComercial();
	public abstract VistaModificarEmpleadoRepartidor selectVistaModificarEmpleadoRepartidor();
	public abstract VistaMostrarEmpleado selectVistaMostrarEmpleado();
	public abstract VistaListarEmpleados selectVistaListarEmpleados();
	public abstract VistaAsignarDepartamento selectVistaAsignarDepartamento();
	public abstract VistaDesasignarDepartamento selectVistaDesasignarDepartamento();
	public abstract VistaMejorEmpleado selectVistaMejorEmpleado();
	
	public abstract VistaAltaEvento selectVistaAltaEvento();
	public abstract VistaBajaEvento selectVistaBajaEvento();
	public abstract VistaModificarEvento selectVistaModificarEvento();
	public abstract VistaMostrarEvento selectVistaMostrarEvento();
	public abstract VistaListarEventos selectVistaListarEventos();
	public abstract VistaAsignarEmpleado selectVistaAsignarEmpleado();
	public abstract VistaDesasignarEmpleado selectVistaDesasignarEmpleado();
	public abstract VistaEmpleadosPorEvento selectVistaEmpleadosPorEvento();

	
	
	
}
