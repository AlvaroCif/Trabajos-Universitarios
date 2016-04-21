package Modelodedise�o.Presentacion.Controlador.comandos.Evento;

import java.util.Collection;

import Modelodedise�o.Negocio.Evento.EmpleadosPorEvento;
import Modelodedise�o.Negocio.Evento.SAEvento.SAEvento;
import Modelodedise�o.Negocio.FactoriaSA.FactoriaSA;
import Modelodedise�o.Presentacion.Controlador.comandos.Comando;
import Modelodedise�o.Presentacion.Controlador.comandos.RespuestaComando;

public class ComandoEmpleadosPorEvento implements Comando
{
	
	private Object datos;
	
	static final int idVistas = 68;

	@Override
	public RespuestaComando execute() {
		// TODO Auto-generated method stub
		SAEvento sa = FactoriaSA.getInstancia().crearSAEvento();
		Collection<EmpleadosPorEvento> lista = sa.empleadosPorEvento((Integer) datos);
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
