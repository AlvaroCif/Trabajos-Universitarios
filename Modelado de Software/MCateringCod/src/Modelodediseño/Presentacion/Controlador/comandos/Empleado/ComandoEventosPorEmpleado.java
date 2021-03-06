package Modelodediseņo.Presentacion.Controlador.comandos.Empleado;

import java.util.Collection;

import Modelodediseņo.Negocio.Empleado.SAEmpleado.SAEmpleado;
import Modelodediseņo.Negocio.Evento.EmpleadosPorEvento;
import Modelodediseņo.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseņo.Presentacion.Controlador.comandos.Comando;
import Modelodediseņo.Presentacion.Controlador.comandos.RespuestaComando;

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
