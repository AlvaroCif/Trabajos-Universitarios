package Modelodediseño.Presentacion.Controlador.comandos.Empleado;

import Modelodediseño.Negocio.Empleado.Empleado;
import Modelodediseño.Negocio.Empleado.SAEmpleado.SAEmpleado;
import Modelodediseño.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseño.Presentacion.Controlador.comandos.Comando;
import Modelodediseño.Presentacion.Controlador.comandos.RespuestaComando;

public class ComandoDesasignarDepartamento implements Comando
{

	private Object datos;
	
	static final int idVistas = 59;
	
	@Override
	public RespuestaComando execute() 
	{
		// TODO Auto-generated method stub
		SAEmpleado sa = FactoriaSA.getInstancia().crearSAEmpleado();
		Integer id = (Integer) datos;
		int correcto = sa.desasignarDepartamento(id);
		RespuestaComando rComando = new RespuestaComando ();
		int correcto_aux = new Integer (correcto);
		rComando.setDatos(correcto_aux);
		rComando.setId(idVistas);
		
		return rComando;
	}

	@Override
	public void setdata(Object datos) 
	{
		// TODO Auto-generated method stub
		this.datos = datos;
	}

}
