/**
 * 
 */
package Modelodediseño.Presentacion.Vistas.Imp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Modelodediseño.Presentacion.Vistas.SwingPrincipalView;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaAltaClienteParticular;
import Modelodediseño.Presentacion.Vistas.Factura.VistaAltaFactura;
import Modelodediseño.Presentacion.Vistas.Producto.VistaAltaProducto;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaModificarClienteParticular;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaModificarClienteEmpresa;
import Modelodediseño.Presentacion.Vistas.Producto.VistaModificarProducto;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaBajaCliente;
import Modelodediseño.Presentacion.Vistas.Factura.VistaDevolucionDeProductosEnFactura;
import Modelodediseño.Presentacion.Vistas.Producto.VistaBajaProducto;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaListarClientes;
import Modelodediseño.Presentacion.Vistas.Factura.VistaListarFacturas;
import Modelodediseño.Presentacion.Vistas.Producto.VistaListarProductos;
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
import Modelodediseño.Presentacion.Vistas.Factoria.Imp.FactoryVistaImp;
import Modelodediseño.Presentacion.Vistas.Producto.VistaMostrarProducto;
import Modelodediseño.Presentacion.Vistas.Factura.VistaMostrarFactura;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaConsultarHistorialDeFacturas;
import Modelodediseño.Presentacion.Vistas.Cliente.VistaAltaClienteEmpresa;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SwingPrincipalViewImp extends SwingPrincipalView 
{
	
	public SwingPrincipalViewImp() { 
		
		this.setTitle("Modelado de Catering");
		super.setSize(800, 450);
		//ImageIcon img = new ImageIcon("logoms.png");
		//this.setIconImage(img.getImage());
		setIconImage (new ImageIcon(getClass().getResource("logoms.png")).getImage());
		JMenuBar menuBar = new JMenuBar();
		JPanel panelMenu = new JPanel();
		JPanel panelPrincipal = new ImagenFondo("logo_MCatering.jpg");
		JPanel panelUnico = new JPanel();
		panelMenu.setLayout(new BorderLayout());

		/*
		 *+++++++++++++++++++++++++
		 *+     Menu Clientes     +
		 *+++++++++++++++++++++++++
		 */
		JMenu clientes = new JMenu("Clientes");
		clientes.setFont(new java.awt.Font("Courier New", 0, 12));
		menuBar.add(clientes);
	
		JMenuItem altaClienteParticular = new JMenuItem("Alta Cliente Particular");
		altaClienteParticular.setFont(new java.awt.Font("Courier New", 0, 12));
		clientes.add(altaClienteParticular);
		
		JMenuItem altaClienteEmpresa = new JMenuItem("Alta Cliente Empresa");
		altaClienteEmpresa.setFont(new java.awt.Font("Courier New", 0, 12));
		clientes.add(altaClienteEmpresa);
		
		JMenuItem bajaCliente = new JMenuItem("Baja Cliente");
		bajaCliente.setFont(new java.awt.Font("Courier New", 0, 12));
		clientes.add(bajaCliente);
		
		JMenuItem modificarClienteParticular = new JMenuItem("Modificar Cliente Particular");
		modificarClienteParticular.setFont(new java.awt.Font("Courier New", 0, 12));
		clientes.add(modificarClienteParticular);
		
		JMenuItem modificarClienteEmpresa = new JMenuItem("Modificar Cliente Empresa");
		modificarClienteEmpresa.setFont(new java.awt.Font("Courier New", 0, 12));
		clientes.add(modificarClienteEmpresa);
		
		JMenuItem mostrarCliente = new JMenuItem("Mostrar Cliente");
		mostrarCliente.setFont(new java.awt.Font("Courier New", 0, 12));
		clientes.add(mostrarCliente);
		
		JMenuItem listarClientes = new JMenuItem("Listar Clientes");
		listarClientes.setFont(new java.awt.Font("Courier New", 0, 12));
		clientes.add(listarClientes);
		
		JMenuItem consultarHistorialFacturas = new JMenuItem("Consultar Historial de Facturas");
		consultarHistorialFacturas.setFont(new java.awt.Font("Courier New", 0, 12));
		clientes.add(consultarHistorialFacturas);
		

		
		/*
		 *+++++++++++++++++++++++++
		 *+     Menu Facturas     +
		 *+++++++++++++++++++++++++
		 */
		JMenu facturas = new JMenu("Facturas");
		facturas.setFont(new java.awt.Font("Courier New", 0, 12));
		menuBar.add(facturas);
	
		JMenuItem altaFactura = new JMenuItem("Alta Factura");
		altaFactura.setFont(new java.awt.Font("Courier New", 0, 12));
		facturas.add(altaFactura);
		
		JMenuItem devolucionProductosFactura = new JMenuItem("Devolucion de Productos");
		devolucionProductosFactura.setFont(new java.awt.Font("Courier New", 0, 12));
		facturas.add(devolucionProductosFactura);
		
		JMenuItem mostrarFactura = new JMenuItem("Mostrar Factura");
		mostrarFactura.setFont(new java.awt.Font("Courier New", 0, 12));
		facturas.add(mostrarFactura);
		
		JMenuItem listarFacturas = new JMenuItem("Listar Facturas");
		listarFacturas.setFont(new java.awt.Font("Courier New", 0, 12));
		facturas.add(listarFacturas);
		
		
		
		/*
		 *++++++++++++++++++++++++++
		 *+     Menu Productos     +
		 *++++++++++++++++++++++++++
		 */
		JMenu productos = new JMenu("Productos");
		productos.setFont(new java.awt.Font("Courier New", 0, 12));
		menuBar.add(productos);
	
		JMenuItem altaProducto = new JMenuItem("Alta Producto");
		altaProducto.setFont(new java.awt.Font("Courier New", 0, 12));
		productos.add(altaProducto);
		
		JMenuItem bajaProducto = new JMenuItem("Baja Producto");
		bajaProducto.setFont(new java.awt.Font("Courier New", 0, 12));
		productos.add(bajaProducto);
		
		JMenuItem modificarProducto = new JMenuItem("Modificar Producto");
		modificarProducto.setFont(new java.awt.Font("Courier New", 0, 12));
		productos.add(modificarProducto);
		
		JMenuItem mostrarProducto = new JMenuItem("Mostrar Producto");
		mostrarProducto.setFont(new java.awt.Font("Courier New", 0, 12));
		productos.add(mostrarProducto);
		
		JMenuItem listarProductos = new JMenuItem("Listar Productos");
		listarProductos.setFont(new java.awt.Font("Courier New", 0, 12));
		productos.add(listarProductos);
		
		/*
		 *++++++++++++++++++++++++++
		 *+     Menu Departamentos     +
		 *++++++++++++++++++++++++++
		 */
		JMenu departamentos = new JMenu("Departamentos");
		departamentos.setFont(new java.awt.Font("Courier New", 0, 12));
		menuBar.add(departamentos);
	
		JMenuItem altaDepartamento = new JMenuItem("Alta Departamento");
		altaDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		departamentos.add(altaDepartamento);
		
		JMenuItem bajaDepartamento = new JMenuItem("Baja Departamento");
		bajaDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		departamentos.add(bajaDepartamento);
		
		JMenuItem modificarDepartamento = new JMenuItem("Modificar Departamento");
		modificarDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		departamentos.add(modificarDepartamento);
		
		JMenuItem mostrarDepartamento = new JMenuItem("Mostrar Departamento");
		mostrarDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		departamentos.add(mostrarDepartamento);
		
		JMenuItem listarDepartamentos = new JMenuItem("Listar Departamentos");
		listarDepartamentos.setFont(new java.awt.Font("Courier New", 0, 12));
		departamentos.add(listarDepartamentos);
		
		JMenuItem listarEmpleadosPorDepartamento = new JMenuItem("Listar Empleados por Departamento");
		listarEmpleadosPorDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		departamentos.add(listarEmpleadosPorDepartamento);
		
		JMenuItem calcularNomina = new JMenuItem("Calcular Nomina");
		calcularNomina.setFont(new java.awt.Font("Courier New", 0, 12));
		departamentos.add(calcularNomina);
		
		/*
		 *++++++++++++++++++++++++++
		 *+     Menu Empleados     +
		 *++++++++++++++++++++++++++
		 */
		JMenu empleados = new JMenu("Empleados");
		empleados.setFont(new java.awt.Font("Courier New", 0, 12));
		menuBar.add(empleados);
	
		JMenuItem altaEmpleadoComercial = new JMenuItem("Alta Empleado Comercial");
		altaEmpleadoComercial.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(altaEmpleadoComercial);
		
		JMenuItem altaEmpleadoRepartidor = new JMenuItem("Alta Empleado Repartidor");
		altaEmpleadoRepartidor.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(altaEmpleadoRepartidor);
		
		JMenuItem bajaEmpleado = new JMenuItem("Baja Empleado");
		bajaEmpleado.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(bajaEmpleado);
		
		JMenuItem modificarEmpleadoComercial = new JMenuItem("Modificar Empleado Comercial");
		modificarEmpleadoComercial.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(modificarEmpleadoComercial);
		
		JMenuItem modificarEmpleadoRepartidor = new JMenuItem("Modificar Empleado Repartidor");
		modificarEmpleadoRepartidor.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(modificarEmpleadoRepartidor);
		
		JMenuItem mostrarEmpleado = new JMenuItem("Mostrar Empleado");
		mostrarEmpleado.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(mostrarEmpleado);
		
		JMenuItem listarEmpleados = new JMenuItem("Listar Empleados");
		listarEmpleados.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(listarEmpleados);
		
		JMenuItem eventosPorEmpleado = new JMenuItem("Listar Eventos por Empleado");
		eventosPorEmpleado.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(eventosPorEmpleado);
		
		JMenuItem asignarDepartamento = new JMenuItem("Asignar Departamento");
		asignarDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(asignarDepartamento);
		
		JMenuItem desasignarDepartamento = new JMenuItem("Desasignar Departamento");
		desasignarDepartamento.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(desasignarDepartamento);
		
		JMenuItem mejorEmpleado = new JMenuItem("Mejor Empleado");
		mejorEmpleado.setFont(new java.awt.Font("Courier New", 0, 12));
		empleados.add(mejorEmpleado);
		
		/*
		 *++++++++++++++++++++++++++
		 *+     Menu Eventos    +
		 *++++++++++++++++++++++++++
		 */
		JMenu eventos = new JMenu("Eventos");
		eventos.setFont(new java.awt.Font("Courier New", 0, 12));
		menuBar.add(eventos);
	
		JMenuItem altaEvento = new JMenuItem("Alta Evento");
		altaEvento.setFont(new java.awt.Font("Courier New", 0, 12));
		eventos.add(altaEvento);
		
		JMenuItem bajaEvento = new JMenuItem("Baja Evento");
		bajaEvento.setFont(new java.awt.Font("Courier New", 0, 12));
		eventos.add(bajaEvento);
		
		JMenuItem modificarEvento = new JMenuItem("Modificar Evento");
		modificarEvento.setFont(new java.awt.Font("Courier New", 0, 12));
		eventos.add(modificarEvento);
		
		JMenuItem mostrarEvento = new JMenuItem("Mostrar Evento");
		mostrarEvento.setFont(new java.awt.Font("Courier New", 0, 12));
		eventos.add(mostrarEvento);
		
		JMenuItem listarEventos = new JMenuItem("Listar Eventos");
		listarEventos.setFont(new java.awt.Font("Courier New", 0, 12));
		eventos.add(listarEventos);
		
		JMenuItem empleadosPorEvento = new JMenuItem("Listar Empleados por Evento");
		empleadosPorEvento.setFont(new java.awt.Font("Courier New", 0, 12));
		eventos.add(empleadosPorEvento);
		
		JMenuItem asignarEmpleado = new JMenuItem("Asignar Empleado");
		asignarEmpleado.setFont(new java.awt.Font("Courier New", 0, 12));
		eventos.add(asignarEmpleado);
		
		JMenuItem desasignarEmpleado = new JMenuItem("Desasignar Empleado");
		desasignarEmpleado.setFont(new java.awt.Font("Courier New", 0, 12));
		eventos.add(desasignarEmpleado);
		
		
		
		/*
		 *++++++++++++++++++++++++++
		 *+     Menu Listeners     +
		 *++++++++++++++++++++++++++
		 */
		listenersMenu(altaClienteParticular, altaClienteEmpresa, bajaCliente, modificarClienteParticular, 
						modificarClienteEmpresa, mostrarCliente, listarClientes, consultarHistorialFacturas, 
						altaFactura, devolucionProductosFactura, mostrarFactura, listarFacturas, 
						altaProducto, bajaProducto, modificarProducto, mostrarProducto, listarProductos,
						altaDepartamento,bajaDepartamento,modificarDepartamento,mostrarDepartamento,
						listarDepartamentos, listarEmpleadosPorDepartamento,calcularNomina,
						altaEmpleadoComercial,altaEmpleadoRepartidor,bajaEmpleado,modificarEmpleadoComercial,
						modificarEmpleadoRepartidor,mostrarEmpleado,listarEmpleados,eventosPorEmpleado,asignarDepartamento,desasignarDepartamento, mejorEmpleado,
						altaEvento,bajaEvento,modificarEvento,mostrarEvento,listarEventos,empleadosPorEvento,asignarEmpleado,
						desasignarEmpleado);
		
		
		panelMenu.add(menuBar,BorderLayout.CENTER);
		panelUnico.setLayout(new BorderLayout());
		panelUnico.add(panelMenu,BorderLayout.NORTH);
		panelUnico.add(panelPrincipal,BorderLayout.CENTER);
		this.getContentPane().add(panelUnico);
	
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	
	
	public void borrarVentana()
	{
		this.setVisible(false);
		this.dispose(); 
	}
	
	
	
	private void listenersMenu(JMenuItem altaClienteParticular, JMenuItem altaClienteEmpresa, JMenuItem bajaCliente,
			JMenuItem modificarClienteParticular, JMenuItem modificarClienteEmpresa, JMenuItem mostrarCliente,
			JMenuItem listarClientes, JMenuItem consultarHistorialFacturas, JMenuItem altaFactura,
			JMenuItem devolucionProductosFactura, JMenuItem mostrarFactura, JMenuItem listarFacturas,
			JMenuItem altaProducto, JMenuItem bajaProducto, JMenuItem modificarProducto, JMenuItem mostrarProducto,
			JMenuItem listarProductos,JMenuItem altaDepartamento, JMenuItem bajaDepartamento,
			JMenuItem modificarDepartamento, JMenuItem mostrarDepartamento,
			JMenuItem listarDepartamentos, JMenuItem listarEmpleadosPorDepartamento,JMenuItem calcularNomina, JMenuItem altaEmpleadoComercial,
			JMenuItem altaEmpleadoRepartidor, JMenuItem bajaEmpleado, JMenuItem modificarEmpleadoComercial, 
			JMenuItem modificarEmpleadoRepartidor,JMenuItem mostrarEmpleado, JMenuItem listarEmpleados, JMenuItem eventosPorEmpleado,
			JMenuItem asignarDepartamento,JMenuItem desasignarDepartamento, JMenuItem mejorEmpleado,
			JMenuItem altaEvento, JMenuItem bajaEvento, JMenuItem modificarEvento, JMenuItem mostrarEvento, 
			JMenuItem listarEventos, JMenuItem empleadosPorEvento, JMenuItem asignarEmpleado, JMenuItem desasignarEmpleado ) {
		

		// TODO Auto-generated method stub
		ActionListener action = new ActionListener() 
		{ 
				

			

			public void actionPerformed(ActionEvent e) 
			{
				int numVista = 0;
				//borrarVentana();
			
				if (e.getActionCommand() == "Alta Cliente Particular")
				{
					numVista = 11;
					setVistaAltaClienteParticular (numVista);
					vistaAltaClienteParticular.mostrar();
				}
				else if (e.getActionCommand() == "Alta Cliente Empresa")
				{
					numVista = 12;
					setVistaAltaClienteEmpresa (numVista);
					vistaAltaClienteEmpresa.mostrar();
				}
				else if (e.getActionCommand() == "Baja Cliente")
				{
					numVista = 13;
					setVistaBajaCliente (numVista);
					vistaBajaCliente.mostrar();
				}
				else if (e.getActionCommand() == "Modificar Cliente Particular")
				{
					numVista = 14;
					setVistaModificarClienteParticular (numVista);
					vistaModificarClienteParticular.mostrar();
				}
				else if (e.getActionCommand() == "Modificar Cliente Empresa")
				{
					numVista = 15;
					setVistaModificarClienteEmpresa (numVista);
					vistaModificarClienteEmpresa.mostrar();
				}
				else if (e.getActionCommand() == "Mostrar Cliente")
				{
					numVista = 16;
					setVistaMostrarCliente (numVista);
					vistaMostrarCliente.mostrar();
				}
				else if (e.getActionCommand() == "Listar Clientes")
				{
					numVista = 17;
					setVistaListarClientes (numVista);
					vistaListarClientes.mostrar();
				}
				else if (e.getActionCommand() == "Consultar Historial de Facturas")
				{
					numVista = 18;
					setVistaConsultarHistorialDeFacturas (numVista);
					vistaConsultarHistorialDeFacturas.mostrar();
				}
				else if (e.getActionCommand() == "Alta Factura")
				{
					numVista = 21;
					setVistaAltaFactura (numVista);
					vistaAltaFactura.mostrar();
				}
				else if (e.getActionCommand() == "Devolucion de Productos")
				{
					numVista = 22;
					setVistaDevolucionDeProductosEnFactura (numVista);
					vistaDevolucionDeProductosEnFactura.mostrar();
				}
				else if (e.getActionCommand() == "Mostrar Factura")
				{
					numVista = 23;
					setVistaMostrarFactura (numVista);
					vistaMostrarFactura.mostrar();
				}
				else if (e.getActionCommand() == "Listar Facturas")
				{
					numVista = 24;
					setVistaListarFacturas (numVista);
					vistaListarFacturas.mostrar();
				}
				else if (e.getActionCommand() == "Alta Producto")
				{
					numVista = 31;
					setVistaAltaProducto (numVista);
					vistaAltaProducto.mostrar();
				}
				else if (e.getActionCommand() == "Baja Producto")
				{
					numVista = 32;
					setVistaBajaProducto (numVista);
					vistaBajaProducto.mostrar();
				}
				else if (e.getActionCommand() == "Modificar Producto")
				{
					numVista = 33;
					setVistaModificarProducto (numVista);
					vistaModificarProducto.mostrar();
				}
				else if (e.getActionCommand() == "Mostrar Producto")
				{
					numVista = 34;
					setVistaMostrarProducto (numVista);
					vistaMostrarProducto.mostrar();
				}
				else if (e.getActionCommand() == "Listar Productos")
				{
					numVista = 35;
					setVistaListarProductos (numVista);
					vistaListarProductos.mostrar();
				}
				else if (e.getActionCommand() == "Alta Departamento")
				{
					numVista = 41;
					setVistaAltaDepartamento (numVista);
					vistaAltaDepartamento.mostrar();
				}
				else if (e.getActionCommand() == "Baja Departamento")
				{
					numVista = 42;
					setVistaBajaDepartamento (numVista);
					vistaBajaDepartamento.mostrar();
				}
				else if (e.getActionCommand() == "Modificar Departamento")
				{
					numVista = 43;
					setVistaModificarDepartamento (numVista);
					vistaModificarDepartamento.mostrar();
				}
				else if (e.getActionCommand() == "Mostrar Departamento")
				{
					numVista = 44;
					setVistaMostrarDepartamento (numVista);
					vistaMostrarDepartamento.mostrar();
				}
				else if (e.getActionCommand() == "Listar Departamentos")
				{
					numVista = 45;
					setVistaListarDepartamentos (numVista);
					vistaListarDepartamentos.mostrar();
				}
				else if (e.getActionCommand() == "Calcular Nomina")
				{
					numVista = 46;
					setVistaCalcularNomina (numVista);
					vistaCalcularNomina.mostrar();
				}
				
				else if (e.getActionCommand() == "Listar Empleados por Departamento")
				{
					numVista = 47;
					setVistaEmpleadosPorDepartamento (numVista);
					vistaEmpleadosPorDepartamento.mostrar();
				}
				
				else if (e.getActionCommand() == "Listar Eventos por Empleado")
				{
					numVista = 50;
					setVistaEventosPorEmpleado (numVista);
					vistaEventosPorEmpleado.mostrar();
				}
				else if (e.getActionCommand() == "Alta Empleado Comercial")
				{
					numVista = 51;
					setVistaAltaEmpleadoComercial (numVista);
					vistaAltaEmpleadoComercial.mostrar();
				}
				else if (e.getActionCommand() == "Alta Empleado Repartidor")
				{
					numVista = 52;
					setVistaAltaEmpleadoRepartidor (numVista);
					vistaAltaEmpleadoRepartidor.mostrar();
				}
				else if (e.getActionCommand() == "Baja Empleado")
				{
					numVista = 53;
					setVistaBajaEmpleado (numVista);
					vistaBajaEmpleado.mostrar();
				}
				else if (e.getActionCommand() == "Modificar Empleado Comercial")
				{
					numVista = 54;
					setVistaModificarEmpleadoComercial (numVista);
					vistaModificarEmpleadoComercial.mostrar();
				}
				else if (e.getActionCommand() == "Modificar Empleado Repartidor")
				{
					numVista = 55;
					setVistaModificarEmpleadoRepartidor (numVista);
					vistaModificarEmpleadoRepartidor.mostrar();
				}
				else if (e.getActionCommand() == "Mostrar Empleado")
				{
					numVista = 56;
					setVistaMostrarEmpleado (numVista);
					vistaMostrarEmpleado.mostrar();
				}
				else if (e.getActionCommand() == "Listar Empleados")
				{
					numVista = 57;
					setVistaListarEmpleados (numVista);
					vistaListarEmpleados.mostrar();
				}
				else if (e.getActionCommand() == "Asignar Departamento")
				{
					numVista = 58;
					setVistaAsignarDepartamento (numVista);
					vistaAsignarDepartamento.mostrar();
				}
				else if (e.getActionCommand() == "Desasignar Departamento")
				{
					numVista = 59;
					setVistaDesasignarDepartamento (numVista);
					vistaDesasignarDepartamento.mostrar();
				}
				else if (e.getActionCommand() == "Mejor Empleado")
				{
					numVista = 500;
					setVistaMejorEmpleado (numVista);
					vistaMejorEmpleado.mostrar();
				}
				else if (e.getActionCommand() == "Alta Evento")
				{
					numVista = 61;
					setVistaAltaEvento (numVista);
					vistaAltaEvento.mostrar();
				}
				else if (e.getActionCommand() == "Baja Evento")
				{
					numVista = 62;
					setVistaBajaEvento (numVista);
					vistaBajaEvento.mostrar();
				}
				else if (e.getActionCommand() == "Modificar Evento")
				{
					numVista = 63;
					setVistaModificarEvento (numVista);
					vistaModificarEvento.mostrar();
				}
				else if (e.getActionCommand() == "Mostrar Evento")
				{
					numVista = 64;
					setVistaMostrarEvento (numVista);
					vistaMostrarEvento.mostrar();
				}
				else if (e.getActionCommand() == "Listar Eventos")
				{
					numVista = 65;
					setVistaListarEventos (numVista);
					vistaListarEventos.mostrar();
				}
				else if (e.getActionCommand() == "Asignar Empleado")
				{
					numVista = 66;
					setVistaAsignarEmpleado (numVista);
					vistaAsignarEmpleado.mostrar();
				}
				else if (e.getActionCommand() == "Desasignar Empleado")
				{
					numVista = 67;
					setVistaDesasignarEmpleado (numVista);
					vistaDesasignarEmpleado.mostrar();
				}
				else if (e.getActionCommand() == "Listar Empleados por Evento")
				{
					numVista = 68;
					setVistaEmpleadosPorEvento (numVista);
					vistaEmpleadosPorEvento.mostrar();
				}
				
				/*{
					 
					//Clientes
					case "Alta Cliente Particular":

					break;  
					case "Alta Cliente Empresa":

					break;  
					case "Baja Cliente":

					break;  
					case "Modificar Cliente Particular":

					break;  
					case "Modificar Cliente Empresa":

					break;  
					case "Mostrar Cliente":

					break;  
					case "Listar Clientes":

					break;  
					case "Consultar Historial de Facturas":

					break;  
					//Facturas	
					case "Alta Factura":

					break;  
					case "Devolucion de Productos":

					break;  
					case "Mostrar Factura":

					break;  
					case "Listar Facturas":

					break;	
					//Productos
					case "Alta Producto":

					break;  
					case "Baja Producto":

					break;  
					case "Modificar Producto":

					break;	
					case "Mostrar Producto":

					break;	
					case "Listar Productos":
						
					break;
				}*/
			}
			

			
		};	
		
		//Clientes
		altaClienteParticular.addActionListener(action); 
		altaClienteEmpresa.addActionListener(action); 
		bajaCliente.addActionListener(action); 
		modificarClienteParticular.addActionListener(action); 
		modificarClienteEmpresa.addActionListener(action);
		mostrarCliente.addActionListener(action);
		listarClientes.addActionListener(action);
		consultarHistorialFacturas.addActionListener(action);
		
		//Facturas
		altaFactura.addActionListener(action); 
		devolucionProductosFactura.addActionListener(action); 
		mostrarFactura.addActionListener(action); 
		listarFacturas.addActionListener(action);
		
		//Productos
		altaProducto.addActionListener(action) ; 
		bajaProducto.addActionListener(action) ; 
		modificarProducto.addActionListener(action) ; 
		mostrarProducto.addActionListener(action) ; 
		listarProductos.addActionListener(action) ;
		
		//Departamentos
		altaDepartamento.addActionListener(action) ; 
		bajaDepartamento.addActionListener(action) ; 
		modificarDepartamento.addActionListener(action) ; 
		mostrarDepartamento.addActionListener(action) ; 
		listarDepartamentos.addActionListener(action) ;
		calcularNomina.addActionListener(action);
		listarEmpleadosPorDepartamento.addActionListener(action);
		
		//Empleados
		altaEmpleadoComercial.addActionListener(action) ; 
		altaEmpleadoRepartidor.addActionListener(action) ;
		bajaEmpleado.addActionListener(action) ; 
		modificarEmpleadoComercial.addActionListener(action) ;
		modificarEmpleadoRepartidor.addActionListener(action) ; 
		mostrarEmpleado.addActionListener(action) ; 
		listarEmpleados.addActionListener(action) ;
		asignarDepartamento.addActionListener(action);
		desasignarDepartamento.addActionListener(action);
		eventosPorEmpleado.addActionListener(action);
		mejorEmpleado.addActionListener(action);
		
		//Eventos
		altaEvento.addActionListener(action) ; 
		bajaEvento.addActionListener(action) ;
		modificarEvento.addActionListener(action) ; 
		mostrarEvento.addActionListener(action) ;
		listarEventos.addActionListener(action) ; 
		asignarEmpleado.addActionListener(action) ; 
		desasignarEmpleado.addActionListener(action) ;
		empleadosPorEvento.addActionListener(action);
		
	}
	
	
	public void Action(ActionEvent e, Object objeto) {}

	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private VistaAltaClienteParticular vistaAltaClienteParticular;
	
	private VistaAltaClienteEmpresa vistaAltaClienteEmpresa;
	
	private VistaAltaFactura vistaAltaFactura;
	
	private VistaAltaProducto vistaAltaProducto;
	
	private VistaModificarClienteParticular vistaModificarClienteParticular;
	
	private VistaModificarClienteEmpresa vistaModificarClienteEmpresa;
	
	private VistaModificarProducto vistaModificarProducto;
	
	private VistaBajaCliente vistaBajaCliente;
	
	private VistaDevolucionDeProductosEnFactura vistaDevolucionDeProductosEnFactura;
	
	private VistaBajaProducto vistaBajaProducto;
	
	private VistaListarClientes vistaListarClientes;
	
	private VistaListarFacturas vistaListarFacturas;
	
	private VistaListarProductos vistaListarProductos;
	
	private VistaMostrarCliente vistaMostrarCliente;
	
	private VistaMostrarProducto vistaMostrarProducto;
	
	private VistaMostrarFactura vistaMostrarFactura;
	
	private VistaConsultarHistorialDeFacturas vistaConsultarHistorialDeFacturas;
	
	private VistaAltaDepartamento vistaAltaDepartamento;
	private VistaBajaDepartamento vistaBajaDepartamento;
	private VistaModificarDepartamento vistaModificarDepartamento;
	private VistaMostrarDepartamento vistaMostrarDepartamento;
	private VistaListarDepartamentos vistaListarDepartamentos;
	private VistaCalcularNomina vistaCalcularNomina;
	private VistaEmpleadosPorDepartamento vistaEmpleadosPorDepartamento;
	
	private VistaAltaEmpleadoComercial vistaAltaEmpleadoComercial;
	private VistaAltaEmpleadoRepartidor vistaAltaEmpleadoRepartidor;
	private VistaBajaEmpleado vistaBajaEmpleado;
	private VistaModificarEmpleadoComercial vistaModificarEmpleadoComercial;
	private VistaModificarEmpleadoRepartidor vistaModificarEmpleadoRepartidor;
	private VistaMostrarEmpleado vistaMostrarEmpleado;
	private VistaListarEmpleados vistaListarEmpleados;
	private VistaAsignarDepartamento vistaAsignarDepartamento;
	private VistaDesasignarDepartamento vistaDesasignarDepartamento;
	private VistaEventosPorEmpleado vistaEventosPorEmpleado;
	private VistaMejorEmpleado vistaMejorEmpleado;
	
	private VistaAltaEvento vistaAltaEvento;
	private VistaBajaEvento vistaBajaEvento;
	private VistaModificarEvento vistaModificarEvento;
	private VistaMostrarEvento vistaMostrarEvento;
	private VistaListarEventos vistaListarEventos;
	private VistaAsignarEmpleado vistaAsignarEmpleado;
	private VistaDesasignarEmpleado vistaDesasignarEmpleado;
	private VistaEmpleadosPorEvento vistaEmpleadosPorEvento;
	
	public VistaAltaClienteParticular selectVistaAltaClienteParticular() 
	{
		return this.vistaAltaClienteParticular;
	}
	
	/**
	 * 
	 */
	public void setVistaAltaClienteParticular(int id_vista)
	{
		this.vistaAltaClienteParticular = (VistaAltaClienteParticular) new FactoryVistaImp().crearVista(id_vista);
	}

	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaAltaClienteEmpresa()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaAltaClienteEmpresa selectVistaAltaClienteEmpresa() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaAltaClienteEmpresa;
		// end-user-code
	}

	public void setVistaAltaClienteEmpresa (int id_vista)
	{
		this.vistaAltaClienteEmpresa = (VistaAltaClienteEmpresa) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaAltaFactura()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaAltaFactura selectVistaAltaFactura() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaAltaFactura;
		// end-user-code
	}

	public void setVistaAltaFactura (int id_vista)
	{
		this.vistaAltaFactura = (VistaAltaFactura) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaAltaProducto()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaAltaProducto selectVistaAltaProducto() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaAltaProducto;
		// end-user-code
	}

	public void setVistaAltaProducto (int id_vista)
	{
		this.vistaAltaProducto = (VistaAltaProducto) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaModificarClienteParticular()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaModificarClienteParticular selectVistaModificarClienteParticular() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaModificarClienteParticular;
		// end-user-code
	}

	public void setVistaModificarClienteParticular (int id_vista)
	{
		this.vistaModificarClienteParticular = (VistaModificarClienteParticular) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaModificarClienteEmpresa()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaModificarClienteEmpresa selectVistaModificarClienteEmpresa() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaModificarClienteEmpresa;
		// end-user-code
	}

	public void setVistaModificarClienteEmpresa (int id_vista)
	{
		this.vistaModificarClienteEmpresa = (VistaModificarClienteEmpresa) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selecrVistaModificarProducto()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaModificarProducto selectVistaModificarProducto() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaModificarProducto;
		// end-user-code
	}

	public void setVistaModificarProducto (int id_vista)
	{
		this.vistaModificarProducto = (VistaModificarProducto) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaBajaCliente()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaBajaCliente selectVistaBajaCliente() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaBajaCliente;
		// end-user-code
	}

	public void setVistaBajaCliente (int id_vista)
	{
		this.vistaBajaCliente = (VistaBajaCliente) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaBajaProducto()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaBajaProducto selectVistaBajaProducto() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaBajaProducto;
		// end-user-code
	}
	
	public void setVistaBajaProducto (int id_vista)
	{
		this.vistaBajaProducto = (VistaBajaProducto) new FactoryVistaImp().crearVista(id_vista);
	}

	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaBajaFactura()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaDevolucionDeProductosEnFactura selectVistaDevolucionDeProductosEnFactura() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaDevolucionDeProductosEnFactura;
		// end-user-code
	}

	public void setVistaDevolucionDeProductosEnFactura (int id_vista)
	{
		this.vistaDevolucionDeProductosEnFactura = (VistaDevolucionDeProductosEnFactura) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaListarClientes()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaListarClientes selectVistaListarClientes() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaListarClientes;
		// end-user-code
	}

	public void setVistaListarClientes (int id_vista)
	{
		this.vistaListarClientes = (VistaListarClientes) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaListarProductos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaListarProductos selectVistaListarProductos() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaListarProductos;
		// end-user-code
	}

	public void setVistaListarProductos (int id_vista)
	{
		this.vistaListarProductos = (VistaListarProductos) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaListarFacturas()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaListarFacturas selectVistaListarFacturas() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaListarFacturas;
		// end-user-code
	}

	public void setVistaListarFacturas (int id_vista)
	{
		this.vistaListarFacturas = (VistaListarFacturas) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaMostarCliente()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaMostrarCliente selectVistaMostarCliente() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaMostrarCliente;
		// end-user-code
	}

	public void setVistaMostrarCliente (int id_vista)
	{
		this.vistaMostrarCliente = (VistaMostrarCliente) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaMostrarProducto()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaMostrarProducto selectVistaMostrarProducto() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaMostrarProducto;
		// end-user-code
	}

	public void setVistaMostrarProducto (int id_vista)
	{
		this.vistaMostrarProducto = (VistaMostrarProducto) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaMostrarFactura()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaMostrarFactura selectVistaMostrarFactura() 
	{
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return this.vistaMostrarFactura;
		// end-user-code
	}

	public void setVistaMostrarFactura (int id_vista)
	{
		this.vistaMostrarFactura = (VistaMostrarFactura) new FactoryVistaImp().crearVista(id_vista);
	}
	
	/** 
	 * (sin Javadoc)
	 * @see SwingPrincipalView#selectVistaConsultarHistoriaDeFacturas()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaConsultarHistorialDeFacturas selectVistaConsultarHistoriaDeFacturas() 
	{
		
		return this.vistaConsultarHistorialDeFacturas;
		
	}
	
	public void setVistaConsultarHistorialDeFacturas (int id_vista)
	{
		this.vistaConsultarHistorialDeFacturas = (VistaConsultarHistorialDeFacturas) new FactoryVistaImp().crearVista(id_vista);
	}
	
	public VistaAltaDepartamento selectVistaAltaDepartamento() 
	{
		
		return this.vistaAltaDepartamento;
		
	}
	
	private void setVistaAltaDepartamento(int id_vista) {
	
		this.vistaAltaDepartamento = (VistaAltaDepartamento) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaBajaDepartamento selectVistaBajaDepartamento() 
	{
		
		return this.vistaBajaDepartamento;
		
	}
	
	private void setVistaBajaDepartamento(int id_vista) {
		
		this.vistaBajaDepartamento = (VistaBajaDepartamento) new FactoryVistaImp().crearVista(id_vista);

		
	}
	
	public VistaModificarDepartamento selectVistaModificarDepartamento() 
	{
		
		return this.vistaModificarDepartamento;
		
	}
	
	private void setVistaModificarDepartamento(int id_vista) {
		
		this.vistaModificarDepartamento = (VistaModificarDepartamento) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaMostrarDepartamento selectVistaMostrarDepartamento() 
	{
		
		return this.vistaMostrarDepartamento;
		
	}
	
	private void setVistaMostrarDepartamento(int id_vista) {
		
		this.vistaMostrarDepartamento = (VistaMostrarDepartamento) new FactoryVistaImp().crearVista(id_vista);

		
	}
	
	public VistaListarDepartamentos selectVistaListarDepartamentos() 
	{
		
		return this.vistaListarDepartamentos;
		
	}
	
	private void setVistaListarDepartamentos(int id_vista) {
		
		this.vistaListarDepartamentos = (VistaListarDepartamentos) new FactoryVistaImp().crearVista(id_vista);

		
	}
	
	public VistaCalcularNomina selectVistaCalcularNomina() 
	{
		
		return this.vistaCalcularNomina;
		
	}

	private void setVistaCalcularNomina(int id_vista) {
		
		this.vistaCalcularNomina = (VistaCalcularNomina) new FactoryVistaImp().crearVista(id_vista);

		
	}
	
	public VistaAltaEmpleadoComercial selectVistaAltaEmpleadoComercial() 
	{
		
		return this.vistaAltaEmpleadoComercial;
		
	}
	
	private void setVistaAltaEmpleadoComercial(int id_vista) {
		
		this.vistaAltaEmpleadoComercial = (VistaAltaEmpleadoComercial) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaAltaEmpleadoRepartidor selectVistaAltaEmpleadoRepartidor () 
	{
		
		return this.vistaAltaEmpleadoRepartidor ;
		
	}
	
	private void setVistaAltaEmpleadoRepartidor(int id_vista) {
		
		this.vistaAltaEmpleadoRepartidor = (VistaAltaEmpleadoRepartidor) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaBajaEmpleado selectVistaBajaEmpleado () 
	{
		
		return this.vistaBajaEmpleado ;
		
	}
	
	
	
	private void setVistaBajaEmpleado(int id_vista) {
		
		this.vistaBajaEmpleado = (VistaBajaEmpleado) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaModificarEmpleadoComercial selectVistaModificarEmpleadoComercial () 
	{
		
		return this.vistaModificarEmpleadoComercial;
		
	}
	
	private void setVistaModificarEmpleadoComercial(int id_vista) {
		
		this.vistaModificarEmpleadoComercial = (VistaModificarEmpleadoComercial) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaModificarEmpleadoRepartidor selectVistaModificarEmpleadoRepartidor () 
	{
		
		return this.vistaModificarEmpleadoRepartidor ;
		
	}
	
	private void setVistaModificarEmpleadoRepartidor(int id_vista) {
		
		this.vistaModificarEmpleadoRepartidor = (VistaModificarEmpleadoRepartidor) new FactoryVistaImp().crearVista(id_vista);
		
	}

	public VistaMostrarEmpleado selectVistaMostrarEmpleado () 
	{
		
		return this.vistaMostrarEmpleado ;
		
	}
	
	private void setVistaMostrarEmpleado(int id_vista) {
		
		this.vistaMostrarEmpleado = (VistaMostrarEmpleado) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaListarEmpleados selectVistaListarEmpleados () 
	{
		
		return this.vistaListarEmpleados ;
		
	}

	private void setVistaListarEmpleados(int id_vista) {
		
		this.vistaListarEmpleados = (VistaListarEmpleados) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaAsignarDepartamento selectVistaAsignarDepartamento () 
	{
		
		return this.vistaAsignarDepartamento ;
		
	}

	private void setVistaAsignarDepartamento(int id_vista) {
		
		this.vistaAsignarDepartamento = (VistaAsignarDepartamento) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaDesasignarDepartamento selectVistaDesasignarDepartamento () 
	{
		
		return this.vistaDesasignarDepartamento ;
		
	}

	private void setVistaDesasignarDepartamento(int id_vista) {
		
		this.vistaDesasignarDepartamento = (VistaDesasignarDepartamento) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaAltaEvento selectVistaAltaEvento () 
	{
		
		return this.vistaAltaEvento ;
		
	}

	private void setVistaAltaEvento(int id_vista) {
		
		this.vistaAltaEvento = (VistaAltaEvento) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaBajaEvento selectVistaBajaEvento () 
	{
		
		return this.vistaBajaEvento ;
		
	}

	private void setVistaBajaEvento(int id_vista) {
		
		this.vistaBajaEvento = (VistaBajaEvento) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaModificarEvento selectVistaModificarEvento () 
	{
		
		return this.vistaModificarEvento ;
		
	}

	private void setVistaModificarEvento(int id_vista) {
		
		this.vistaModificarEvento = (VistaModificarEvento) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaMostrarEvento selectVistaMostrarEvento () 
	{
		
		return this.vistaMostrarEvento ;
		
	}

	private void setVistaMostrarEvento (int id_vista) {
		
		this.vistaMostrarEvento = (VistaMostrarEvento) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaListarEventos selectVistaListarEventos () 
	{
		
		return this.vistaListarEventos ;
		
	}

	private void setVistaListarEventos(int id_vista) {
		
		this.vistaListarEventos = (VistaListarEventos) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaAsignarEmpleado selectVistaAsignarEmpleado () 
	{
		
		return this.vistaAsignarEmpleado ;
		
	}

	private void setVistaAsignarEmpleado(int id_vista) {
		
		this.vistaAsignarEmpleado = (VistaAsignarEmpleado) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public VistaDesasignarEmpleado selectVistaDesasignarEmpleado () 
	{
		
		return this.vistaDesasignarEmpleado ;
		
	}

	private void setVistaDesasignarEmpleado(int id_vista) {
		
		this.vistaDesasignarEmpleado = (VistaDesasignarEmpleado) new FactoryVistaImp().crearVista(id_vista);
		
	}
	
	public static void main(String[] args) 
	{
		SwingPrincipalView v = new SwingPrincipalViewImp();
		
	}



	@Override
	public VistaEmpleadosPorDepartamento selectVistaEmpleadosPorDepartamento() {
		// TODO Auto-generated method stub
		return this.vistaEmpleadosPorDepartamento;
	}

	public void setVistaEmpleadosPorDepartamento (int id_vista)
	{
		this.vistaEmpleadosPorDepartamento = (VistaEmpleadosPorDepartamento) new FactoryVistaImp().crearVista(id_vista);
	}

	@Override
	public VistaEventosPorEmpleado selectVistaEventosPorEmpleado() {
		// TODO Auto-generated method stub
		return this.vistaEventosPorEmpleado;
	}
	
	public void setVistaEventosPorEmpleado (int id_vista)
	{
		this.vistaEventosPorEmpleado = (VistaEventosPorEmpleado) new FactoryVistaImp().crearVista(id_vista);
	}

	@Override
	public VistaEmpleadosPorEvento selectVistaEmpleadosPorEvento() {
		// TODO Auto-generated method stub
		return this.vistaEmpleadosPorEvento;
	}
	
	public void setVistaEmpleadosPorEvento(int id_vista)
	{
		this.vistaEmpleadosPorEvento = (VistaEmpleadosPorEvento) new FactoryVistaImp().crearVista(id_vista);
	}
	@Override
	public VistaMejorEmpleado selectVistaMejorEmpleado ()
	{
		return this.vistaMejorEmpleado;
	}
	
	public void setVistaMejorEmpleado (int id_vista)
	{
		this.vistaMejorEmpleado = (VistaMejorEmpleado) new FactoryVistaImp().crearVista(id_vista);
	}

	
}
