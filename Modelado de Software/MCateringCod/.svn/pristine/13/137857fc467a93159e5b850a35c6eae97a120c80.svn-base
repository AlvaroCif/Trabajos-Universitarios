package Modelodediseño.Presentacion.Controlador.comandos.Empleado;

import java.util.Collection;
import java.util.Iterator;

import Modelodediseño.Negocio.Empleado.Empleado;
import Modelodediseño.Negocio.Empleado.SAEmpleado.SAEmpleado;
import Modelodediseño.Negocio.FactoriaSA.FactoriaSA;
import Modelodediseño.Presentacion.Controlador.comandos.Comando;
import Modelodediseño.Presentacion.Controlador.comandos.RespuestaComando;

public class ComandoAsignarDepartamento implements Comando 
{
	
	private Object datos;

	static final int idVistas = 58;
	@Override
	public RespuestaComando execute() 
	{
		// TODO Auto-generated method stub
		SAEmpleado sa = FactoriaSA.getInstancia().crearSAEmpleado();
		//Empleado emp = (Empleado) datos;
		Collection<Integer> col = (Collection<Integer>) datos;
		Iterator it = col.iterator();
		int idEmpleado = (Integer) it.next();
		int idDepartamento = (Integer) it.next();
		int correcto = sa.asignarDepartamento(idEmpleado,idDepartamento);
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
