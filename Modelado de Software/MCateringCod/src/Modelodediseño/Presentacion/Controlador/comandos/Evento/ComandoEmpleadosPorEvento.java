package Modelodediseņo.Presentacion.Controlador.comandos.Evento;

import java.util.Collection;

import Modelodediseņo.Negocio.Evento.EmpleadosPorEvento;
import Modelodediseņo.Negocio.Evento.SAEvento.SAEvento;
import Modelodediseņo.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseņo.Presentacion.Controlador.comandos.Comando;
import Modelodediseņo.Presentacion.Controlador.comandos.RespuestaComando;

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
