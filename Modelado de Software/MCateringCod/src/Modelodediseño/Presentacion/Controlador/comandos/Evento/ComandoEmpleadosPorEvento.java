package Modelodediseño.Presentacion.Controlador.comandos.Evento;

import java.util.Collection;

import Modelodediseño.Negocio.Evento.EmpleadosPorEvento;
import Modelodediseño.Negocio.Evento.SAEvento.SAEvento;
import Modelodediseño.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseño.Presentacion.Controlador.comandos.Comando;
import Modelodediseño.Presentacion.Controlador.comandos.RespuestaComando;

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
