package Modelodedise�o.Presentacion.Controlador.comandos.Empleado;

import java.util.Collection;

import Modelodedise�o.Negocio.Empleado.SAEmpleado.SAEmpleado;
import Modelodedise�o.Negocio.Evento.EmpleadosPorEvento;
import Modelodedise�o.Negocio.FactoriaSA.FactoriaSA;
import Modelodedise�o.Presentacion.Controlador.comandos.Comando;
import Modelodedise�o.Presentacion.Controlador.comandos.RespuestaComando;

public class ComandoEventosPorEmpleado implements Comando
{
	
	private Object datos;
	
	static final int idVistas = 50;

	@Override
	public RespuestaComando execute() {
		// TODO Auto-generated method stub
		SAEmpleado sa = FactoriaSA.getInstancia().crearSAEmpleado();
		Collection<EmpleadosPorEvento> lista = sa.eventosPorEmpleado((Integer) datos);
		RespuestaComando rComando = new RespuestaComando ();
		rComando.setDatos(lista);
		rComando.setId(idVistas);
		return rComando;
	}

	@Override
	public void setdata(Object datos) {
		// TODO Auto-generated method stub
		this.datos = datos;
	}

}
